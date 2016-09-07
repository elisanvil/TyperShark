/*
* @(#)Objeto.java	0.1		24/08/2016

*
* Copyright (c) 2016.
* Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * La clase Objeto es una superclase de los nodos que tienen 
 * movimiento en la pantalla. Implementa la interface Runnable.
 * Permite el modelamiento del buceador y los animales marinos del juego.
 * 
 * @version: 	0.1		24/08/2016
 * @author: 	Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
 */
public class Objeto implements Runnable {
	private String tipo;
	private int nivel;
	
	private double posicionX;
	private double posicionY;
	
	private Thread hilo;
	private Label label;
	
	private boolean vivo;
	
	private ImageView imageView;

	/**
	 * M�todo que construye un objeto con una posici�n X y Y dada,
	 * un tipo de objeto y un nivel.
	 * @param: tipo
	 * @param: posicionX
	 * @param: posicionY
	 * @param: nivel
	 */
	public Objeto (String tipo, double posicionX, double posicionY, int nivel) {
		this.setTipo(tipo);
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setNivel(nivel);
		this.setImageView(new ImageView());
		label = new Label();
	}

	/**
	 * M�todo que permite obtener el tipo de objeto.
	 * @return: tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * M�todo que da acceso al tipo de objeto para su
	 * posterior modificaci�n.
	 * @param: tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * M�todo que permite obtener la posici�n en X.
	 * @return: posicionX
	 */
	public double getPosicionX() {
		return posicionX;
	}

	/**
	 * M�todo que da acceso a la posici�n en X para su
	 * posterior modificaci�n.
	 * @param: posicionX
	 */
	public void setPosicionX(double posicionX) {
		this.posicionX = posicionX;
	}

	/**
	 * M�todo que permite obtener la posici�n en Y.
	 * @return: posicionY
	 */
	public double getPosicionY() {
		return posicionY;
	}

	/**
	 * M�todo que da acceso a la posici�n en Y para su
	 * posterior modificaci�n.
	 * @param: posicionY
	 */
	public void setPosicionY(double posicionY) {
		this.posicionY = posicionY;
	}

	/**
	 * M�todo que permite obtener el nivel.
	 * @return: nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * M�todo que da acceso al nivel para su
	 * posterior modificaci�n.
	 * @param: nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * M�todo que permite obtener la visualizaci�n
	 * de una imagen.
	 * @return: imageView
	 */
	public ImageView getImageView() {
		return imageView;
	}

	/**
	 * M�todo que da acceso a la visualizaci�n de una 
	 * imagen para su posterior modificaci�n.
	 * @param: imageView
	 */
	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	@Override
	public void run() {
		
	}

	/**
	 * M�todo que permite obtener el hilo del objeto.
	 * @return: hilo
	 */
	public Thread getHilo() {
		return hilo;
	}

	/**
	 * M�todo que da acceso al hilo del objeto para su
	 * posterior modificaci�n.
	 * @param: hilo
	 */
	public void setHilo(Thread hilo) {
		this.hilo = hilo;
	}

	/**
	 * M�todo que permite saber si el objeto est� vivo.
	 * @return: vivo
	 */
	public boolean isVivo() {
		return vivo;
	}

	/**
	 * M�todo que da acceso a la vida del objeto para su
	 * posterior modificaci�n.
	 * @param: vivo
	 */
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	/**
	 * M�todo que permite obtener la etiqueta.
	 * @return: label
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * M�todo que da acceso a la etiqueta para su
	 * posterior modificaci�n.
	 * @param: label
	 */
	public void setLabel(Label label) {
		this.label = label;
	}
	
}
