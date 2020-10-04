package ch.supsi.game.ui.elements.players;

import ch.supsi.game.logic.Constants;

/**
 * @author Samuel
 *
 *Il mago è piu veloce del guerriero e del orco ma piu lento del elfo, fara buoni lanci di dado
 *
 *Il mago eè la razza con il potere magico piu alto, sara probabile saltare degli ostacoli
 *
 *Il mago è la razza con il piu basso valore di forza, sara difficile vincere scontri contro altri giocatori
 */
public class Wizard extends Player {
	public static final int SPEED = Constants.WIZARD_SPEED;
	public static final int MAGIC_POWER = Constants.WIZARD_MAGIC_POWER;
	public static final int STRENGHT = Constants.WIZARD_STRENGHT;

	public Wizard(char symbol, int x, int y) {
		super(symbol, x, y, SPEED, MAGIC_POWER, STRENGHT);
	}
	
	@Override
	public String toString() {
		return "Mago";
	}

}
