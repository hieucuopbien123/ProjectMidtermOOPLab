package application;

import java.io.IOException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class CustomShape extends AnchorPane {
	CircleController controller;
//	ObjectProperty<Paint> colorProps = new SimpleObjectProperty<>(Color.BLUE);
	public CustomShape() {
		super();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomShape.fxml"));
			controller = new CircleController();
			loader.setController(controller);
			Node n = loader.load();
			this.getChildren().add(n);
//			controller.getCircle().fillProperty().bind(colorProps);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
