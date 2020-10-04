package ch.supsi.game.logic;

public class Dice {
	private static final int DICE_FACES_DEFAUTL = Constants.DICE_FACES_DEFAUTL;
	private final int facesDice;
	
	public Dice(int facesDice) {
		this.facesDice = facesDice;
	}
	
	public Dice() {
		this(DICE_FACES_DEFAUTL);
	}
	
	private int getFacesDice() {
		return facesDice;
	}

	/**
	 * Simula il lancio di un dado
	 * 
	 * @return il valore del dado
	 */
	public int rollDice()  {
		return (int) (Math.random() * getFacesDice() + 1);
	}
	
}
