import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class OrganizadorMenu {
	
	private Pane raiz;
	private VBox contenedorBotones;
	private Button botonJugar;
	private Button botonAcercaDe;
	private Button botonPuntaje;
	private Button botonSalir;
	private ImageView fondo;
	private ImageView logo;
	
	public OrganizadorMenu (EventHandler<ActionEvent> handler) {
		raiz = new Pane();
		contenedorBotones = new VBox();
		
		fondo = new ImageView();
		fondo.setImage(new Image("fondoShark.png"));
		fondo.setFitHeight(800);
		fondo.setFitWidth(1000);
		
		logo = new ImageView();
		logo.setImage(new Image("logo.png"));
		logo.setLayoutX(300);
		logo.setLayoutY(80);
		logo.setFitHeight(200);
		logo.setFitWidth(400);
		
		botonJugar = new Button("Jugar");
		botonJugar.setFont(new Font("Comic Sans MS", 40.0));
		botonJugar.setTextFill(Color.CRIMSON);
		botonJugar.setOnAction(handler);
		botonJugar.setBackground(null);
		
		botonAcercaDe = new Button("Acerca de...");
		botonAcercaDe.setFont(new Font("Comic Sans MS", 40.0));
		botonAcercaDe.setTextFill(Color.CRIMSON);
		botonAcercaDe.setOnAction(handler);
		botonAcercaDe.setBackground(null);
		
		botonPuntaje = new Button("Puntajes");
		botonPuntaje.setFont(new Font("Comic Sans MS", 40.0));
		botonPuntaje.setTextFill(Color.CRIMSON);
		botonPuntaje.setOnAction(handler);
		botonPuntaje.setBackground(null);
		
		botonSalir = new Button("Salir");
		botonSalir.setFont(new Font("Comic Sans MS", 40.0));
		botonSalir.setTextFill(Color.CRIMSON);
		botonSalir.setBackground(null);
		botonSalir.setOnAction(e -> {
			System.exit(0);
		});
		
		
		contenedorBotones.getChildren().addAll(botonJugar,botonAcercaDe,botonPuntaje,botonSalir);
		contenedorBotones.setSpacing(20);
		contenedorBotones.setAlignment(Pos.CENTER);
		contenedorBotones.setLayoutX(350);
		contenedorBotones.setLayoutY(250);
		raiz.getChildren().addAll(fondo,logo,contenedorBotones);
	}
	
	public Pane getRaiz () {
		return this.raiz;
	}
}
