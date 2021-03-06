package application.components.graph;

import java.io.IOException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Vertex extends AnchorPane {
	private VertexController controller;
	private boolean isChosenItem = false;
	private static int numberOfChosenItem = 0;
	
	public Vertex() {
		super();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Vertex.fxml"));
			controller = new VertexController();
			loader.setController(controller);
			Node n = loader.load();
			this.getChildren().add(n);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getIdOfVertex() {
		return controller.getId();
	}
	public Circle getVertext() {
		return controller.getVertex();
	}
	public void changeColor() {
		controller.getVertex().setStyle("-fx-fill: #ff7b72");
		isChosenItem = true;
		numberOfChosenItem++;
	}
	public void resetColor() {
		controller.getVertex().setStyle("-fx-fill: #b1dff7");
		isChosenItem = false;
		numberOfChosenItem--;
	}
	public boolean getIsChosenItem() {
		return isChosenItem;
	}
	public static int getNumberOfChosenItem() {
		return numberOfChosenItem;
	}
	public static void resetStaticVar() {
		numberOfChosenItem = 0;
	}
}
