/**
 * Automatically find the answer of secret number to any NumberGame.
 * 
 * @author Kornphon Noiprasert
 */
public class GameSolver {
	
	public GameSolver(){
		
	}

	/**
	 * Play a NumberGame and return the solution of the answer to any NumberGame.
	 * 
	 * @param game is the number to solve
	 * @return the answer of anyNumberGame
	 */
	public int play(NumberGame game) {
		int lowerBound = 1;
		int upperBound = game.getUpperBound()+1;
		int number = lowerBound + (upperBound-lowerBound)/2;
		while (true) {
			if (game.guess(number)) {
				return number;
			} else if(game.getMessage().contains("bigger than")){
				lowerBound = number;
			} else {
				upperBound = number;
			}
			number = lowerBound + (upperBound-lowerBound)/2;
		}
	}
}
