package application.components.graph;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class VertexController implements Initializable {
	@FXML
	private Circle vertex;
	@FXML
	private Text _id;
	
	private int id = 0;
	private static int increaseID = 0;
	private static TreeSet<Integer> deletedId = new TreeSet<Integer>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(deletedId.size() == 0) {
			id = ++increaseID;
		}else {
			id = deletedId.first();
			deletedId.remove(deletedId.first());
		}
		_id.setText(String.valueOf(id));
	}
	public Circle getVertex() {
		return vertex;
	}
	public int getId() {
		return id;
	}
	public static void resetId() {
		increaseID = 0;
		deletedId.clear();
	}
	public static void addToDeletedStack(int i) {
		deletedId.add(i);
	}
}
