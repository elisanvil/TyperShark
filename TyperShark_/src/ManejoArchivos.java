import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ManejoArchivos {
	private String nombreArchivo;
	
	private Scanner scanner;
	private FileReader lectorDeArchivo;
	private PrintWriter writer;
	private Random random = new Random();
	
	public ManejoArchivos (String nombreArchivo) throws FileNotFoundException {
		this.nombreArchivo = nombreArchivo;
	}
	
	
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
	
	public String elegirPalabra () throws IOException {
		String[] palabras = (String[]) this.getLista().toArray(new String[0]);
		int aleatorio = random.nextInt(palabras.length);
		return palabras[aleatorio];
	}
	
	public void guardarHighScore (List<String> lista) throws FileNotFoundException, UnsupportedEncodingException {
		writer = new PrintWriter(this.nombreArchivo,"UTF-8");
		for (int i=0; i<lista.size(); i++) {
			writer.println(lista.get(i));
		}
		writer.close();
	}
	
	
}
