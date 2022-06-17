package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Shape2Controller implements Initializable {
	@FXML
	Circle myCircle;
	@FXML
	Text text;
	
	private int id = 0;
	private static int increaseID = 0;
	private static TreeSet<Integer> deletedId = new TreeSet<Integer>();
	
	public Shape2Controller(){
		super();
		if(deletedId.size() == 0) {
			id = ++increaseID;
		}else {
			id = deletedId.first();
			deletedId.remove(deletedId.first());
		}
		System.out.println("New circle created");
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		text.setText(String.valueOf(id));
	}
}
