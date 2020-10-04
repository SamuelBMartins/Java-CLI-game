package ch.supsi.game.ui.elements.players;

import ch.supsi.game.logic.Constants;

/**
 * @author Samuel
 *
 *Il gigante e la razza con la velocita piu bassa, fara quindi lanci di dado scadenti
 *
 *Il gigante e la razza con il potere magico piu bassa, sara quindi improbabile che salti degli ostacoli
 *
 *Il gigante è la razza piu forte, è probabile che vinca gli scontri contro altri giocatori
 */
public class Giant extends Player {
	public static final int SPEED = Constants.GIANT_SPEED;
	public static final int MAGIC_POWER = Constants.GIANT_MAGIC_POWER;
	public static final int STRENGHT = Constants.GIANT_STRENGHT;

	public Giant(char symbol, int x, int y) {
		super(symbol, x, y, SPEED, MAGIC_POWER, STRENGHT);
	}
	
	@Override
	public String toString() {
		return "Gigante";
	}

}
