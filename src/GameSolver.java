/**
 * Automatically find the answer of secret number to any NumberGame.
 */
public class GameSolver {
	
	/**
	 * Play a NumberGame and return the solution of the answer to any NumberGame.
	 * 
	 * @param game is the number to solve
	 * @return the answer of anyNumberGame
	 */
	public int play(NumberGame game) {
		int i = 0;
		while (true) {
			i++;
			if (i == game.getSecretNumber()) {
				System.out.print("The answer number is ");
				return game.getSecretNumber();
			}
		}
	}
}
