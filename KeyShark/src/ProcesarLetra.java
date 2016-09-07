/*
* @(#)ProcesarLetra.java	0.1		24/08/2016

*
* Copyright (c) 2016.
* Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

/**
 * La interface ProcesarLetra define el m�todo procesar que ser� utilizado
 * por los animales animales al interactuar con la palabra o caracter adjuntado.
 * 
 * @version: 	0.1		24/08/2016
 * @author: 	Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
 */
public interface ProcesarLetra {
	
	/**
	 * M�todo que permite el procesamiento de la palabra
	 * o caracter seg�n el animal marino involucrado.
	 * @param: letra
	 */
	public void procesar (String letra);
}
