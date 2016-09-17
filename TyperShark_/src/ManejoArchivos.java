/*
* @(#)ManejoArchivos.java	0.1		24/08/2016

*
* Copyright (c) 2016.
* Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

package keyshark.aplicacion;

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
 * utilizados en la aplicación.
 * 
 * @version: 	0.1		24/08/2016
 * @author: 	Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
 */
public class ManejoArchivos {
	private String nombreArchivo;
	
	private Scanner scanner;
	private FileReader lectorDeArchivo;
	private PrintWriter writer;
	private Random random = new Random();
	
	/**
	 * Método que inicializa el atributo nombreArchivo 
	 * con un nombre ingresado como parámetro del constructor.
	 * @param: nombreArchivo
	 */
	public ManejoArchivos (String nombreArchivo) throws FileNotFoundException {
		this.nombreArchivo = nombreArchivo;
	}
	
	public ManejoArchivos () throws FileNotFoundException {
	}
	
	/**
	 * Método que retorna un List<String> con cada línea de un archivo .txt
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
	 * Método que elige aleatoriamente una palabra dado un array de String.
	 * Elige una palabra para algún animal, ya sea un tiburón, una piraña o
	 * un tiburón negro.
	 * @return: palabras[aleatorio]
	 */
	public String elegirPalabra () throws IOException {
		String[] palabras = (String[]) this.getLista().toArray(new String[0]);
		int aleatorio = random.nextInt(palabras.length);
		return palabras[aleatorio];
	}
	
	/**
	 * Método que guarda la nueva lista de highScores.
	 * Toma de parámetro un List<String>
	 * @param: lista
	 */
	public void guardarHighScore (List<String> lista) throws FileNotFoundException, UnsupportedEncodingException {
		writer = new PrintWriter(this.nombreArchivo,"UTF-8");
		for (int i=0; i<lista.size(); i++) {
			writer.println(lista.get(i));
		}
		writer.close();
	}
	
	public static boolean verificacionPrevia (String texto) throws Exception {
		if (contieneEspacio(texto) == false && texto.isEmpty() == false) {
			return true;
		} else {
			throw new Exception();
		}
	}
	
	public static boolean contieneEspacio (String texto) {
		String[] elementos = texto.split("");
		
		for (int i=0;i<elementos.length;i++) {
			if (elementos[i].equals(" ")) {
				return true;
			}
		}
		return false;
	}

	public void guardarJuego (String nombre) throws FileNotFoundException, UnsupportedEncodingException {
		writer = new PrintWriter(nombre + "_Partida.txt", "UTF-8");
		writer.println("vidas" + " " + Usuario.vidas);
		writer.println("poderEspecial" + " " + Usuario.poderEspecial);
		writer.println("puntaje" + " " + Usuario.puntaje);
		writer.println("nivel" + " " + Usuario.nivel);
		writer.println("nombre" + " " + nombre);
		writer.println("acumulado" + " " + Usuario.acumulado);
		writer.close();
	}
	
	public void guardarRegistroDePartida (String texto) throws IOException {
		ManejoArchivos m = new ManejoArchivos("Partidas.txt");
		List<String> lista = m.getLista();
		lista.add(texto);
		
		writer = new PrintWriter("Partidas.txt", "UTF-8");
		for (int i=0; i<lista.size(); i++) {
			writer.println(lista.get(i));
		}
		writer.close();
	}
	
	public String extraerDatosPartidaCargada (List<String> lista) {
		String texto = "";
		for (int i=0; i<lista.size(); i++) {
			texto += lista.get(i).split(" ")[1] + " ";
			if (i == lista.size() - 1) {
				texto += lista.get(i).split(" ")[1];
			}
		}
		return texto;
	}
	
}
