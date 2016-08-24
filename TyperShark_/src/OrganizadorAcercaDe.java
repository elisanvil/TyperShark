import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.List;

import javafx.event.*;

public class OrganizadorAcercaDe {
	private Pane raiz;
	private VBox contenedor;
	private Label textoLabel;
	private Label titulo;
	private Button botonRegresar;
	private ImageView fondo;
	
	public OrganizadorAcercaDe (EventHandler<ActionEvent> handler) throws IOException {
		raiz = new Pane();
		
		fondo = new ImageView();
		fondo.setImage(new Image("oceano.png"));
		fondo.setFitWidth(1000);
		fondo.setFitHeight(800);
		
		String text = new String();
		ManejoArchivos m = new ManejoArchivos("acercaDe.txt");
		List<String> lista = m.getLista();
		for (int i=0;i<lista.size();i++) {
			text += lista.get(i) + "\n";
		}
		
		titulo = new Label("ACERCA DE...");
		titulo.setFont(new Font("helvetica",50.0));
		titulo.setTextFill(Color.WHITE);
		
		textoLabel = new Label();
		textoLabel.setText(text);
		textoLabel.setFont(new Font("helvetica",20.0));
		textoLabel.setTextFill(Color.WHITE);
		
		botonRegresar = new Button("Regresar");
		botonRegresar.setOnAction(handler);
		
		contenedor = new VBox();
		contenedor.getChildren().addAll(titulo,textoLabel,botonRegresar);
		contenedor.setSpacing(50);
		contenedor.setAlignment(Pos.CENTER);
		contenedor.setLayoutX(320);
		contenedor.setLayoutY(75);
		
		raiz.getChildren().addAll(fondo,contenedor);
	}
	
	public Pane getRaiz () {
		return this.raiz;
	}
}
