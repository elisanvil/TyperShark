/*
* @(#)App.java	0.1		24/08/2016

*
* Copyright (c) 2016.
* Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

package keyshark.aplicacion;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import keyshark.organizadores.OrganizadorJuego;
import keyshark.organizadores.OrganizadorMenu;
import keyshark.organizadores.OrganizadorAcercaDe;
import keyshark.organizadores.OrganizadorCargarPartida;
import keyshark.organizadores.OrganizadorPuntaje;
import keyshark.organizadores.OrganizadorGuardar;


/**
 * La clase App contiene las distintas escenas de la aplicación
 * TyperShark.
 * 
 * @version: 	0.1		24/08/2016
 * @author: 	Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
 */
public class App extends Application{

	private static Stage mainStage;
	private Image icon = new Image(getClass().getResourceAsStream("/Images/ic.png"));
	
	@Override
	/**
	 * Método que inicia el escenario con el PaneOrganizer del menú del juego.
	 * @param: stage
	 */
	public void start(Stage stage) throws Exception {
		mainStage = stage;
		OrganizadorGuardar.handler = new SceneHandler();
		
		OrganizadorMenu org = new OrganizadorMenu(new SceneHandler());
		Scene escenario = new Scene(org.getRaiz(),500,450);
		stage.getIcons().add(icon);
		stage.setResizable(false);
		stage.setScene(escenario);
		stage.setTitle("KeyShark");
		stage.show();
	}
    
	public static void main (String[] args) {
		Application.launch(args);
	}
	
	
	private static class SceneHandler implements EventHandler<ActionEvent> {
		@Override
		/**
		 * EventHandler llamado desde distintos botones en todo el programa.
		 * Cuando se lo llama, este se encarga de cambiar el escenario de la ventana 
		 * según la preferencia del usuario mediante el uso de botones.
		 * @param: event
		 */
		public void handle(ActionEvent event) {
			try {
				if (((Button) event.getSource()).getText() == "Jugar") {
					Usuario.reset();
					OrganizadorJuego org = new OrganizadorJuego(new SceneHandler());
					Scene escenario = new Scene(org.getRaiz(),1000,700);
					mainStage.setScene(escenario);
					
				} else if (((Button) event.getSource()).getText() == "Acerca De") {
						OrganizadorAcercaDe org = new OrganizadorAcercaDe(new SceneHandler());
						Scene escenario = new Scene(org.getRaiz(),600,500);
						mainStage.setResizable(false);
						mainStage.setScene(escenario);
						
				} else if (((Button) event.getSource()).getText() == "Puntajes") {
					OrganizadorPuntaje org = new OrganizadorPuntaje(new SceneHandler());
					Scene escenario = new Scene(org.getRaiz(), 600, 500);
					mainStage.setResizable(false);
					mainStage.setScene(escenario);
				} else if (((Button) event.getSource()).getText() == "Guardar") {
					ManejoArchivos m = new ManejoArchivos("highScores.txt");
					
					try {
						m.guardarHighScore(HighScore.crearNuevaListaDeHighScores(Usuario.puntaje, Usuario.nombre, Usuario.nivel));
						ControlHilos.detenerJuego();
						Sonido.stop();
						OrganizadorMenu org = new OrganizadorMenu(new SceneHandler());
						Scene escenario = new Scene(org.getRaiz(), 500, 450);
						mainStage.setScene(escenario);
					} catch (Exception e) {
					}
				
				} else if (((Button) event.getSource()).getText() == "Guardar Juego") {
					try {
						ManejoArchivos m = new ManejoArchivos();
						m.guardarJuego(Usuario.nombre);
						m.guardarRegistroDePartida(Usuario.nombre + " nivel: " + Usuario.nivel);
						ControlHilos.detenerJuego();
						Sonido.stop();
						OrganizadorMenu org = new OrganizadorMenu(new SceneHandler());
						Scene escenario = new Scene(org.getRaiz(), 500, 450);
						mainStage.setScene(escenario);
					} catch (Exception e) {
						
					}
			
				} else if (((Button) event.getSource()).getText() == "Cargar Partida") {
					OrganizadorCargarPartida org = new OrganizadorCargarPartida(new SceneHandler());
					Scene escenario = new Scene(org.getRaiz(),600,500);
					mainStage.setResizable(false);
					mainStage.setScene(escenario);
					
				} else if (((Button) event.getSource()).getId() == "iniciarPartidaCargada") {
					String nombreArchivo = ((Button) event.getSource()).getText().split(" ")[0] + "_Partida.txt";
					ManejoArchivos m = new ManejoArchivos(nombreArchivo);
					Usuario.actualizarDatosDePartidaCargada(m.extraerDatosPartidaCargada(m.getLista()));
					OrganizadorJuego org = new OrganizadorJuego(new SceneHandler());
					Scene escenario = new Scene(org.getRaiz(), 1000, 700);
					mainStage.setScene(escenario);
					
				} else {
					Sonido.stop();
					ControlHilos.detenerJuego();
					OrganizadorMenu org = new OrganizadorMenu(new SceneHandler());
					Scene escenario = new Scene(org.getRaiz(), 500, 450);
					mainStage.setResizable(false);
					mainStage.setScene(escenario);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
