package ch.supsi.game.ui.elements;

import ch.supsi.game.logic.GameLogic;
import ch.supsi.game.ui.elements.players.Player;

abstract public class Element {
	private final char symbol;

	public Element(char symbol) {
		super();
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}

	/**
	 * Gestisce la collisione di un player contro un oggetto element
	 * 
	 * @param logic logica di gioco per modificare la griglia
	 * @param player player contro cui si è scontrato
	 * @param newY la nuova posizione in Y del giocatore
	 * @param newX la nuova posizione in X del giocatore
	 */
	public void collision(GameLogic logic, Player player, int newY, int newX) {
		logic.getCell()[player.getY()][player.getX()] = null;
		
		player.setX(newX);
		player.setY(newY);
		logic.getCell()[player.getY()][player.getX()] = player;
	}
	
}
