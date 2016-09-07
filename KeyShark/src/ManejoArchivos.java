/*
* @(#)ManejoArchivos.java	0.1		24/08/2016

*
* Copyright (c) 2016.
* Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * La clase ManejoArchivos permite leer y manipular archivos de texto que son
 * utilizados en la aplicaci�n.
 * 
 * @version: 	0.1		24/08/2016
 * @author: 	Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
 */
public class ManejoArchivos {
	private String nombreArchivo;
	
	private Scanner scanner;
	private FileReader lectorDeArchivo;
	private PrintWriter writer;
	private Random random = new Random();
	
	/**
	 * M�todo que inicializa el atributo nombreArchivo 
	 * con un nombre ingresado como par�metro del constructor.
	 * @param: nombreArchivo
	 */
	public ManejoArchivos (String nombreArchivo) throws FileNotFoundException {
		this.nombreArchivo = nombreArchivo;
	}
	
	/**
	 * M�todo que retorna un List<String> con cada l�nea de un archivo .txt
	 * @return: lista
	 */
	public List<String> getLista () throws IOException {
		lectorDeArchivo = new FileReader(nombreArchivo);
		scanner = new Scanner(lectorDeArchivo);
		List<String> lista = new ArrayList<String> ();
		while (scanner.hasNext()) {
			lista.add(scanner.nextLine());
		}
		lectorDeArchivo.close();
		return lista;
	}
	
	/**
	 * M�todo que elige aleatoriamente una palabra dado un array de String.
	 * Elige una palabra para alg�n animal, ya sea un tibur�n, una pira�a o
	 * un tibur�n negro.
	 * @return: palabras[aleatorio]
	 */
	public String elegirPalabra () throws IOException {
		String[] palabras = (String[]) this.getLista().toArray(new String[0]);
		int aleatorio = random.nextInt(palabras.length);
		return palabras[aleatorio];
	}
	
	/**
	 * M�todo que guarda la nueva lista de highScores.
	 * Toma de par�metro un List<String>
	 * @param: lista
	 */
	public void guardarHighScore (List<String> lista) throws FileNotFoundException, UnsupportedEncodingException {
		writer = new PrintWriter(this.nombreArchivo,"UTF-8");
		for (int i=0; i<lista.size(); i++) {
			writer.println(lista.get(i));
		}
		writer.close();
	}
	
	
}
