package application.algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

import application.components.graph.*;
import javafx.scene.control.Label;
import javafx.util.Pair;

public class TopologicalSort extends Algorithm {
	public TopologicalSort(Graph graph, List<Label> pseudoStep, Label comment, Label note) {
		super(graph, pseudoStep, comment, note);
	}
	
	private int numberOfVertex;
	private HashMap<Vertex, Integer> in_degree;
    private Queue<Vertex> q = new LinkedList<Vertex>();
    private int index = 0;
	
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
		
		step.addPseudoStep(0);
		step.addEdge(null);
		step.addVertex(null);
		step.addRes(null);
		step.addNote("setup indegree[]; visited; Q and topo[]");
		
		while(q.size() != 0) {
			step.addPseudoStep(1);
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			step.addNote("Run loop again, Q now has " + q.size() + " elements");
			Vertex temp = q.poll();
			step.addPseudoStep(2);
			step.addEdge(null);
			step.addVertex(temp);
			step.addRes(" " + String.valueOf(temp.getIdOfVertex()));
			step.addNote("Pop out from queue Q then we have the result");

			List<Vertex> adj = getGraph().getAdj().get(temp);
			index++;
			for(int i = 0; i < adj.size(); i++) {
				Vertex tempVertex = adj.get(i);
				step.addPseudoStep(3);
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				step.addNote("for loop adjacent vertex " + tempVertex.getIdOfVertex() + " of vertex " + temp.getIdOfVertex());
				step.addPseudoStep(4);
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				step.addNote("Decrease the in_degree of " + tempVertex.getIdOfVertex());
				int in = in_degree.get(tempVertex) - 1;
				in_degree.put(tempVertex, in);
				if(in == 0) {
					step.addPseudoStep(5);
					step.addEdge(null);
					step.addVertex(null);
					step.addRes(null);
					step.addNote("Here we add " + tempVertex.getIdOfVertex() + " to Q and continue the loop");
					q.offer(tempVertex);
				} else {
					step.addPseudoStep(5);
					step.addEdge(null);
					step.addVertex(null);
					step.addRes(null);
					step.addNote("Because indegree[" + tempVertex.getIdOfVertex() + "] != 0, so we just continue the loop");
				}
			}
			step.addPseudoStep(6);
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			step.addNote("Finish the inside loop and increase the index, which is the number of vertex we have traversed");
		}
		if(index != numberOfVertex) {
			step.addPseudoStep(7);
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			step.addNote("Graph does contain cycle");
			//Systemout.println("Graph contains cycle");
			return;
		}
		step.addPseudoStep(7);
		step.addEdge(null);
		step.addVertex(null);
		step.addRes(null);
		step.addNote("This graph not contain cycle, so finish the alg");
	}
}
