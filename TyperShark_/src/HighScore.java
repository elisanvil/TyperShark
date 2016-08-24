import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
public class HighScore {
	
	public static int[] getHighScoresArray () throws FileNotFoundException, IOException {
		List<String> lista = (new ManejoArchivos("highScores.txt")).getLista();
		int [] puntajes = {0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<lista.size();i++){
			String[] elementos = lista.get(i).split(" ");
			puntajes[i] = Integer.parseInt(elementos[1]);
		}
		return puntajes;
	}
	
	
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
	
	public static TreeSet<Integer> getHighScoreTreeSet () throws FileNotFoundException, IOException {
		List<String> lista = (new ManejoArchivos("highScores.txt")).getLista();
		TreeSet<Integer> treeSet = new TreeSet<Integer> ();
		for(int i=0;i<lista.size();i++){
			String[] elementos = lista.get(i).split(" ");
			treeSet.add(Integer.parseInt(elementos[1]));
		}
		return treeSet;
	}
	
	public static Map<String,Integer> getHighScoreMap () throws FileNotFoundException, IOException {
		List<String> lista = (new ManejoArchivos("highScores.txt")).getLista();
		Map<String,Integer> map = new HashMap<String,Integer> ();
		for(int i=0;i<lista.size();i++){
			String[] elementos = lista.get(i).split(" ");
			map.put(elementos[0], Integer.parseInt(elementos[1]));
		}
		return map;
	}
	
	public static String getKey(Map<String,Integer> map,int objeto) throws FileNotFoundException, IOException {
		Set<String> set = map.keySet();
		for (String i:set) {
			if (map.get(i) == objeto) {
				return i;
			}
		}
		return null;
	}
	
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
