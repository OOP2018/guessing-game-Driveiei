package gameUI;
import java.util.Scanner;

/**
 * Play guessing game on the console until your guessing is correct.
 * 
 * @author Kornphon Noiprasert
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		// describe the game
		System.out.println(game.toString());
		// This is just an example.
		System.out.println(game.getMessage());
		while (true) {
			System.out.print("Your answer? ");
			int guess = console.nextInt();
			boolean correct = game.guess(guess);
			System.out.println(game.getMessage());
			if (correct) {
				return guess;
			}
		}
	}
}
