package ch.supsi.game.logic;

import java.util.Scanner;

import ch.supsi.game.ui.TextualUI;
import ch.supsi.game.ui.elements.Element;
import ch.supsi.game.ui.elements.players.Elf;
import ch.supsi.game.ui.elements.players.Giant;
import ch.supsi.game.ui.elements.players.Player;
import ch.supsi.game.ui.elements.players.Warrior;
import ch.supsi.game.ui.elements.players.Wizard;

public class GameLogic {
	private Element[][] cell;
	private final int length;
	private final int height;
	private Scanner scanner;
	private boolean finished = false;
	
	public GameLogic(int length, int height) {
		this.length = length;
		this.height = height;
		setCell(new Element[height][length]);
	}
	
	public Element[][] getCell() {
		return cell;
	}

	private void setCell(Element[][] cell) {
		this.cell = cell;
	}

	public Scanner getScanner() {
		return scanner;
	}

	private void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public void addRandom(Element cell) {
		int line, column;
		
		do {
			line = (int) (Math.random() * height);
			column = (int) (Math.random() * length);
		} while (getCell()[line][column] != null);
		
		getCell()[line][column] = cell;
		
		if(cell instanceof Player) {
			((Player) cell).setX(column);
			((Player) cell).setY(line);
		}
	}
	
	public void addPlayer(char symbol, Scanner input) {
		Player player = null;
		int x = -1;
		int y = -1;
		int choose = -1;
		
		for (int[] position : Constants.INITIAL_POSITIONS) {
			if (getCell()[position[0]][position[1]] == null) {
				x = position[1];
				y = position[0];
				break;
			}
		}

		do {
			System.out.println(TextualUI.chooseClass(symbol));
			if (input.hasNextInt())
				choose = input.nextInt();
			else {
				input.nextLine();
				continue;
			}
			
			switch (choose) {
			case 1:
				player = new Elf(symbol, x, y);
				break;
			case 2:
				player = new Warrior(symbol, x, y);
				break;
			case 3:
				player = new Giant(symbol, x, y);
				break;
			case 4:
				player = new Wizard(symbol, x, y);
				break;

			default:
				break;
			}
		} while (choose < 1 || choose > 4);
		
		getCell()[y][x] = player;
	}
	
	public void showCell(int i, int j) {
		Element c = cell[i][j];
		if (c == null) {
			System.out.print(" ");
			return;
		} else
			System.out.print(c.getSymbol());
	}
	
	public void move(Player player, Scanner input) {
		if (scanner == null)
			setScanner(input);
		if(player.getPenalties() > 0) {
			System.out.println(TextualUI.penality());
			input.nextLine();
			player.setPenalties(player.getPenalties() - 1);
			System.out.println(TextualUI.remainingPenalities(player.getPenalties()));
			return;
		}
		char choice;
		int newY, newX;
		
		do {
			System.out.println(TextualUI.menu());
			
			choice = input.nextLine().toLowerCase().charAt(0);
			
		} while (choice != 'w' && choice != 'a' && choice != 's' && choice != 'd' && choice != '0');
		
		switch (choice) {
		case 'w':
			newY = (player.getY() - 1) < 0 ? player.getY() - 1 + height : (player.getY() - 1) % height;
			direction(player, newY, player.getX());
			break;
		case 'a':
			newX = (player.getX() - 1) < 0 ? player.getX() - 1 + length : (player.getX() - 1) % length;
			direction(player, player.getY(), newX);
			break;
		case 's':
			newY = (player.getY() + 1) % height;
			direction(player, newY, player.getX());
			break;
		case 'd':
			newX = (player.getX() + 1) % length;
			direction(player, player.getY(), newX);
			break;
		case '0':
			setFinished(true);
		}
		
	}
	
	private void direction(Player player, int newY, int newX) {
		if (cell[newY][newX] != null)
			cell[newY][newX].collision(this, player, newY, newX);
		else {
			getCell()[player.getY()][player.getX()] = null;
			
			player.setX(newX);
			player.setY(newY);
			getCell()[player.getY()][player.getX()] = player;
		}
			
	}
}
