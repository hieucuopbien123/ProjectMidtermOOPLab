package application.step;

import java.util.List;

import application.components.graph.Edge;
import application.components.graph.Vertex;
import javafx.scene.control.Label;

public class Step {
	private PseudoStep pseudoStep;
	private DetailStep detailStep;
	
	public Step(List<Label> lines, Label comment, Label note) {
		pseudoStep = new PseudoStep(lines);
		detailStep = new DetailStep(comment, note);
	}
	
	public void addPseudoStep(int step) {
		pseudoStep.addCode(step);
	}
	public boolean emptyPseudoCode() {
		//Systemout.println(pseudoStep.isEmpty());
		return pseudoStep.isEmpty();
	}
	
	public void addEdge(Edge e) {
		detailStep.addEdge(e);
	}
	public void addVertex(Vertex v) {
		detailStep.addVertex(v);
	}
	
	public void runCode() {
		pseudoStep.runNextStep();
		detailStep.runNextStep();
	}
	
	public void addRes(String res) {
		detailStep.addRes(res);
	}
	public void addNote(String note) {
		detailStep.addNote(note);
	}
}
