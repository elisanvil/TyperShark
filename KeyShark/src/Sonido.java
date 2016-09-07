/*
* @(#)Sonido.java	0.1		24/08/2016

*
* Copyright (c) 2016.
* Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 * La clase Sonido reproduce un archivo de audio durante la ejecuci�n de la
 * aplicaci�n.
 * 
 * @version: 	0.1		24/08/2016
 * @author: 	Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
 */
public class Sonido {
	private static Media sound = new Media(new File("SMBWaterWorld.mp3").toURI().toString());
	private static MediaPlayer player = new MediaPlayer(sound);
	
	/**
	 * M�todo que permite que se ejecute el archivo de audio.
	 */
	public static void play() {
		player.play();
		player.getOnPlaying();
	}

	/**
	 * M�todo que permite el detenimiento de la ejecuci�n 
	 * del archivo de audio.
	 */
	public static void stop() {
		player.stop();
	}
}
