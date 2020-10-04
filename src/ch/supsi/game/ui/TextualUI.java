package ch.supsi.game.ui;

import ch.supsi.game.ui.elements.players.Player;

public class TextualUI {
	public static String start(char symbol) {
		return "Inizia il giocatore " + symbol;
	}
	
	public static String turn(Player player, int remainingMoves) {
		return "Turno di: " + player.getSymbol() + " (" + player + ") | ancora " + remainingMoves + " mosse";
	}
	
	public static String menu() {
		return "\nScegli direzione (wasd) oppure 0 per uscire:";
	}
	
	public static String rollDice(String player, int roll) {
		return "Giocatore " + player + ": lancia dado e esce " + roll;
	}
	
	public static String winRollDice(String winner) {
		return "Vince: " + winner;
	}
	
	public static String useGem(String player) {
		return "Giocatore " + player + ": Vuoi usare una gemma per teletrasportarti via?\n\t1 - Si\n\t0 - No";
	}
	
	public static String usePotion(String player) {
		return "Giocatore " + player + ": Vuoi usare una pozione per vincere la sfida?\n\t1 - Si\n\t0 - No";
	}
	
	public static String penality() {
		return "Hai delle penalita, non potrai fare una mossa";
	}
	
	public static String remainingPenalities(int penalities) {
		return "penalita rimaste: " + penalities;
	}
	
	public static String obstacle() {
		return "Hai incontrato un ostacolo";
	}

	public static String obstacleAvoided() {
		return "Hai evitato l'ostacolo grazie al tuo potere magico";
	}

	public static String treeDangerous() {
		return "L'albero ti a schiacciato";
	}

	public static String treePenality() {
		return "Non potrai muoverti per un turno";
	}
	
	public static String rock() {
		return "Ripetere la mossa, ostacolo invalicabile";
	}
	
	public static String rockDangerous() {
		return "La roccia e' esplosa";
	}
	
	public static String fight() {
		return "\nParte la sfida..";
	}
	
	public static String fight(Player player, int value) {
		return player.getSymbol() + " ottiene un punteggio di " + value;
	}
	
	public static String chooseClass(char symbol) {
		StringBuilder sb = new StringBuilder();
		sb.append("Scegliere razza per giocatore " + symbol + ":\n");
		sb.append("1 - Elfo\n");
		sb.append("2 - Guerriero\n");
		sb.append("3 - Gigante\n");
		sb.append("4 - Mago\n");
		return sb.toString();
	}
	
	public static String infoPlayer(Player player) {
		return "Giocatore " + player.getSymbol() + " (" + player + "):\t" 
				+ player.getCoins() + " monete\t" 
				+ player.getGems() + " gemme\t" 
				+ player.getPotions() + " pozioni";
	}
	
	public static String end(String winner) {
		return "\nGioco finito\nIl vincitore e': " + winner;
	}
	
}
