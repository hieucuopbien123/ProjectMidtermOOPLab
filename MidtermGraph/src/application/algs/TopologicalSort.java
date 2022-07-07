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
	
	public TopologicalSort(Graph graph, Label pseudoStep, Label comment, Label note) {
		super(graph, pseudoStep, comment, note);
	}
	
	private int numberOfVertex;
	private HashMap<Vertex, Integer> in_degree;
    private Queue<Vertex> q = new LinkedList<Vertex>();
    private int index = 0;

//	@Override
//	public void setup() {
//		numberOfVertex = getGraph().getAdj().keySet().size();
//		in_degree = new HashMap<Vertex, Integer>();
//		for (Vertex key : getGraph().getAdj().keySet()) {
//			Integer tempNum = in_degree.get(key);
//			if(tempNum == null) {
//				in_degree.put(key, 0);
//			}
//			for(Vertex insideVertex: getGraph().getAdj().get(key)){
//				Integer num = in_degree.get(insideVertex);
//				if(num != null)
//					in_degree.put(insideVertex, num + 1);
//				else
//					in_degree.put(insideVertex, 1);
//			}
//		}
//		for(Entry<Vertex,Integer> data: in_degree.entrySet()) {
//			if(data.getValue() == 0) {
//				q.offer(data.getKey());
//			}
//		}
//		index = 0;
//	}
//	
//	public boolean runNextStep(HashMap<Pair<Integer, Integer>, Edge> listEdge, Label noteText, Label resText) {
//		if(q.size() != 0) {
//			Vertex temp = q.poll();
//			System.out.println(temp.getIdOfVertex());
//			noteText.setText("Note: Go to " + temp.getIdOfVertex());
//			resText.setText(resText.getText() + " "+ temp.getIdOfVertex());
//			temp.changeColor();
//			List<Vertex> adj = getGraph().getAdj().get(temp);
//			index++;
//			for(int i = 0; i < adj.size(); i++) {
//				Vertex tempVertex = adj.get(i);
//				int in = in_degree.get(tempVertex) - 1;
//				in_degree.put(tempVertex, in);
//				if(in == 0) {
//					q.offer(tempVertex);
//				}
//			}
//			return true;
//		}else {
//			if(index != numberOfVertex) {
//				System.out.println("Graph contains cycle");
//				noteText.setText("Note: " + "Error graph contains cycle!");
//				return false;
//			}
//		}
//		return false;
//	}
	
	@Override
	public void buildStep() {
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
		
		step.addPseudoStep("indegree[]={O}*V; visited = O; Q = 0; topo = [];\r\n"
				+ "		for each vertex v in graph G\r\n"
				+ "			for each adj vertex av of v\r\n"
				+ "				ingree[av]++;\r\n"
				+ "		for each vertex v in graph G\r\n"
				+ "			if indegree[v] == 0\r\n"
				+ "				add v to Q\r\n");
		step.addEdge(null);
		step.addVertex(null);
		step.addRes(null);
		step.addNote("Setup the algorithm to run");
		
		while(q.size() != 0) {
			step.addPseudoStep("while Q not empty");
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			step.addNote("Run loop again, Q now has " + q.size() + " elements");
			Vertex temp = q.poll();
//			System.out.println(temp.getIdOfVertex());
//			temp.changeColor();
			step.addPseudoStep("v <- dequeue Q\r\n"
					+ "		add v to topo");
			step.addEdge(null);
			step.addVertex(temp);
			step.addRes(" " + String.valueOf(temp.getIdOfVertex()));
			step.addNote("Pop out from queue Q then we have the result");

			List<Vertex> adj = getGraph().getAdj().get(temp);
			index++;
			for(int i = 0; i < adj.size(); i++) {
				Vertex tempVertex = adj.get(i);
				step.addPseudoStep("for each adj vertex av of v\r\n"
						+ "		indegree[av]--");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				step.addNote("for loop adjacent vertex " + tempVertex.getIdOfVertex() + " of vertex " + temp.getIdOfVertex());
				int in = in_degree.get(tempVertex) - 1;
				in_degree.put(tempVertex, in);
				if(in == 0) {
					step.addPseudoStep("if indegree[av] == 0\r\n"
							+ "		add av to Q");
					step.addEdge(null);
					step.addVertex(null);
					step.addRes(null);
					step.addNote("Here we add " + tempVertex.getIdOfVertex() + " to Q and continue the loop");
					q.offer(tempVertex);
				} else {
					step.addPseudoStep("if indegree[av] == 0\r\n"
							+ "		add av to Q");
					step.addEdge(null);
					step.addVertex(null);
					step.addRes(null);
					step.addNote("Because indegree[" + tempVertex.getIdOfVertex() + "] != 0, so we just continue the loop");
				}
			}
			step.addPseudoStep("Visited++");
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			step.addNote("Finish the inside loop and increase the index, which is the number of vertex we have traversed");
		}
		if(index != numberOfVertex) {
			step.addPseudoStep("if visited != V\r\n"
					+ "		error graph contains cycle");
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			step.addNote("Graph does contain cycle");
			System.out.println("Graph contains cycle");
			return;
		}
		step.addPseudoStep("if visited != V\r\n"
				+ "		error graph contains cycle");
		step.addEdge(null);
		step.addVertex(null);
		step.addRes(null);
		step.addNote("This graph not contain cycle, so finish the alg");
	}
}
