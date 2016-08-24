import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Sonido {
	private static Media sound = new Media(new File("SMBWaterWorld.mp3").toURI().toString());
	private static MediaPlayer player = new MediaPlayer(sound);
	
	public static void play() {
		player.play();
	}

	public static void stop() {
		player.stop();
	}
}
