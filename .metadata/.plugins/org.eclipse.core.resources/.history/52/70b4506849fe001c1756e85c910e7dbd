package application.algs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.components.edge.Edge;
import application.components.graph.*;
import application.components.vertext.*;
import application.step.Step;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.util.Pair;

public abstract class Algorithm {
	private Graph graph;
	protected Step step;
	public Algorithm(Graph graph, Label pseudoCode, Label comment, Label note) {
		super();
		this.graph = graph;
		step = new Step(pseudoCode, comment, note);
	}
	
	public void buildStep(Vertex startPoint, HashMap<Pair<Integer, Integer>, Edge> listEdge) { }
	public void buildStep(HashMap<Pair<Integer, Integer>, Edge> listEdge) { }
	public void buildStep() { }
//	public void setup(Vertex startPoint, HashMap<Pair<Integer, Integer>, Edge> listEdge) { }
//	public void setup() { }
	public Graph getGraph() {
		return graph;
	}
	public boolean runNextStep(HashMap<Pair<Integer, Integer>, Edge> listEdge, Label noteText, Label resText) {
		if(step.emptyPseudoCode()) {
			return false;
		}
		step.runCode();
		return true;
	}
}
