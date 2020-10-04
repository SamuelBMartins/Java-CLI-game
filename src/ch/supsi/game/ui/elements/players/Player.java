package ch.supsi.game.ui.elements.players;

import java.util.ArrayList;

import ch.supsi.game.logic.Constants;
import ch.supsi.game.logic.Dice;
import ch.supsi.game.logic.GameLogic;
import ch.supsi.game.ui.TextualUI;
import ch.supsi.game.ui.elements.Coin;
import ch.supsi.game.ui.elements.Element;

/**
 * @author samuel
 * 
 * Le caratteristiche velocita, forza, potere magico sono gestite in modo uguale per ogni classe
 * la velocita influenza il dado del giocatore
 * la forza influenza la probabilita di vittoria di un giocatore in una sfida
 * la magia di da la possibilita di supperare un ostacolo se il tuo potere magico e piu alto della resistenza del stacolo
 * la magia permette anche di evitare la morte se l'ostacolo potrebbe ucciderlo
 * 
 * per leggere i valori controllare la classe Constants
 */
abstract public class Player extends Element {	
	private static final int N_PLAYERS = Constants.N_PLAYERS;
	public static ArrayList<Player> players = new ArrayList<>(N_PLAYERS);
	
	private int x;
	private int y;
	private final int initX;
	private final int initY;
	
	private final Dice dice;
	private final int speed;
	private final int magicPower;
	private final int strength;

	private int coins = 0;
	private int gems = 0;
	private int potions = 0;
	private int penalties = 0;
	
	public Player(char symbol, int x, int y, int speed, int magicPower, int strenght) {
		super(symbol);
		setX(x);
		setY(y);
		initX = x;
		initY = y;
		this.speed = speed;
		this.magicPower = magicPower;
		this.strength = strenght;
		dice = new Dice(getSpeed());
		players.add(this);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	private int getInitX() {
		return initX;
	}

	private int getInitY() {
		return initY;
	}

	public Dice getDice() {
		return dice;
	}
	
	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	public int getGems() {
		return gems;
	}

	public void setGems(int gems) {
		this.gems = gems;
	}

	public int getPotions() {
		return potions;
	}

	public void setPotions(int potions) {
		this.potions = potions;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}

	public int getSpeed() {
		return speed;
	}

	public int getMagicPower() {
		return magicPower;
	}

	public int getStrenght() {
		return strength;
	}

	public static void infoPlayers() {
		for (Player player : players)
			System.out.println(TextualUI.infoPlayer(player));
		System.out.println();
	}
	
	public int rollDice() {
		int roll = getDice().rollDice();
		System.out.println(TextualUI.rollDice("" + getSymbol(), roll));
		return roll;
	}
	
	/**
	 * Genera una sfida contro un altro player
	 * 
	 * @param player
	 * @return
	 */
	public boolean winMatch(Player player) {
		System.out.println(TextualUI.fight());
		
		int actualPlayer = (int) (Math.random() * getStrenght());
		System.out.println(TextualUI.fight(this, actualPlayer));
		
		int opp = (int) (Math.random() * player.getStrenght());
		System.out.println(TextualUI.fight(player, opp));
		
		if (actualPlayer != opp)
			return actualPlayer > opp;
		else 
			return winMatch(player);
	}

	@Override
	public void collision(GameLogic logic, Player player, int newY, int newX) {
		logic.getCell()[player.getY()][player.getX()] = null;
		
		//chiedi se usare gemme
		if (getGems() > 0)
			if (useGem(logic, player, newY, newX)) return;
		
		//chiedi se usare pozioni
		boolean usePotion = false;
		if (player.getPotions() > 0) 
			usePotion = usePotion(logic, player);
		
		if (usePotion || !winMatch(player)) {
			if (getCoins() == 0) {
				dead(logic);
			} else {
				player.setCoins(player.getCoins() + 1);
				setCoins(getCoins() - 1);
				reposition(logic);
			}
			
			player.setX(newX);
			player.setY(newY);
			logic.getCell()[player.getY()][player.getX()] = player;
		} else {
			if (player.getCoins() == 0) {
				player.dead(logic);
				return;
			}
			
			setCoins(getCoins() + 1);
			player.setCoins(player.getCoins() - 1);
			player.reposition(logic);
		}
	}

	/**
	 * Gestisce la morte/sconfitta del player 
	 * 
	 * @param logic logica di gioco per modificare la griglia
	 */
	public void dead(GameLogic logic) {
		logic.getCell()[getY()][getX()] = null;
		players.remove(this);
		Coin.valueTot -= this.getCoins();
	}
	
	/**
	 * Riposiziona il giocatore in una delle posizioni iniziali di tutti i giocatori
	 * 
	 * @param logic Utilizzato per modificare griglia
	 */
	private void reposition(GameLogic logic) {
		//controlla se la propria posizione iniziale e libera
		if (logic.getCell()[getInitY()][getInitX()] == null) {
			logic.getCell()[getInitY()][getInitX()] = this;
			setX(getInitX());
			setY(getInitY());
			return;
		}
		
		//se la propria posizione iniziale non e libera controlla le altre
		for (Player player : players) {
			if (logic.getCell()[player.getInitY()][player.getInitX()] == null) {
				logic.getCell()[player.getInitY()][player.getInitX()] = this;
				setX(player.getInitX());
				setY(player.getInitY());
				return;
			}
		}
	}

	public boolean isDead() {
		return !players.contains(this);
	}
	
	private boolean usePotion(GameLogic logic, Player player) {
		int choice;
		
		do {
			System.out.println(TextualUI.usePotion(player.getSymbol() + ""));
			choice = logic.getScanner().nextInt();
			logic.getScanner().nextLine();
			if (choice == 1) {
				player.setPotions(player.getPotions() - 1);
				return true;
			}
		} while (choice != 0);
		return false;
	}
	
	private boolean useGem(GameLogic logic, Player player, int newY, int newX) {
		int choice;
		do {
			System.out.println(TextualUI.useGem(getSymbol() + ""));
			choice = logic.getScanner().nextInt();
			logic.getScanner().nextLine();
			if (choice == 1) {
				super.collision(logic, player, newY, newX);
				logic.addRandom(this);
				setGems(getGems() - 1);
				return true;
			}
		} while (choice != 0);
		return false;
	}

}
