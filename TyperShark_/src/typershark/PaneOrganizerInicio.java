/**
 * 
 */

package typershark;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * @author Elizabeth Sánchez, Paul Estrada, Stefany Lindao.
 *
 */
public class PaneOrganizerInicio {
	
	private BorderPane root;
	private HBox hb;
	private Button jugar;
	private Button estadistica;
	private Button acerca;
	private Button salir;
	
	private Image imgLogo = new Image("Images/logo.png");
	private String img = "Images/fondoshark.jpg";
	
	private ImageView logo = new ImageView();
	
	public PaneOrganizerInicio(){
		root = new BorderPane();
		hb = new HBox();
		
		logo.setImage(imgLogo);
		logo.setFitWidth(325);
        logo.setFitHeight(250);

        root.setCenter(logo);

		jugar = new Button("Jugar");
		jugar.setStyle("-fx-font: 14 forte; -fx-base: #000000;");
		jugar.setMaxSize(80, 40);
		
		estadistica = new Button("Estadísticas");
		estadistica.setStyle("-fx-font: 14 forte; -fx-base: #000000;");
		estadistica.setMaxSize(100, 40);
		
		acerca = new Button("Acerca De");
		acerca.setStyle("-fx-font: 14 forte; -fx-base: #000000;");
		acerca.setMaxSize(80, 40);
		
		salir = new Button("Salir");
		salir.setStyle("-fx-font: 14 forte; -fx-base: #000000;");
		salir.setMaxSize(80, 40);
		salir.setOnAction(new ClickHandlerQuit());
		
        root.setStyle("-fx-background-image: url('" + img + "'); "
           + "-fx-background-position: center center; "
           + "-fx-background-repeat: stretch;");
        
        hb.getChildren().addAll(jugar, estadistica, acerca, salir);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(15, 15, 15, 15));
        hb.setSpacing(10);
        root.setBottom(hb);
        

        
	}
	
	public Pane getRoot() {
		return root;
	}
	
	private class ClickHandlerQuit implements EventHandler<ActionEvent> {

        @Override
        //Metodo que permite terminar la ejecución de la aplicacion.
        public void handle(ActionEvent event) {
            System.exit(0);
        }  
    }

}
