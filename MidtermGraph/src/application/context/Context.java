package application.context;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.algs.Algorithm;
import application.components.graph.Edge;
import application.components.graph.Vertex;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.util.Pair;

public class Context {
	private Algorithm alg;
	public void setAlgorithm(Algorithm alg) {
		this.alg = alg;
	}
	public void play() {
		long startTime = System.nanoTime();
		alg.buildStep();
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
	public Algorithm getAlgorithm() {
		return alg;
	}
}
