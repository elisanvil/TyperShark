/*
* @(#)HighScore.java	0.1		24/08/2016

*
* Copyright (c) 2016.
* Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
* ESPOL. Guayaquil, Ecuador.
* Todos los derechos reservados.
*
*/

package keyshark.aplicacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * La clase HighScore almacena los puntajes más altos
 * obtenidos en el juego según el nivel alcanzado.
 * 
 * @version: 	0.1		24/08/2016
 * @author: 	Paul Estrada León, Stefany Lindao Rodríguez, Elizabeth Sánchez Villamar.
 */
public class HighScore {
	
	/**
	 * Método que ordena los puntajes según el nivel alcanzado. Toma los datos de una lista
	 * dentro del archivo highScores.txt
	 * @return: dic
	 */
	public static Map<String,List<String>> ordenarPuntajesPorNivel () throws IOException {
		ManejoArchivos m = new ManejoArchivos("highScores.txt");
		List<String> lista = m.getLista();
		Map<String,List<String>> dic = new HashMap<String,List<String>>();
		
		for (int i = 0; i<lista.size(); i++) {
			String[] componentes = lista.get(i).split(" ");
			if (dic.containsKey(componentes[0])) {
				dic.get(componentes[0]).add(componentes[1] + " " + componentes[2]);
			} else {
				List<String> nuevaLista = new ArrayList<String>();
				nuevaLista.add(componentes[1] + " " + componentes[2]);
				dic.put(componentes[0], nuevaLista);
			}
		}
		return dic;
	}
	
	/**
	 * Método que agrega un puntaje a la lista dentro del archivo highScores.txt.
	 * Los datos agregados incluyen el nickname y el puntaje que alcanzó dicho jugador.
	 * @param: puntaje
	 * @param: nickname
	 * @param: lista
	 * @return: nuevaLista
	 */
	public static List<String> agregarPuntaje (int puntaje, String nickname, List<String> lista) {
		List<String> listaComparar = lista;
		listaComparar.add(nickname + " " + puntaje);
		
		List<String> nuevaLista = new ArrayList<String>();
		
		final int iteraciones = lista.size();
		
		for (int i=0; i<iteraciones; i++) {
			int index = 0;
			int puntajeMaximo = 0;
			String nicknameDeMaximo = "";
			
			for (int f = 0; f < listaComparar.size(); f++) {
				String[] componentes = listaComparar.get(f).split(" ");
				
				if (Integer.parseInt(componentes[1]) > puntajeMaximo) {
					index = f;
					puntajeMaximo = Integer.parseInt(componentes[1]);
					nicknameDeMaximo = componentes[0];
				}
			}
			
			nuevaLista.add(nicknameDeMaximo + " " + puntajeMaximo); 
			listaComparar.remove(index);
		}
		
		while (nuevaLista.size() > 10) {
			nuevaLista.remove(nuevaLista.size() - 1);
		}
		return nuevaLista;
	}
	
	/**
	 * Método que verifica si el jugador batió un nuevo récord de acuerdo a su puntaje obtenido
	 * durante el juego.
	 * @param: puntaje
	 * @param: nickname
	 * @param: nivel
	 */
	public static boolean verificarSiBatioRecord (int puntaje, String nickname, int nivel) throws IOException {
		List<String> lista = HighScore.ordenarPuntajesPorNivel().get(String.valueOf(nivel));
		List<String> nuevaLista = HighScore.agregarPuntaje(puntaje, nickname, lista);
		
		if (nuevaLista.contains(nickname + " " + puntaje)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Método que crea una nueva lista de puntajes máximos.
	 * @param: puntaje
	 * @param: nickname
	 * @param: nivel
	 * @return: listaFinal
	 */
	public static List<String> crearNuevaListaDeHighScores (int puntaje, String nickname, int nivel) throws IOException {
		Map<String, List<String>> mapa = HighScore.ordenarPuntajesPorNivel();
		List<String> lista = mapa.get(String.valueOf(nivel));
		List<String> nuevaLista = HighScore.agregarPuntaje(puntaje, nickname, lista);
		mapa.put(String.valueOf(nivel), nuevaLista);
		
		List<String> listaFinal = new ArrayList<String>();
		String[] llaves = mapa.keySet().toArray(new String[mapa.keySet().size()]);
		
		for (int i = 0; i < llaves.length; i++) {
			List<String> listaDelMapa = mapa.get(llaves[i]);
			
			for (int f = 0; f<listaDelMapa.size(); f++) {
				listaFinal.add(llaves[i] + " " + listaDelMapa.get(f));
			}
		}
		return listaFinal;
	}
}
