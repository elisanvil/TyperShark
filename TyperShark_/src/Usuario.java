/*
* @(#)Usuario.java	0.1		24/08/2016

*
* Copyright (c) 2016.
* Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

package keyshark.aplicacion;

import java.io.IOException;

import keyshark.organizadores.OrganizadorJuego;

/**
 * La clase Usuario maneja los datos del jugador, 
 * sus vidas en el juego, su puntaje, 
 * el nivel en el que se encuentra, 
 * su nombre y si tiene el poder especial activado.
 * 
 * @version: 	0.1		24/08/2016
 * @author: 	Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
 */
public class Usuario {
	public static int vidas = 3;
	public static boolean poderEspecial = false;
	public static int puntaje = 0;
	public static int nivel = 1;
	public static String nombre;
	public static int acumulado = 0;

	public static int toquesPirana = 3;
	
	/**
	 * Método que restaura todos los atributos de la clase 
	 * a su estado inicial.
	 */
	public static void reset () {
		vidas = 3;
		poderEspecial = false;
		puntaje = 0;
		nivel = 1;
		nombre = "";
		acumulado = 0;
	}
	
	/**
	 * Método que sube el nivel del juego y actualiza este valor 
	 * en el label de puntaje de la clase OrganizadorJuego.
	 */
	public static void aumentarNivel() {
		nivel++;
		OrganizadorJuego.actualizarNivel(nivel);
	}
	
	/**
	 * Método que quita una vida al jugador cada vez que es llamado.
	 * Si las vidas llegan a 0, el juego se detiene y se verifica si se logró un HighScore.
	 * Si fue así se presenta una interfaz para guardar la partida en la clase OrganizadorJuego.
	 */
	public static void quitarVida () throws IOException {
		vidas--;
		OrganizadorJuego.actualizarVidas(vidas);
		toquesPirana = 3;
		
		if (vidas <= 0) {
			ControlHilos.detenerJuego();
			Sonido.stop();
			if (HighScore.verificarSiBatioRecord(puntaje, nombre, nivel)) {
				OrganizadorJuego.presentarVentanaGuardar();
			}
		}
	}
	
	/**
	 * Debido a que una piraña tiene que tocar 3 veces al jugador para quitarle una vida,
	 * este método se encarga de que este proceso se cumpla.
	 */
	public static void quitarVidaDesdePirana () throws IOException {
		toquesPirana --;
		if (toquesPirana <= 0) {
			quitarVida();
			OrganizadorJuego.actualizarVidas(vidas);
			toquesPirana = 3;
		}
	}
	
	/**
	 * Método que toma un parámetro de tipo boolean y 
	 * se lo asigna al atributo poderEspecial, activándolo o 
	 * desactivándolo.
	 * @param: activar
	 */
	public static void activarPoderEspecial (boolean activar) {
		poderEspecial = activar;
	}
	
	/**
	 * Método que se encarga de actualizar el puntaje del jugador 
	 * de acuerdo al animal que vaya matando. Además acumula un valor 
	 * cada vez que el puntaje se altere.
	 * Cuando este valor es mayor o igual a 1500, se activa el poder especial
	 * mostrando una imagen en la clase OrganizadorJuego y el valor acumulado
	 * regresa a cero.
	 * @param: nuevoPuntaje
	 */
	public static void actualizarPuntaje (int nuevoPuntaje) {
		puntaje += nuevoPuntaje;
		OrganizadorJuego.actualizarPuntaje();
		acumulado += nuevoPuntaje;
		if (acumulado >= 1500) {
			poderEspecial = true;
			acumulado = 0;
			OrganizadorJuego.activarImagenPoderEspecial(true);
		}
	}
	
	public static void actualizarDatosDePartidaCargada (String texto) {
		String[] componentes = texto.split(" ");
		vidas = Integer.parseInt(componentes[0]);
		poderEspecial = Boolean.parseBoolean(componentes[1]);
		puntaje = Integer.parseInt(componentes[2]);
		nivel = Integer.parseInt(componentes[3]);
		nombre = componentes[4];
		acumulado = Integer.parseInt(componentes[5]);
	}
}
