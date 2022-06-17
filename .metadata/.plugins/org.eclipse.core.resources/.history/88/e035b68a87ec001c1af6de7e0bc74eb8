package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class Controller {
	
	public static boolean createNew = true;
	
	@FXML
	Button myButton;
	@FXML
	AnchorPane myCanvas;
	
	public void handleMouseClick(MouseEvent e) throws IOException {
		if(createNew) {
			System.out.println("OK");
			System.out.println(e.getX());
			CustomShape shape = new CustomShape();
			shape.setLayoutX(e.getX() - 15);
			shape.setLayoutY(e.getY() - 15);
	        myCanvas.getChildren().add(shape);
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("Shape2.fxml"));
//			Node n = loader.load();
//			myCanvas.getChildren().add(n);
		}
	}
	public void toggleCreateNew() {
		createNew = !createNew;
	}
}
