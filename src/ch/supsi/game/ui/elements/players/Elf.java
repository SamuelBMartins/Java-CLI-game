package ch.supsi.game.ui.elements.players;

import ch.supsi.game.logic.Constants;

/**
 * @author Samuel
 *
 *L'elfo è la razza piu veloce, puo quindi fare un lancio di dado migliore
 *
 *L'elfo ha un potere magico piu alto del gigante e del guerrirero ma piu basso del mago
 *ha quindi una buona probabilita di saltare un ostacolo
 *
 *L'elfo ha una forza piu alta del mago ma piu bassa del guerriere e del orco, 
 *ha quindi una bassa probabilita di vincere gli scontri con altri giocatori
 */
public class Elf extends Player {
	public static final int SPEED = Constants.ELF_SPEED;
	public static final int MAGIC_POWER = Constants.ELF_MAGIC_POWER;
	public static final int STRENGHT = Constants.ELF_STRENGHT;

	public Elf(char symbol, int x, int y) {
		super(symbol, x, y, SPEED, MAGIC_POWER, STRENGHT);
	}

	@Override
	public String toString() {
		return "Elfo";
	}
	
}
