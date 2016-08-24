import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OrganizadorJuego {
	private static BorderPane raiz;
	
	public static Button botonSalir;
	
	private static Label puntaje;
	private static Label vidas;
	private static Label nivel;
	
	private ImageView puntajeView;
	private ImageView vidasView;
	private ImageView nivelView;
	private static ImageView poderEspecialView;
	
	public static Buceador buzo;
	public static Tiburon tiburon1;
	public static Tiburon tiburon2;
	public static Tiburon tiburon3;
	public static Pirana pirana1;
	public static Pirana pirana2;
	public static Pirana pirana3;
	public static Pirana pirana4;
	public static TiburonNegro tiburonNegro1;
	public static TiburonNegro tiburonNegro2;
	
	public OrganizadorJuego (EventHandler<ActionEvent> handler) throws FileNotFoundException, IOException {
		raiz = new BorderPane();
		
		buzo = new Buceador(20.0,30.0);
		
		tiburon1 = new Tiburon(1000.0,90.0);
		tiburon2 = new Tiburon(1000.0,90.0);
		tiburon3 = new Tiburon(1000.0,90.0);
		Tiburon[] tiburones = {tiburon1, tiburon2, tiburon3};
		
		pirana1 = new Pirana(1000.0,90.0);
		pirana2 = new Pirana(1000.0,90.0);
		pirana3 = new Pirana(1000.0,90.0);
		pirana4 = new Pirana(1000.0,90.0);
		Pirana[] piranas = {pirana1, pirana2, pirana3, pirana4};
		
		tiburonNegro1 = new TiburonNegro(1000.0,90.0);
		tiburonNegro2 = new TiburonNegro(1000.0,90.0);
		TiburonNegro[] tiburonesNegros = {tiburonNegro1, tiburonNegro2};
		
		botonSalir = new Button("Salir");
		botonSalir.setOnAction(handler);
		
		poderEspecialView = new ImageView();
		poderEspecialView.setImage(null);
		poderEspecialView.setLayoutX(50.0);
		poderEspecialView.setLayoutY(5.0);
		poderEspecialView.setFitWidth(50);
		poderEspecialView.setFitHeight(50);
		
		vidas = new Label(String.valueOf(Usuario.vidas));
		vidas.setFont(new Font("helvetica", 25));
		vidas.setTextFill(Color.WHITE);
		vidas.setLayoutX(250.0);
		vidas.setLayoutY(10.0);
		vidasView = new ImageView();
		vidasView.setImage(new Image("snorkel.png"));
		vidasView.setLayoutX(300.0);
		vidasView.setLayoutY(5.0);
		vidasView.setFitWidth(50);
		vidasView.setFitHeight(50);
		
		nivel = new Label(String.valueOf(Usuario.nivel));
		nivel.setFont(new Font("helvetica", 25));
		nivel.setTextFill(Color.WHITE);
		nivel.setLayoutX(500.0);
		nivel.setLayoutY(10.0);
		nivelView = new ImageView();
		nivelView.setImage(new Image("level.png"));
		nivelView.setLayoutX(550.0);
		nivelView.setLayoutY(5.0);
		nivelView.setFitWidth(100);
		nivelView.setFitHeight(50);
		
		puntaje = new Label(String.valueOf(Usuario.puntaje));
		puntaje.setFont(new Font("helvetica", 25));
		puntaje.setTextFill(Color.WHITE);
		puntaje.setLayoutX(825.0);
		puntaje.setLayoutY(10.0);
		puntajeView = new ImageView();
		puntajeView.setImage(new Image("score.png"));
		puntajeView.setLayoutX(900.0);
		puntajeView.setLayoutY(5.0);
		puntajeView.setFitWidth(50);
		puntajeView.setFitHeight(50);
				
		Pane contenedor = new Pane();
		ImageView fondo = new ImageView();
		fondo.setImage(new Image("oceano3.png"));
		fondo.setFitWidth(1000);
		fondo.setFitHeight(800);

		Thread hiloJuego = new Thread(new ControlHilos(buzo,tiburones, piranas, tiburonesNegros));
		hiloJuego.start();
		
		contenedor.getChildren().addAll(			
				fondo,
				
				vidas, vidasView,
				puntaje, puntajeView,
				nivel, nivelView,
				poderEspecialView,
				
				buzo.getImageView(), 
				
				tiburon1.getImageView(), tiburon1.getLabel(),
				tiburon2.getImageView(), tiburon2.getLabel(),
				tiburon3.getImageView(), tiburon3.getLabel(),
				
				pirana1.getImageView(), pirana1.getLabel(),
				pirana2.getImageView(), pirana2.getLabel(),
				pirana3.getImageView(), pirana3.getLabel(),
				pirana4.getImageView(), pirana4.getLabel(), 
				
				tiburonNegro1.getImageView(), tiburonNegro1.getLabel(),
				tiburonNegro2.getImageView(), tiburonNegro2.getLabel());
		
		contenedor.requestFocus();
		contenedor.setOnKeyTyped(new listener());
		
		raiz.setCenter(contenedor);
		raiz.setBottom(botonSalir);
		
		Sonido.play();
	}
	
	private class listener implements EventHandler<KeyEvent> {
		@Override
		public void handle(KeyEvent event) {
			if (event.getCharacter().isEmpty() == false) {
				
				if (event.getCharacter().charAt(0) == ' ' && Usuario.poderEspecial) {
					tiburon1.muerteInmediata();
					tiburon2.muerteInmediata();
					tiburon3.muerteInmediata();
					
					pirana1.muerteInmediata();
					pirana2.muerteInmediata();
					pirana3.muerteInmediata();
					pirana4.muerteInmediata();
					
					tiburonNegro1.muerteInmediata();
					tiburonNegro2.muerteInmediata();
					
					Usuario.poderEspecial = false;
					activarImagenPoderEspecial(false);
				} else {
					tiburon1.procesar(event.getCharacter());
					tiburon2.procesar(event.getCharacter());
					tiburon3.procesar(event.getCharacter());
					
					pirana1.procesar(event.getCharacter());
					pirana2.procesar(event.getCharacter());
					pirana3.procesar(event.getCharacter());
					pirana4.procesar(event.getCharacter());
					
					tiburonNegro1.procesar(event.getCharacter());
					tiburonNegro2.procesar(event.getCharacter());
				}
			} 
		}
		
	}
	
	public static void actualizarPuntaje () {
		puntaje.setText(String.valueOf(Usuario.puntaje));
	}
	
	public static void actualizarVidas (int nuevaVida) {
		vidas.setText(String.valueOf(Usuario.vidas));
	}
	
	public static void actualizarNivel (int nuevoNivel) {
		nivel.setText(String.valueOf(Usuario.nivel));
	}
	
	public BorderPane getRaiz () {
		return raiz;
	}
	
	public static void presentarVentanaGuardar () {
		OrganizadorGuardar org = new OrganizadorGuardar();
		raiz.getChildren().add(org.getRaiz());
	}
	
	public static void activarImagenPoderEspecial (boolean activar) {
		if (activar) {
			poderEspecialView.setImage(new Image("poderEspecial.png"));
		} else {
			poderEspecialView.setImage(null);
		}
	}
}
