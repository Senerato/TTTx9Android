package tttx9.tttx9;

/**
 * 
 * @author Senerato.
 *
 */
public class View {

	/**
	 * Function to update the UI. Gets a new gameState and a new
	 * Move to show.
	 * @param newGameState
	 */
	public void updateUi(tttx9.tttx9.TTTx9Game newTTTx9Game, tttx9.tttx9.GameState newGameState) {
		if (newTTTx9Game.getGameResult() == tttx9.tttx9.GameResult.UNFINISHED) {
			System.out.println("It is now player " + newTTTx9Game.getPlayerTurn() + "'s turn.");
		}
		System.out.println("\n" + newGameState.toString());
	}

}
