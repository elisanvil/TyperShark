/**
 * 
 */

package typershark;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * @author Elizabeth Sánchez, Paul Estrada, Stefany Lindao.
 *
 */
public class PaneOrganizer {
	
	private Pane root;
	private String img = "Images/oceano3.jpg";
	
	private Image imgScore = new Image("Images/score.png");
	private Image imgLives = new Image("Images/snorkel.png");
	private Image imgLevel = new Image("Images/level.png");
	private Image imgDiver = new Image("Images/diver.gif");
	private Image imgShark = new Image("Images/shark.gif");
	private Image imgSharkb = new Image("Images/sharkb.gif");
	private Image imgPirana = new Image("Images/pez.gif");
	
	private ImageView score = new ImageView();
	private ImageView lives = new ImageView();
	private ImageView level = new ImageView();
	private ImageView diver = new ImageView();
	private ImageView shark = new ImageView();
	private ImageView sharkb = new ImageView();
	private ImageView shark2 = new ImageView();
	private ImageView sharkb2 = new ImageView();
	private ImageView pirana = new ImageView();
    
	public PaneOrganizer(){
		root = new Pane();
		
        root.setStyle("-fx-background-image: url('" + img + "'); "
           + "-fx-background-position: center center; "
           + "-fx-background-repeat: stretch;");
        
        score.setImage(imgScore);
        lives.setImage(imgLives);
        level.setImage(imgLevel);
        diver.setImage(imgDiver);
        shark.setImage(imgShark);
        shark2.setImage(imgShark);
        sharkb2.setImage(imgSharkb);
        sharkb.setImage(imgSharkb);
        pirana.setImage(imgPirana);
        
        score.setFitWidth(35);
        score.setFitHeight(35);
        score.setX(25);
        score.setY(10);
        
        lives.setFitWidth(35);
        lives.setFitHeight(35);
        lives.setX(225);
        lives.setY(10);
        
        level.setFitWidth(60);
        level.setFitHeight(20);
        level.setX(425);
        level.setY(18);
        
        diver.setFitWidth(200);
        diver.setFitHeight(100);
        diver.setX(0);
        diver.setY(70);
        
        shark.setFitWidth(200);
        shark.setFitHeight(80);
        shark.setX(680);
        shark.setY(80);
        
        sharkb.setFitWidth(200);
        sharkb.setFitHeight(150);
        sharkb.setX(680);
        sharkb.setY(120);
        
        pirana.setFitWidth(65);
        pirana.setFitHeight(40);
        pirana.setX(680);
        pirana.setY(240);
        
        shark2.setFitWidth(200);
        shark2.setFitHeight(100);
        shark2.setX(680);
        shark2.setY(270);
        
        sharkb2.setFitWidth(200);
        sharkb2.setFitHeight(150);
        sharkb2.setX(680);
        sharkb2.setY(340);
        
        root.getChildren().addAll(score, lives, level, diver, shark, sharkb, pirana);
	}
	
	
	public Pane getRoot() {
		return root;
	}

}
