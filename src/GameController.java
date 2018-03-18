import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * UI Controller for events and initializing compomnents.
 * 
 * @author Kornphon Noiprasert
 */
public class GameController {
	@FXML
	TextField textfield1;
	@FXML
	Label label1;
	private NumberGame game;
	private CounterView view;
	private LastView view2;
	private int upperBound;

	/**
	 * JavaFX calls the initialize() method of your controller when it creates the
	 * UI form, after the components have been created and @FXML annotated
	 * attributes have been set.
	 *
	 * This is a hook to initialize anything your controller or UI needs.
	 */
	@FXML
	public void initialize() {
		upperBound = 100;
		game = new KornphonGame(upperBound);
		view = new CounterView(game);
		view.run();
		view2 = new LastView(game);
		view2.run();
	}

	/**
	 * Convert a distance from one unit to another.
	 */
	public void handleSubmit(ActionEvent event) {
		try {
			String input = textfield1.getText();
			int number = Integer.parseInt(input);
			if (game.guess(number)) {
				label1.setText(game.getMessage());
			} else {
				label1.setText(game.getMessage());
			}
			view.displayCount();
			view2.displayLast();
			textfield1.clear();
		} catch (NumberFormatException e) {
			label1.setText("Invalid Number");
		}
	}

	/**
	 * Clear all text for ready to used.
	 */
	public void handleClear(ActionEvent event) {
		textfield1.clear();
		label1.setText("");
	}

	/**
	 * Clear all text for ready to used.
	 */
	public void handleNewGame(ActionEvent event) {
		upperBound = 100;
		game = new KornphonGame(upperBound);
		view.close();
		view = new CounterView(game);
		view.run();
		view2.close();
		view2 = new LastView(game);
		view2.run();
	}

}
