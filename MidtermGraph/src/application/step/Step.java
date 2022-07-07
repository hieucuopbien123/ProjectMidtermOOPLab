package application.step;

import application.components.edge.Edge;
import application.components.vertext.Vertex;
import javafx.scene.control.Label;

public class Step {
	private PseudoStep pseudoStep;
	private DetailStep detailStep;
	
	public Step(Label pseudoCode, Label comment, Label note) {
		pseudoStep = new PseudoStep(pseudoCode);
		detailStep = new DetailStep(comment, note);
	}
	
	public void addPseudoStep(String step) {
		pseudoStep.addCode(step);
	}
	public boolean emptyPseudoCode() {
		System.out.println(pseudoStep.isEmpty());
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
