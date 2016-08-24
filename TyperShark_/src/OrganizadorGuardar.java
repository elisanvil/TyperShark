import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class OrganizadorGuardar {
	
	public static EventHandler<ActionEvent> handler;
	
	private Pane raiz;
	private BorderPane borderPane;
	private HBox contenedorSup;
	private HBox contenedorInf;
	private VBox contenedorElementos;
	private HBox contenedorBotones;
	private HBox contenedorTitulo;
	
	private Label puntajeLabel;
	private Label nicknameLabel;
	private Label puntaje;
	private Label tituloLabel;
	
	private Button guardar;
	private Button salir;
	
	private Rectangle fondo;
	
	public static TextField nicknameTF;
	
	public OrganizadorGuardar () {
		raiz = new Pane();
		raiz.setLayoutX(350.0);
		raiz.setLayoutY(250.0);
		
		borderPane = new BorderPane();
		borderPane.setPrefSize(250.0, 150.0);
		
		fondo = new Rectangle(270.0,170.0);
		fondo.setFill(Color.BEIGE);
		
		contenedorTitulo = new HBox();
		tituloLabel = new Label("HIGHSCORE");
		tituloLabel.setFont(new Font("helvetica", 25.0));
		contenedorTitulo.getChildren().add(tituloLabel);
		contenedorTitulo.setAlignment(Pos.CENTER);
		
		contenedorSup = new HBox();
		contenedorInf = new HBox();
		contenedorElementos = new VBox();
		
		puntajeLabel = new Label("Puntaje: ");
		nicknameLabel = new Label ("Nickname: ");
		puntaje = new Label(String.valueOf(Usuario.puntaje));
		
		nicknameTF = new TextField();
		nicknameTF.setPrefWidth(100.0);
		
		contenedorSup.getChildren().addAll(puntajeLabel, puntaje);
		contenedorSup.setSpacing(25.0);
		contenedorSup.setAlignment(Pos.CENTER);
		
		contenedorInf.getChildren().addAll(nicknameLabel, nicknameTF);
		contenedorInf.setSpacing(15.0);
		contenedorInf.setAlignment(Pos.CENTER);
		
		contenedorElementos.getChildren().addAll(contenedorSup,contenedorInf);
		contenedorElementos.setSpacing(25.0);
		contenedorElementos.setAlignment(Pos.CENTER);
		
		guardar = new Button("Guardar");
		guardar.setOnAction(handler);
		
		salir = new Button("Salir");
		salir.setOnAction(handler);
		
		contenedorBotones = new HBox();
		contenedorBotones.getChildren().addAll(salir,guardar);
		contenedorBotones.setSpacing(50.0);
		contenedorBotones.setAlignment(Pos.BOTTOM_CENTER);
		
		borderPane.setTop(contenedorTitulo);
		borderPane.setCenter(contenedorElementos);
		borderPane.setBottom(contenedorBotones);
		
		raiz.getChildren().addAll(fondo,borderPane);
	}
	
	public Pane getRaiz() {
		return this.raiz;
	}
}
