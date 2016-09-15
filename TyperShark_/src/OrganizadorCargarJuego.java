/*
* @(#)OrganizadorAcercaDe.java	0.1		24/08/2016

*
* Copyright (c) 2016.
* Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.List;

import javafx.event.*;

/**
 * La clase OrganizadorAcercaDe permite modelar la escena
 * que presenta información sobre la aplicación y sus desarrolladores.
 * 
 * @version: 	0.1		24/08/2016
 * @author: 	Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
 */
public class OrganizadorCargarJuego {
	private Pane raiz;
	private VBox contenedor;
	private Label textoLabel;
	private Label titulo;
	private Button botonRegresar;
	private ImageView fondo;
	
	/**
	 * Método que construye un objeto PaneOrganizer que será instanciado por la clase App.
	 * Muestra los elementos de la interfaz que permite visualizar información del juego
	 * y de los desarrolladores. Además muestra un botón para regresar al menú principal.
	 * @param: handler
	 */
	public OrganizadorCargarJuego (EventHandler<ActionEvent> handler) throws IOException {
		raiz = new Pane();
		
		fondo = new ImageView();
		fondo.setImage(new Image("oceano.png"));
		fondo.setFitWidth(1000);
		fondo.setFitHeight(800);
		
		/*String text = new String();
		ManejoArchivos m = new ManejoArchivos("acercaDe.txt");
		List<String> lista = m.getLista();
		for (int i=0;i<lista.size();i++) {
			text += lista.get(i) + "\n";
		}*/
		
		titulo = new Label("Juegos Guardados");
		titulo.setFont(new Font("helvetica",30.0));
		titulo.setTextFill(Color.WHITE);
		titulo.setAlignment(Pos.CENTER);
		
		/*textoLabel = new Label();
		textoLabel.setText(text);
		textoLabel.setFont(new Font("helvetica",15.0));
		textoLabel.setTextFill(Color.WHITE);*/
		
		botonRegresar = new Button("Regresar");
		botonRegresar.setOnAction(handler);
		botonRegresar.setAlignment(Pos.CENTER);
		
		contenedor = new VBox();
		//contenedor.getChildren().addAll(titulo,textoLabel,botonRegresar);
		contenedor.getChildren().addAll(titulo,botonRegresar);
		contenedor.setSpacing(50);
		contenedor.setAlignment(Pos.CENTER);
		contenedor.setLayoutX(200);
		contenedor.setLayoutY(50);
		
		raiz.getChildren().addAll(fondo,contenedor);
	}
	
	/**
	 * Método que retorna un Pane como nodo principal.
	 * @return: raiz
	 */
	public Pane getRaiz () {
		return this.raiz;
	}
}
