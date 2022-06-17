package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CircleController implements Initializable {

	@FXML
	private Text text;
	@FXML
	private Circle circle;
	
	private int id = 0;
	private static int increaseID = 0;
	private static TreeSet<Integer> deletedId = new TreeSet<Integer>();
	
	private static int numberChosen = 0;
	public CircleController() {
		super();
		if(deletedId.size() == 0) {
			id = ++increaseID;
		}else {
			id = deletedId.first();
			deletedId.remove(deletedId.first());
		}
		System.out.println("New circle created");
	}
	
	//k set text trong controller đc vì nó null chưa tồn tại, nếu ta dùng new thì cx k đc vì sau constructor, nó mới khởi tạo lại là null
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		text.setText(String.valueOf(id));
	}
	public Circle getCircle() {
		return circle;
	}
	public Text getText() {
		return text;
	}
	
	public void chooseVertex() {
		if(numberChosen < 2) {
			circle.setFill(Color.RED);
			numberChosen++;
		}
	}
}
