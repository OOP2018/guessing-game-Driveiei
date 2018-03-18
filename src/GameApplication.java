import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * The Main class is the class to start the application or ready to begin
 * running.
 * 
 * @author Kornphon Noiprasert
 */
public class GameApplication extends Application {

	/**
	 * The start method is called after the init method has returned, and after the
	 * system is ready for the application to begin running.
	 * 
	 * @param primaryStage is the stage for this application which the application scene can
	 * be set.
	 */
	@Override
	public void start(Stage stage) {
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("GuessingGameUI.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.show();
			stage.setTitle("Guessing game");
		} catch (Exception e) {
			System.out.println("Exception creating scene:" + e.getMessage());
		}

	}

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
