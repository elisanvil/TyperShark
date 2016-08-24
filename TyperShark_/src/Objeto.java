import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Objeto implements Runnable {
	private String tipo;
	private int nivel;
	
	private double posicionX;
	private double posicionY;
	
	private Thread hilo;
	private Label label;
	
	private boolean vivo;
	
	private ImageView imageView;

	public Objeto (String tipo, double posicionX, double posicionY, int nivel) {
		this.setTipo(tipo);
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setNivel(nivel);
		this.setImageView(new ImageView());
		label = new Label();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(double posicionX) {
		this.posicionX = posicionX;
	}

	public double getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(double posicionY) {
		this.posicionY = posicionY;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public Thread getHilo() {
		return hilo;
	}

	public void setHilo(Thread hilo) {
		this.hilo = hilo;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
	
}
