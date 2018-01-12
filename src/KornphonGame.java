import java.util.Random;

/*
 * Guessing number game that start with 1 and end with 500(if not set) or set number.
 * User must guess a number to find the answer of secret number.
 * 
 * @author Kornphon Noiprasert
 * */
public class KornphonGame extends NumberGame {
	/** upper bound for secret number */
	private int upperBound;
	/** the solution to the game */
	private int secretNumber;
	/** the number of times that user guesses */
	private int times = 0;

	/** Initialize a new default game. */
	public KornphonGame() {
		this(500);
		final int lowerBound = 1;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		secretNumber = rand.nextInt(this.upperBound) + 1;
		super.setMessage("Let's predict a number " + Integer.toString(lowerBound) + "-" + Integer.toString(upperBound));
	}

	/**
	 * Initialize a new game with maximum number that user set
	 * 
	 * @param upperBound is the maximum number of guesses number.
	 * */
	public KornphonGame(int upperBound) {
		final int lowerBound = 1;
		this.upperBound = upperBound;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		secretNumber = rand.nextInt(this.upperBound) + 1;
		super.setMessage("Let's predict a number " + Integer.toString(lowerBound) + "-" + Integer.toString(upperBound));
	}

	@Override
	/**
	 * Evaluate a user's guess.
	 * 
	 * @param number is the user's guess
	 * @return true if guess is correct, false otherwise
	 */
	public boolean guess(int number) {
		times++;
		if (number == secretNumber) {
			setMessage("Correct! The secret number is " + secretNumber);
			return true;
		}
		if (number < secretNumber) {
			setMessage("Wrong! The answer is bigger than " + number + ".");
			return false;
		}
		setMessage("Wrong! The answer is smaller than " + number + ".");
		return false;
	}

	/** Get the game upper bound. 
	 * 
	 * @return the maximum number of guesses number.
	 * */
	@Override
	public int getUpperBound() {
		return this.upperBound;
	}

	/** 
	 * Get the game answer number. 
	 * 
	 * @return the answer number of this game.
	 * */
	@Override
	public int getSecretNumber() {
		return secretNumber;
	}

	/**
	 * Get the times that user guesses the number.
	 * 
	 * @return times that user guesses the number.
	 * */
	@Override
	public int getCount() {
		return times;
	}
	
	/**
	 * toString describes the game or problem.
	 * 
	 * @return description of this game or the problem to be solved.
	 */
	@Override
	public String toString() {
		return String.format("Predict a number between 1-%d", upperBound);
	}
}