package typershark;
	
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * @author Elizabeth Sánchez, Paul Estrada, Stefany Lindao.
 *
 */
public class App extends Application {
	
	Image icon = new Image(getClass().getResourceAsStream("/Images/ic.png"));
	
	public void escucharAudio(String url){
		URL resource = getClass().getResource(url);
        Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
	}
	
	@Override
	/*public void start(Stage stage) {
			PaneOrganizerInicio root = new PaneOrganizerInicio();
			Scene scene = new Scene(root.getRoot(), 500, 400);
			stage.getIcons().add(icon);
			stage.setScene(scene);
			stage.setResizable(false);
			escucharAudio("/Audio/Jaws.mp3");
			stage.setTitle("TyperShark!");
			stage.show();
	}*/
	
	public void start(Stage stage) {
			PaneOrganizer root = new PaneOrganizer();
			Scene scene = new Scene(root.getRoot(), 850, 500);
			//stage.initStyle(StageStyle.UTILITY);				//Remover max/min
			stage.getIcons().add(icon);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("TyperShark!");
	        escucharAudio("/Audio/SMBWaterWorld.mp3");
			stage.show();
			
	}

	public static void main(String[] args) {
		launch(args);
	}
}
