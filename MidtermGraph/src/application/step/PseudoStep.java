package application.step;

import java.util.LinkedList;
import java.util.Queue;

import javafx.scene.control.Label;

public class PseudoStep {
	private Label pseudoCode;
	private Queue<String> qPseudoCode = new LinkedList<String>();
	
	public PseudoStep(Label showLabel) {
		pseudoCode = showLabel;
	}
	
	public void setPseudoCode(String text) {
		pseudoCode.setText(text);
	}
	public void runNextStep() {
		if(!qPseudoCode.isEmpty()) {
			setPseudoCode("		" + qPseudoCode.poll());
		}
	}
	public void addCode(String data) {
		qPseudoCode.offer(data);
	}
	public boolean isEmpty() {
		return qPseudoCode.isEmpty();
	}
}
