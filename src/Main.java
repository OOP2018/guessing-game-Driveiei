/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 * 
 * @author Kornphon Noiprasert
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new KornphonGame(upperBound);
		GameConsole ui = new GameConsole();
		int solution = ui.play(game);
		System.out.println("play() returned " + solution);
		System.out.println("times() returned " + game.getCount());
	}
}
