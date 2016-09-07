/*
* @(#)Movimiento.java	0.1		24/08/2016

*
* Copyright (c) 2016.
* Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

/**
 * La interface Movimiento define el m�todo mover que ser� utilizado
 * tanto por el buceador como por los animales marinos.
 * 
 * @version: 	0.1		24/08/2016
 * @author: 	Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
 */
public interface Movimiento {
	
	/**
	 * M�todo que permite el movimiento del buceador y
	 * de los animales marinos seg�n sea el caso.
	 * @param: x
	 * @param: y
	 */
	public void mover (double x, double y);
}
