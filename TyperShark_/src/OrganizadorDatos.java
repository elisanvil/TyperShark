/*
* @(#)OrganizadorDatos.java	0.1		15/09/2016

*
* Copyright (c) 2016.
* Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

package keyshark.organizadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;


/**
 * La clase OrganizadorDatos permite modelar una pequeña escena
 * que permite guardar el nickname del jugador.
 * 
 * @version: 	0.1		15/09/2016
 * @author: 	Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
 */
public class OrganizadorDatos {
	
	private Pane raiz;
	
	private Rectangle fondo;
	
	private Label tituloLabel;
	private Label nombreLabel; 
	
	public static TextField nombreTF;
	
	private Button botonGuardar;
	
	/**
	 * Método que construye un objeto OrganizadorDatos que será instanciado en la clase OrganizadorJuego.
	 * Por medio de esta interfaz, el usuario ingresa su nickname.
	 * @param: handler
	 */
	public OrganizadorDatos (EventHandler<ActionEvent> handler) {
		raiz = new Pane();
		raiz.setLayoutX(350.0);
		raiz.setLayoutY(250.0);
		raiz.setPrefHeight(140.0);
		raiz.setPrefWidth(250.0);
		
		fondo = new Rectangle(250.0,150.0);
		fondo.setFill(Color.WHITE);
		
		tituloLabel = new Label("Jugador");
		tituloLabel.setFont(Font.font("Comic Sans MS", FontPosture.REGULAR, 15.0));
		tituloLabel.setLayoutX(90.0);
		tituloLabel.setLayoutY(20.0);
		
		nombreLabel = new Label("Nickname: ");
		nombreLabel.setFont(Font.font("Comic Sans MS", FontPosture.REGULAR, 13.0));
		nombreLabel.setLayoutX(10.0);
		nombreLabel.setLayoutY(60.0);
		
		nombreTF = new TextField();
		nombreTF.setPrefHeight(25.0);
		nombreTF.setPrefWidth(150.0);
		nombreTF.setLayoutX(80.0);
		nombreTF.setLayoutY(60.0);
		
		botonGuardar = new Button("Continuar");
		botonGuardar.setOnAction(handler);
		botonGuardar.setLayoutX(90.0);
		botonGuardar.setLayoutY(100.0);
		
		raiz.getChildren().addAll(fondo,tituloLabel,nombreLabel,nombreTF,botonGuardar);
		
	}
	
	/**
	 * Método que retorna un Pane como nodo principal.
	 * @return: raiz
	 */
	public Pane getRaiz() {
		return this.raiz;
	}

}