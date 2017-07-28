package tttx9.tttx9;

import tttx9.tttx9.Controller;
import tttx9.tttx9.HumanPlayer;
import tttx9.tttx9.TTTx9Game;
import tttx9.tttx9_ai.IteratingAI;

/**
 * 
 * @author Senerato
 *	Main klasse.
 */
public class Main {

	public static void main(String[] args) {
		View view = new View();
		Player player = new IteratingAI("Iterating AI1");
		//Player player2 = new IteratingAI("Iterating AI2");
		Player player2 = new HumanPlayer("Human player");
		TTTx9Game ttt = new TTTx9Game(player, player2);
		Controller controller = new Controller(ttt, view);
		ttt.play();
	}

}
