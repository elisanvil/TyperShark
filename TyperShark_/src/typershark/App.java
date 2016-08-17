package typershark;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * @author Elizabeth Sánchez, Paul Estrada, Stefany Lindao.
 *
 */
public class App extends Application {
	
	Image icon = new Image(getClass().getResourceAsStream("/ic.png"));
	
	@Override
	public void start(Stage stage) {
			PaneOrganizerInicio root = new PaneOrganizerInicio();
			Scene scene = new Scene(root.getRoot(), 500, 400);
			stage.getIcons().add(icon);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("TyperShark!");
			stage.show();
	}
	
	/*public void start(Stage stage) {
			PaneOrganizer root = new PaneOrganizer();
			Scene scene = new Scene(root.getRoot(), 690, 480);
			//stage.initStyle(StageStyle.UTILITY);				//Remover max/min
			stage.getIcons().add(icon);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("TyperShark!");
			stage.show();
			
	}*/
	
	public static void main(String[] args) {
		launch(args);
	}
}
