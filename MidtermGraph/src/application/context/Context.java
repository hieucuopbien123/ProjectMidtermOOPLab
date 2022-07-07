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
	public void setupAlgorithm(Algorithm alg) {
		this.alg = alg;
	}
	public void play(int start, HashMap<Pair<Integer, Integer>, Edge> listEdge, Label noteText, Label resText) {
		Vertex startPoint = alg.getGraph().getVertext(start);
		if(startPoint != null) {
			System.out.println("Starting from " + startPoint.getIdOfVertex());
	        noteText.setText("Note: Run DFS from node " + start);
	        resText.setText("Result: " + start);
			alg.buildStep(startPoint, listEdge);
		}else {
			noteText.setText("Note: Input node not exist in graph");
		}
	}
//	public void play(int start, HashMap<Pair<Integer, Integer>, Edge> listEdge, Label noteText, Label resText) {
//		Vertex startPoint = alg.getGraph().getVertext(start);
//		if(startPoint != null) {
//			System.out.println("Starting from " + startPoint.getIdOfVertex());
//	        noteText.setText("Note: Run DFS from node " + start);
//	        resText.setText("Result: " + start);
//			alg.setup(startPoint, listEdge);
//		}else {
//			noteText.setText("Note: Input node not exist in graph");
//		}
//	}
	public void play() {
		alg.buildStep();
	}
	public void play(HashMap<Pair<Integer, Integer>, Edge> listEdge) {
		alg.buildStep(listEdge);
	}
	public Algorithm getAlgorithm() {
		return alg;
	}
}
