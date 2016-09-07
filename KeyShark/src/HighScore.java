/*
* @(#)HighScore.java	0.1		24/08/2016

*
* Copyright (c) 2016.
* Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * La clase HighScore almacena los puntajes m�s altos
 * obtenidos en el juego.
 * 
 * @version: 	0.1		24/08/2016
 * @author: 	Paul Estrada Le�n, Stefany Lindao Rodr�guez, Elizabeth S�nchez Villamar.
 */
public class HighScore {
	
	/**
	 * M�todo est�tico que retorna un array de enteros de tama�o 10 con las mejores puntuaciones
	 * recolectadas desde un archivo .txt
	 * @return: puntajes
	 */
	public static int[] getHighScoresArray () throws FileNotFoundException, IOException {
		List<String> lista = (new ManejoArchivos("highScores.txt")).getLista();
		int [] puntajes = {0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<lista.size();i++){
			String[] elementos = lista.get(i).split(" ");
			puntajes[i] = Integer.parseInt(elementos[1]);
		}
		return puntajes;
	}
	
	/**
	 * M�todo est�tico que retorna un boolean indicando si el puntaje ingresado califica entre los mejores 
	 * 10 puntajes del archivo .txt
	 * @param: puntaje
	 */
	public static boolean verificarPuntaje (int puntaje) throws FileNotFoundException, IOException {
		int[] puntajes = getHighScoresArray();
		if (puntaje == 0) {
			return false;
		} else {
			for (int i=0; i<puntajes.length;i++) {
				if (puntaje >= puntajes[i]) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * M�todo est�tico que retorna un TreeSet<Integer> que contiene los puntajes ordenados 
	 * recolectados del archivo .txt
	 * @return: treeSet
	 */
	public static TreeSet<Integer> getHighScoreTreeSet () throws FileNotFoundException, IOException {
		List<String> lista = (new ManejoArchivos("highScores.txt")).getLista();
		TreeSet<Integer> treeSet = new TreeSet<Integer> ();
		for(int i=0;i<lista.size();i++){
			String[] elementos = lista.get(i).split(" ");
			treeSet.add(Integer.parseInt(elementos[1]));
		}
		return treeSet;
	}
	
	/**
	 * M�todo est�tico que retorna un Map<String,Integer> con los puntajes recolectados del archivo .txt 
	 * que contiene los puntajes m�s altos. El key es el nombre del jugador y el valor es el puntaje obtenido.
	 * @return: map
	 */
	public static Map<String,Integer> getHighScoreMap () throws FileNotFoundException, IOException {
		List<String> lista = (new ManejoArchivos("highScores.txt")).getLista();
		Map<String,Integer> map = new HashMap<String,Integer> ();
		for(int i=0;i<lista.size();i++){
			String[] elementos = lista.get(i).split(" ");
			map.put(elementos[0], Integer.parseInt(elementos[1]));
		}
		return map;
	}
	
	/**
	 * M�todo est�tico que toma como par�metro un Map<String,Integer> y un objeto.
	 * Retorna el key al cual el objeto responde en el Map<String,Integer>
	 * @param: map
	 * @param: objeto
	 * @return: i
	 */
	public static String getKey(Map<String,Integer> map,int objeto) throws FileNotFoundException, IOException {
		Set<String> set = map.keySet();
		for (String i:set) {
			if (map.get(i) == objeto) {
				return i;
			}
		}
		return null;
	}
	
	/**
	 * M�todo est�tico que retorna una nueva lista de highScores con el nickname y puntaje nuevo ingresado 
	 * como un List<String> que contiene en cada l�nea el nombre del jugador y su puntaje separado por un espacio.
	 * @param: nickname
	 * @param: puntaje
	 * @return: nuevaLista
	 */
	public static List<String> nuevaListaHighScore (String nickname, int puntaje) throws FileNotFoundException, IOException {
		List<String> nuevaLista = new ArrayList<String> ();
		Map<String,Integer> map = getHighScoreMap();
		map.put(nickname, puntaje);
		TreeSet<Integer> treeSet = getHighScoreTreeSet();
		treeSet.add(puntaje);
		
		for (int i:treeSet.descendingSet()) {
			nuevaLista.add(getKey(map,i) + " " + i);
		}
		if (nuevaLista.size() > 10) {
			nuevaLista.remove(10);
		}
		return nuevaLista;
	}
	
}
