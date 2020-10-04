package ch.supsi.game.ui.elements;

import ch.supsi.game.logic.Constants;
import ch.supsi.game.logic.GameLogic;
import ch.supsi.game.ui.elements.players.Player;

public class Coin extends Element {
	public static final int N_INITIAL_COINS = Constants.N_INITIAL_COINS;
	private static final char SYMBOL = '$';
	public static int valueTot = 0;
	
	private final int value;
	
	public Coin() {
		super(SYMBOL);
		value = (int) (Math.random() * 3) + 1;
		valueTot += getValue();
	}
	
	private int getValue() {
		return value;
	}

	@Override
	public void collision(GameLogic logic, Player player, int newY, int newX) {
		super.collision(logic, player, newY, newX);
		player.setCoins(player.getCoins() + getValue());
	}
	
}
