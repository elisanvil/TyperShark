import javafx.application.Platform;
import javafx.scene.image.Image;

public class Buceador extends Objeto implements Runnable, Movimiento {

	public Buceador(Double posicionX, Double posicionY) {
		super("buceador", posicionX, posicionY, 1);
		super.getImageView().setImage(new Image("diver.gif"));
		super.getImageView().setLayoutX(posicionX);
		super.getImageView().setLayoutY(posicionY);
		super.getImageView().setFitWidth(200);
		super.getImageView().setPreserveRatio(true);
		super.setVivo(true);
	}
	
	
	@Override
	public void run() {
		while (isVivo()) {
			Platform.runLater(new Runnable() {
				public void run () {
					mover(0.0,1.0);
					if (getImageView().getLayoutY() >= 590.0) {
						Usuario.aumentarNivel();
						getImageView().setLayoutY(30.0);
					}
				}
			});
		
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mover(double x, double y) {
		super.getImageView().setLayoutX(super.getImageView().getLayoutX() + x);
		super.getImageView().setLayoutY(super.getImageView().getLayoutY() + y);
	}
}
