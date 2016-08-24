import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class App extends Application{

	private static Stage mainStage;
	
	@Override
	public void start(Stage stage) throws Exception {
		mainStage = stage;
		OrganizadorGuardar.handler = new SceneHandler();
		
		OrganizadorMenu org = new OrganizadorMenu(new SceneHandler());
		Scene escenario = new Scene(org.getRaiz(),1000,700);
		stage.setScene(escenario);
		stage.setTitle("KeyShark");
		stage.show();
	}

	public static void main (String[] args) {
		Application.launch(args);
	}
	
	private static class SceneHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			try {
				if (((Button) event.getSource()).getText() == "Jugar") {
					OrganizadorJuego org = new OrganizadorJuego(new SceneHandler());
					Scene escenario = new Scene(org.getRaiz(),1000,700);
					mainStage.setScene(escenario);
				} else if (((Button) event.getSource()).getText() == "Acerca de...") {
						OrganizadorAcercaDe org = new OrganizadorAcercaDe(new SceneHandler());
						Scene escenario = new Scene(org.getRaiz(),1000,700);
						mainStage.setScene(escenario);
				} else if (((Button) event.getSource()).getText() == "Puntajes") {
					OrganizadorPuntaje org = new OrganizadorPuntaje(new SceneHandler());
					Scene escenario = new Scene(org.getRaiz(),1000,700);
					mainStage.setScene(escenario);
				} else if (((Button) event.getSource()).getText() == "Guardar") {
					ManejoArchivos m = new ManejoArchivos("highScores.txt");
					m.guardarHighScore(HighScore.nuevaListaHighScore(OrganizadorGuardar.nicknameTF.getText(), Usuario.puntaje));
					Sonido.stop();
					OrganizadorMenu org = new OrganizadorMenu(new SceneHandler());
					Scene escenario = new Scene(org.getRaiz(),1000,700);
					mainStage.setScene(escenario);
				} else {
					Sonido.stop();
					OrganizadorMenu org = new OrganizadorMenu(new SceneHandler());
					Scene escenario = new Scene(org.getRaiz(),1000,700);
					mainStage.setScene(escenario);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
