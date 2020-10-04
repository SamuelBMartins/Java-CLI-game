package ch.supsi.game.test;

import java.util.Scanner;

import ch.supsi.game.logic.Game;
import ch.supsi.game.ui.TextualUI;
import ch.supsi.game.ui.elements.Tree;
import ch.supsi.game.ui.elements.Gem;
import ch.supsi.game.ui.elements.Coin;
import ch.supsi.game.ui.elements.Potion;
import ch.supsi.game.ui.elements.Rock;

public class TestGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Game game = new Game();
		int dice;
		
		game.addPlayers(input);
		game.addElement(Coin.N_INITIAL_COINS, () -> new Coin());
		game.addElement(Tree.N_INITIAL_TREES, () -> new Tree());
		game.addElement(Potion.N_INITIAL_POTIONS, () -> new Potion());
		game.addElement(Gem.N_INITIAL_GEMS, () -> new Gem());
		game.addElement(Rock.N_INITIAL_ROCKS, () -> new Rock());
		game.setActivePlayer();
		
		do {
			dice = game.rollDice();
			
			for (int i = 0; i < dice; i++) {
				System.out.println(TextualUI.turn(game.getActivePlayer(), dice - i));
				
				game.showGrid();
				game.infoPlayers();
				game.move(input);
				
				if (game.isGameFinished() || game.isTurnFinished()) break;
				System.out.println();
			}
			
			game.setActivePlayer();
		} while (!game.isGameFinished());
		input.close();
		
		System.out.println(TextualUI.end(game.winner()));
	}

}
