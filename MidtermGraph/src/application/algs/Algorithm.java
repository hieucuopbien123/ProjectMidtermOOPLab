package application.algs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.components.graph.*;
import application.step.Step;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.util.Pair;

public abstract class Algorithm {
	private Graph graph;
	protected Step step;
	public Algorithm(Graph graph, List<Label> lines, Label comment, Label note) {
		super();
		this.graph = graph;
		step = new Step(lines, comment, note);
	}
	
	public abstract void buildStep();
	public Graph getGraph() {
		return graph;
	}
	public boolean runNextStep() {
		if(step.emptyPseudoCode()) {
			return false;
		}
		step.runCode();
		return true;
	}
}
