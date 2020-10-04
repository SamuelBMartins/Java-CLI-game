package ch.supsi.game.ui.elements.players;

import ch.supsi.game.logic.Constants;

/**
 * @author Samuel
 *
 *Il guerrirero è piu veloce del gigante ma piu lento del mago e del elfo, fara quindi lanci di dado bassi
 *
 *Il guerriero ha un potere magico piu alto del gigante ma piu basso del mago e del elfo, 
 *ha un bassa probabilita di saltare un ostacolo
 *
 *Il guerriero ha un attacco piu alto del amgo e del elfo ma piu basso del orco, ha una buona probabilita di vincere gli scontri
 */
public class Warrior extends Player {
	public static final int SPEED = Constants.WARRIOR_SPEED;
	public static final int MAGIC_POWER = Constants.WARRIOR_MAGIC_POWER;
	public static final int STRENGHT = Constants.WARRIOR_STRENGHT;

	public Warrior(char symbol, int x, int y) {
		super(symbol, x, y, SPEED, MAGIC_POWER, STRENGHT);
	}

	@Override
	public String toString() {
		return "Guerr...";
	}
	
}
