package application.algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

import application.components.edge.Edge;
import application.components.graph.*;
import application.components.vertext.*;
import javafx.scene.control.Label;
import javafx.util.Pair;

public class TopologicalSort extends Algorithm {
	
	public TopologicalSort(Graph graph) {
		super(graph);
	}
	
	int numberOfVertex;
	private HashMap<Vertex, Integer> in_degree;
    private Queue<Vertex> q = new LinkedList<Vertex>();
    private int index = 0;

	@Override
	public void setup() {
		numberOfVertex = getGraph().getAdj().keySet().size();
		in_degree = new HashMap<Vertex, Integer>();
		for (Vertex key : getGraph().getAdj().keySet()) {
			Integer tempNum = in_degree.get(key);
			if(tempNum == null) {
				in_degree.put(key, 0);
			}
			for(Vertex insideVertex: getGraph().getAdj().get(key)){
				Integer num = in_degree.get(insideVertex);
				if(num != null)
					in_degree.put(insideVertex, num + 1);
				else
					in_degree.put(insideVertex, 1);
			}
		}
		for(Entry<Vertex,Integer> data: in_degree.entrySet()) {
			if(data.getValue() == 0) {
				q.offer(data.getKey());
			}
		}
		index = 0;
	}
	
	public boolean runNextStep(HashMap<Pair<Integer, Integer>, Edge> listEdge, Label noteText, Label resText) {
		if(q.size() != 0) {
			Vertex temp = q.poll();
			System.out.println(temp.getIdOfVertex());
			noteText.setText("Note: Go to " + temp.getIdOfVertex());
			resText.setText(resText.getText() + " "+ temp.getIdOfVertex());
			temp.changeColor();
			List<Vertex> adj = getGraph().getAdj().get(temp);
			index++;
			for(int i = 0; i < adj.size(); i++) {
				Vertex tempVertex = adj.get(i);
				int in = in_degree.get(tempVertex) - 1;
				in_degree.put(tempVertex, in);
				if(in == 0) {
					q.offer(tempVertex);
				}
			}
			return true;
		}else {
			if(index != numberOfVertex) {
				System.out.println("Graph contains cycle");
				noteText.setText("Note: " + "Error graph contains cycle!");
				return false;
			}
		}
		return true;
	}
}