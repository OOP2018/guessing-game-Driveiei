package gameUI;
/**
 * Automatically find the answer of secret number to any NumberGame.
 * 
 * @author Kornphon Noiprasert
 */
public class GameSolver {

	public GameSolver() {

	}

	/**
	 * Play a NumberGame and return the solution of the answer to any NumberGame.
	 * 
	 * @param game is the number to solve
	 * @return the answer of anyNumberGame
	 */
	public int play(NumberGame game) {
		int lowerBound = 1;
		int upperBound = game.getUpperBound() + 1;
		int number = 0;
		boolean correct = true;
		while (correct) {
			number = lowerBound + (upperBound - lowerBound) / 2;
			correct = !game.guess(number);
			if (game.getMessage().contains("too small")) {
				lowerBound = number;
			} else {
				upperBound = number;
			}
		}
		return number;
	}
}
