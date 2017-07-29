package engine.tttx9;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Senerato.
 * Het model: ontvangt een player en managed de zetten.
 */
public class TTTx9Game
{
	private ArrayList<engine.tttx9.Player> players = new ArrayList<engine.tttx9.Player>();
	private engine.tttx9.Player hasTurn;
	private engine.tttx9.GameState gs;
	private engine.tttx9.Player winner;
	private engine.tttx9.GameResult gameResult = engine.tttx9.GameResult.UNFINISHED;

	/**
	 * Initiate ga game with two players.
	 * @param p1 player 1.
	 * @param p2 player 2.
	 */
	public TTTx9Game(engine.tttx9.Player p1, engine.tttx9.Player p2) {
		p1.setId(1);
		p2.setId(2);
		this.players.add(p1);
		this.players.add(p2);
		this.gs = new engine.tttx9.GameState();
		this.hasTurn = players.get((int) (Math.random() * 2)); // Specifies the player that currently
	}

	/**
	 * Play function. Runs the game, giving turns to both players
	 * while printing the game status.
	 */
	public void play() {
		while(gameResult == engine.tttx9.GameResult.UNFINISHED) {
			System.out.println(hasTurn + " performs turn");
			performTurn();
			checkGameStatus();
			hasTurn = players.get(hasTurn.getId() % 2);
		}
		//printGameSummary();
	}

	/**
	 * Checks if the game is still ongoing or if it has ended
	 * due to a player winning the game or because all possible
	 * moves are exhausted.
	 */
	private void checkGameStatus() {	
		// Check whether the game is finished:
		if (gs.checkForWinner(hasTurn) == engine.tttx9.GameResult.VICTORY) {
			this.gameResult = engine.tttx9.GameResult.VICTORY;
			this.winner = hasTurn;
			System.out.println(winner + " won the game!");
		}
		if (gs.allFieldsTaken())
			this.gameResult = engine.tttx9.GameResult.DRAW;
	}


	public engine.tttx9.GameResult getGameResult() {
		return this.gameResult;
	}

	/**
	 * Performs a turn.
	 */
	private void performTurn() {
		engine.tttx9.Move nextMove = nextPlayerMove();
		gs.submitMove(nextMove, hasTurn);
	}

	/**
	 * Gives another player a turn and returns the turn that player
	 * performs.
	 * @return the move the next player performs
	 */
	private engine.tttx9.Move nextPlayerMove() {
		String s = null;
		engine.tttx9.Move nextMove;
		if (hasTurn.getId() == 1) {
			if (gs.getLastMove() == null || gs.getNextSubGame().getWinner() != null)
				nextMove = players.get(0).nextFreeTurn(gs);
			else
				nextMove = players.get(0).nextTurn(gs);
		}
		else {
			if (gs.getLastMove() == null || gs.getNextSubGame().getWinner() != null)
				nextMove = players.get(1).nextFreeTurn(gs);
			else
				nextMove = players.get(1).nextTurn(gs);
		}
		if (gs.getLastMove() != null) // Set the allowed subgame. (In the first move, everything is allowed).
			if (gs.getNextSubGame().getWinner() == null) // If the subgame is not won, the move has to be the SingleField move of the previous move.
				nextMove.setSubGame(gs.getLastMove().getSingleField());
		return nextMove;
	}

	public engine.tttx9.Player getPlayerTurn() {
		return this.hasTurn;
	}

	public GameState getGameState() {
		return gs;
	}
}
