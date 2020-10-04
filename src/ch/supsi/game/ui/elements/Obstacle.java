package ch.supsi.game.ui.elements;

import ch.supsi.game.logic.GameLogic;
import ch.supsi.game.ui.elements.players.Player;

abstract public class Obstacle extends Element {
	private final boolean dangerous;
	private final int endurance;
	
	public Obstacle(char symbol) {
		super(symbol);
		dangerous = (int) (Math.random() * 5) == 1;
		endurance = (int) (Math.random() * 10);
	}

	protected boolean isDangerous() {
		return dangerous;
	}

	protected int getEndurance() {
		return endurance;
	}
	
	//permette di far usare alle classi figlie il metodo in Element
	@Override
	public void collision(GameLogic logic, Player player, int newY, int newX) {
		super.collision(logic, player, newY, newX);
	}
	
	/**
	 * Controlla se giocatore puo evitare penalita.
	 * Puo evitre la penalita se il suo potere magico e piu alto della resistenza del albero
	 * 
	 * @param player Giocatore su cui eseguire operazioni
	 * @return vero se puo evitare la penalita
	 */
	protected boolean playerCanAvoidObstacle(Player player) {
		return player.getMagicPower() > getEndurance();
	}
	
	
	/**
	 * Gestisce il comportamento del player che va contro l'ostacolo
	 * 
	 * @param logic riferimento alla logica per modificare griglia
	 * @param player Giocatore che è andato contro l'ostacol
	 */
	abstract protected void behaviorPlayer(GameLogic logic, Player player, int newY, int newX);

}
