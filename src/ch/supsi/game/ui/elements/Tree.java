package ch.supsi.game.ui.elements;

import ch.supsi.game.logic.Constants;
import ch.supsi.game.logic.GameLogic;
import ch.supsi.game.ui.TextualUI;
import ch.supsi.game.ui.elements.players.Player;

public class Tree extends Obstacle {
	public static final int N_INITIAL_TREES = Constants.N_INITIAL_TREES;
	private static final char SYMBOL = '#';

	public Tree() {
		super(SYMBOL);
	} 

	@Override
	public void collision(GameLogic logic, Player player, int newY, int newX) {
		System.out.println(TextualUI.obstacle());
		//utente clicca enter, dopo aver letto il messaggio
		logic.getScanner().nextLine();
		
		if (playerCanAvoidObstacle(player)) {
			System.out.println(TextualUI.obstacleAvoided());
			super.collision(logic, player, newY, newX);
			return;
		}
		
		behaviorPlayer(logic, player, newY, newX);
	}
	

	@Override
	protected void behaviorPlayer(GameLogic logic, Player player, int newY, int newX) {
		//al contrario della roccia, lalbero non scompare dopo aver ucciso il giocatore
		if (isDangerous()) {
			System.out.println(TextualUI.treeDangerous());
			player.dead(logic);
		} else {
			System.out.println(TextualUI.treePenality());
			player.setPenalties(player.getPenalties() + 1);
			
			//sposta il player nella casella
			super.collision(logic, player, newY, newX);
		}
	}
}
