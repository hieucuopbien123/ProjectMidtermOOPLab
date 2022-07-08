package application.context;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.algs.Algorithm;
import application.components.edge.Edge;
import application.components.vertext.Vertex;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.util.Pair;

public class Context {
	private Algorithm alg;
	public void setAlgorithm(Algorithm alg) {
		this.alg = alg;
	}
	public void play() {
		alg.buildStep();
	}
	public Algorithm getAlgorithm() {
		return alg;
	}
}
