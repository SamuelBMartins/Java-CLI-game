package ch.supsi.game.logic;

public class Constants {
	public static final int BOARD_LENGTH = 15;
	public static final int BOARD_HEIGHT = 15;

	public static final int N_PLAYERS = 4;
	public static final char[] SYMBOLS_PLAYERS = { 'X', 'Y', 'Z', 'W' };
	public static final int[][] INITIAL_POSITIONS = { 
			{ BOARD_HEIGHT - 1, 0 }, 
			{ 0, BOARD_LENGTH - 1 }, 
			{ BOARD_HEIGHT - 1, BOARD_LENGTH - 1 },
			{ 0, 0 } };

	public static final int ELF_SPEED = 7;
	public static final int ELF_MAGIC_POWER = 6;
	public static final int ELF_STRENGHT = 5;
	public static final int GIANT_SPEED = 4;
	public static final int GIANT_MAGIC_POWER = 4;
	public static final int GIANT_STRENGHT = 7;
	public static final int WARRIOR_SPEED = 5;
	public static final int WARRIOR_MAGIC_POWER = 5;
	public static final int WARRIOR_STRENGHT = 6;
	public static final int WIZARD_SPEED = 6;
	public static final int WIZARD_MAGIC_POWER = 7;
	public static final int WIZARD_STRENGHT = 4;

	public static final int DICE_FACES_DEFAUTL = 6;

	public static final int N_INITIAL_COINS = 10;
	public static final int N_INITIAL_GEMS = 5;
	public static final int N_INITIAL_POTIONS = 3;
	public static final int N_INITIAL_ROCKS = 5;
	public static final int N_INITIAL_TREES = 7;

}
