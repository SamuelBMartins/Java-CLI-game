package ch.supsi.game.logic;

import java.util.Scanner;

import ch.supsi.game.ui.TextualUI;
import ch.supsi.game.ui.Board;
import ch.supsi.game.ui.elements.Coin;
import ch.supsi.game.ui.elements.players.Player;

public class Game {
	private Player activePlayer;
	private final Board grid;
	
	public Game() {
		super();
		this.grid = new Board();
	}

	public Player getActivePlayer() {
		return activePlayer;
	}
	
	public void setActivePlayer() {
		if (activePlayer == null) {
			int random = (int) (Math.random() * Player.players.size());
			activePlayer = Player.players.get(random);
			System.out.println(TextualUI.start(activePlayer.getSymbol()));
		} else {
			int index = Player.players.indexOf(activePlayer);
			activePlayer = Player.players.get((index + 1) % Player.players.size());
		}
	}
	
	public boolean isGameFinished() {
		if (grid.getLogic().isFinished())
			return true;

		if (Player.players.size() <= 1)
			return true;
		
		for (Player player : Player.players)
			if (player.getCoins() == Coin.valueTot)
				return true;
		
		return false;
	}
	
	//lambda permette di generare oggetti diversi ad ogni iterazione del for
	public void addElement(int nElements, GenerateElement element) {
		for (int i = 0; i < nElements; i++) {
			grid.getLogic().addRandom(element.getElement());
		}
	}
	
	public void addPlayers(Scanner input) {
		for (int i = 0; i < Constants.N_PLAYERS; i++)
			grid.getLogic().addPlayer(Constants.SYMBOLS_PLAYERS[i], input);
		input.nextLine();
	}
	
	public void infoPlayers() {
		Player.infoPlayers();
	}
	
	public void showGrid() {
		grid.showGrid();
	}
	
	public void move(Scanner input) {
		grid.getLogic().move(getActivePlayer(), input);
	}
	
	public String winner() {
		if (Player.players.size() == 1) 
			return "" + Player.players.get(0).getSymbol();
		
		for (Player player : Player.players)
			if (player.getCoins() == Coin.valueTot)
				return "" + player.getSymbol();
			
		return "Nessuno";
	}
	
	public int rollDice() {
		return getActivePlayer().rollDice();
	}

	public boolean isTurnFinished() {
		return getActivePlayer().isDead();
	}
	
}
