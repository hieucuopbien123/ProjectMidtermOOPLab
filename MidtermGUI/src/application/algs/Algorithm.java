package application.algs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.components.edge.Edge;
import application.components.graph.*;
import application.components.vertext.*;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.util.Pair;

public abstract class Algorithm {
	private Graph graph;
	public Algorithm(Graph graph) {
		super();
		this.graph = graph;
	}
	public void setup(Vertex startPoint, HashMap<Pair<Integer, Integer>, Edge> listEdge) { }
	public void setup() { }
	public Graph getGraph() {
		return graph;
	}
	public boolean runNextStep(HashMap<Pair<Integer, Integer>, Edge> listEdge, Label noteText, Label resText) {
		return false;
	}
}
