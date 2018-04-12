package gameUI;
import java.util.Observable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * A Controller for a window that shows the number of last time the user
 * guessed. This has only one component (but you can add more components), so
 * write it in code instead of FXML.
 *
 * @author Kornphon Noiprasert
 */
public class LastView implements java.util.Observer {
	/** the stage (top-level window) for showing scene */
	private Stage stage;
	/** a counter to show value of */
	private NumberGame game;
	/** the label that shows the counter value. */
	private Label label;

	/**
	 * Initialize a CounterView, which shows value of a counter.
	 * 
	 * @param counter the Counter to show.
	 */
	public LastView(NumberGame game) {
		this.game = game;
		initComponents();
	}

	/**
	 * To initialize the components of the window.
	 */
	private void initComponents() {
		stage = new Stage();
		// components and containers for our window
		HBox root = new HBox();
		root.setPadding(new Insets(30));
		root.setAlignment(Pos.CENTER);
		// The label that will show the counter value.
		label = new Label("");
		// make the label big enough
		label.setPrefWidth(500);
		label.setFont(new Font("Arial", 30.0));
		label.setAlignment(Pos.CENTER);
		// Add the label to the HBox. You can all more components, too.
		root.getChildren().add(label);
		// Create a Scene using HBox as the root element
		Scene scene = new Scene(root);
		// show the scene on the stage
		stage.setScene(scene);
		stage.setTitle("Last guess");
		stage.sizeToScene();
	}

	/** Show the window and update the counter value. */
	public void run() {
		stage.show();
		displayLast();
	}

	/** Close the window */
	public void close() {
		stage.close();
	}

	/** Show the number of last time that user guessing the number. */
	public void displayLast() {
		label.setText(String.format("You guessed %2d from the last time.", game.getLastGuess()));
	}

	/**
	 * This method is called whenever the observed object is changed. An application
	 * calls an Observable object's notifyObservers method to have all the object's
	 * observers notified of the change.
	 */
	@Override
	public void update(Observable o, Object arg) {
		displayLast();
	}
}