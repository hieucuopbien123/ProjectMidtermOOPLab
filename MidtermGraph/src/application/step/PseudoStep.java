package application.step;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.scene.control.Label;

public class PseudoStep {
	private List<Label> lines;
	private Queue<Integer> qPseudoCode = new LinkedList<Integer>();
	
	public PseudoStep(List<Label> lines) {
		this.lines = lines;
	}
	
	public void setPseudoCode(Integer index) {
		for(int i = 0; i < 8; i++) {
			if(i == index) {
				this.lines.get(i).setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 14px; -fx-font-family: SansSerif;");
			}else {
				//Systemout.println("Run here " + i);
				this.lines.get(i).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
			}
		}
	}
	public void runNextStep() {
		if(!qPseudoCode.isEmpty()) {
			setPseudoCode(qPseudoCode.poll());
		}
	}
	public void addCode(int data) {
		qPseudoCode.offer(data);
	}
	public boolean isEmpty() {
		return qPseudoCode.isEmpty();
	}
}
