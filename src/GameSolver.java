/**
 * Automatically find the answer of secret number to any NumberGame.
 * 
 * @author Kornphon Noiprasert
 */
public class GameSolver {

	/**
	 * Play a NumberGame and return the solution of the answer to any NumberGame.
	 * 
	 * @param game is the number to solve
	 * @return the answer of anyNumberGame
	 */
	public int play(NumberGame game) {
		int lowerBound = 1;
		int upperBound = game.getUpperBound();
		while (true) {
			if (game.guess((lowerBound+upperBound)/2)) {
				return (lowerBound+upperBound)/2;
			} else if(game.getMessage().contains("bigger than")){
				lowerBound = (lowerBound+upperBound)/2;
			} else {
				upperBound = (lowerBound+upperBound)/2;
			}
		}
	}
}
