package ch.supsi.game.ui.elements;

import ch.supsi.game.logic.Constants;
import ch.supsi.game.logic.GameLogic;
import ch.supsi.game.ui.elements.players.Player;

public class Potion extends Element {
	public static final int N_INITIAL_POTIONS = Constants.N_INITIAL_POTIONS;
	private static final char SYMBOL = '&';
	
	public Potion() {
		super(SYMBOL);
	} 

	@Override
	public void collision(GameLogic logic, Player player, int newY, int newX) {
		super.collision(logic, player, newY, newX);
		player.setPotions(player.getPotions() + 1);
	}
}
