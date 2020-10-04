package ch.supsi.game.ui;

import ch.supsi.game.logic.Constants;
import ch.supsi.game.logic.GameLogic;

public class Board {
	private final int length = Constants.BOARD_LENGTH;
	private final int height = Constants.BOARD_HEIGHT;
	
	private final GameLogic logic;
		
	
	public Board() {
		super();
		logic = new GameLogic(length, height);
	}

	private int getLength() {
		return length;
	}

	private int getHeight() {
		return height;
	}

	public GameLogic getLogic() {
		return logic;
	}

	public void showGrid() {
		for (int i = 0; i < getLength() * 4 + 1; i++)
			System.out.print("-");
		System.out.println();
		
		for (int i = 0; i < getHeight(); i++) {
			System.out.print("|");
			for (int j = 0; j < getLength(); j++) {
				System.out.print(" ");
				
				logic.showCell(i, j);				
				System.out.print(" |");
			}
			System.out.println();
			
			for (int j = 0; j < getLength() * 4 + 1; j++)
				System.out.print("-");
			System.out.println();
		}
		System.out.println();
	}
	
}
