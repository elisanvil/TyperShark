import java.io.IOException;

public class Usuario {
	public static int vidas = 3;
	public static boolean poderEspecial = false;
	public static int puntaje = 0;
	public static int nivel = 1;
	public static String nombre;
	public static int acumulado = 0;
	
	public static int toquesPirana = 3;
	
	public static void reset () {
		vidas = 3;
		poderEspecial = false;
		puntaje = 0;
		nivel = 1;
		nombre = "";
		acumulado = 0;
	}
	
	public static void aumentarNivel() {
		nivel++;
		OrganizadorJuego.actualizarNivel(nivel);
	}
	
	public static void quitarVida () throws IOException {
		vidas--;
		OrganizadorJuego.actualizarVidas(vidas);
		toquesPirana = 3;
		
		if (vidas <= 0) {
			ControlHilos.detenerJuego();
			if (HighScore.verificarPuntaje(puntaje)) {
				OrganizadorJuego.presentarVentanaGuardar();
			}
		}
	}
	
	public static void quitarVidaDesdePiraña () throws IOException {
		toquesPirana --;
		if (toquesPirana <= 0) {
			quitarVida();
			OrganizadorJuego.actualizarVidas(vidas);
			toquesPirana = 3;
		}
	}
	
	public static void activarPoderEspecial (boolean activar) {
		poderEspecial = activar;
	}
	
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
}
