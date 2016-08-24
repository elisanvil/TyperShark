import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Tiburon extends Objeto implements Movimiento, Animacion, ProcesarLetra, Runnable {

	private boolean matando;
	private String palabraAsignada;
	private String letrasRestantes;
	private String letrasIngresadas = "";
	
	public Tiburon(Double posicionX, Double posicionY) throws FileNotFoundException, IOException {
		super("tiburon", posicionX, posicionY, 1);
		super.setVivo(false);
		super.getImageView().setImage(new Image("tiburon.gif"));
		super.getImageView().setLayoutX(posicionX);
		super.getImageView().setLayoutY(posicionY);
		super.getImageView().setFitWidth(300);
		super.getImageView().setPreserveRatio(true);
		
		super.getLabel().setTextFill(Color.WHITE);
		super.getLabel().setLayoutX(posicionX);
		super.getLabel().setLayoutY(posicionY);
	}

	@Override
	public void run() {
		setVivo(true);
		while (isVivo()) {
			Platform.runLater(new Runnable() {
				public void run () {
					if (palabraAsignada.equals(letrasIngresadas.toLowerCase())) {
						if (matando == false) {
							Usuario.actualizarPuntaje(100);
							matando = true;
						} else {
							matar();
						}
					} else if (getImageView().getLayoutX() <= 30.0) {
						if (matando == false) {
							try {
								Usuario.quitarVida();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							matando = true;
						} else {
							if (getImageView().getLayoutX() <= -300.0) {
								matar();
							} else {
								mover(-0.25,0.0);
							}
						}
					} else {
						mover(-0.25,0.0);
					}
				}
			});
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mover(double x, double y) {
		super.getImageView().setLayoutX(super.getImageView().getLayoutX() + (x*Usuario.nivel));
		super.getImageView().setLayoutY(super.getImageView().getLayoutY() + y);
		
		super.getLabel().setLayoutX(super.getLabel().getLayoutX() + (x*Usuario.nivel));
		super.getLabel().setLayoutY(super.getLabel().getLayoutY() + y);
	}

	@Override
	public void matar() {
		mover(-0.5,5.0);
		if (getImageView().getLayoutY() >= 700.0) {
			this.setHilo(null);
			this.setVivo(false);
		}
	}

	@Override
	public void procesar(String letra) {
		if (super.isVivo() && this.letrasRestantes.startsWith(letra)) {
			this.letrasIngresadas = this.letrasIngresadas + letra.toUpperCase();
			this.letrasRestantes = recortarString(this.letrasRestantes);
			super.getLabel().setText(this.letrasIngresadas + this.letrasRestantes);
		}
	}
	
	public void colocarPalabra () throws FileNotFoundException, IOException {
		ManejoArchivos lector = new ManejoArchivos("palabras.txt");
		this.letrasIngresadas = "";
		this.palabraAsignada = lector.elegirPalabra();
		this.letrasRestantes = this.palabraAsignada;
		super.getLabel().setText(this.palabraAsignada);
	}
	
	public String recortarString (String palabra) {
		String[] array = palabra.split("");
		String nuevaPalabra = new String();
		for (int i=1;i<palabra.length();i++){
			nuevaPalabra = nuevaPalabra + array[i];
		}
		return nuevaPalabra;
	}
	
	public void muerteInmediata () {
		this.letrasIngresadas = this.palabraAsignada;
	}
	
	public void resetMatando () {
		matando = false;
	}
}
