package ch.supsi.game.ui.elements;

import ch.supsi.game.logic.Constants;
import ch.supsi.game.logic.GameLogic;
import ch.supsi.game.ui.elements.players.Player;

public class Gem extends Element {
	public static final int N_INITIAL_GEMS = Constants.N_INITIAL_GEMS;
	private static final char SYMBOL = '%';
	
	public Gem() {
		super(SYMBOL);
	}

	@Override
	public void collision(GameLogic logic, Player player, int newY, int newX) {
		super.collision(logic, player, newY, newX);
		player.setGems(player.getGems() + 1);
	}	
}
