package application.algs;

import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import application.components.edge.Edge;
import application.components.graph.*;
import application.components.vertext.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Pair;

public class DFS extends Algorithm {
	private HashMap<Pair<Integer, Integer>, Edge> listEdge;
	private Vertex startPoint;
	
	public DFS(Graph graph, Label pseudoStep, Label comment, Label note, HashMap<Pair<Integer, Integer>, Edge> listEdge, int start) {
		super(graph, pseudoStep, comment, note);
		this.listEdge = listEdge;
		this.startPoint = getGraph().getVertext(start);
	}

	private HashMap<Vertex, Boolean> isVisited = new HashMap<Vertex, Boolean>();
	
	@Override
	public void buildStep() {
		if(startPoint != null) {
			System.out.println("Starting from " + startPoint.getIdOfVertex());
			step.addNote("Note: Run DFS from node " + startPoint.getIdOfVertex());
			step.addRes("Result: " + startPoint.getIdOfVertex());
		}else {
			step.addNote("Note: Input node not exist in graph");
		}
		runRecursive(startPoint, listEdge);
	}
	
	public void runRecursive(Vertex sPoint, HashMap<Pair<Integer, Integer>, Edge> lEdge) {
		isVisited.put(sPoint, true);
		List<Vertex> adj = getGraph().getAdj().get(sPoint);
		step.addPseudoStep("u.visited = true");
		step.addEdge(null);
		step.addVertex(sPoint);
		step.addRes(null);
		step.addNote("Assign node " + sPoint.getIdOfVertex() + " to be visited");
		for(int i = 0; i < adj.size(); i++) {
			step.addPseudoStep("for each vervex v in G.Adj[u]");
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			step.addNote(null);
			step.addPseudoStep("if v.visited == false");
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			Vertex tempVertext = adj.get(i);
			step.addNote("Check Edge " + sPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex());
			if(isVisited.getOrDefault(tempVertext, false)) {
				step.addPseudoStep("else go next");
				step.addNote("Edge " + sPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex() + " was visited, so we continue the loop");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				continue;
			}
			Edge line = lEdge.get(new Pair(sPoint.getIdOfVertex(), tempVertext.getIdOfVertex()));
			if(line == null && !getGraph().getIsDirected()) {
				line = lEdge.get(new Pair(tempVertext.getIdOfVertex(), sPoint.getIdOfVertex()));
			}else if(line == null) {
				return;
			}
			step.addPseudoStep("DFS(G,v)");
			step.addEdge(line);
			step.addVertex(tempVertext);
			step.addRes(" " + String.valueOf(tempVertext.getIdOfVertex()));
			step.addNote("Edge " + sPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex() + " was not visited, so we"
					+ " get the edge " + sPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex() + " and run recursive");
			System.out.println("Go from " + sPoint.getIdOfVertex() + " to " + tempVertext.getIdOfVertex());
			runRecursive(tempVertext, lEdge);
		}
	}
	
	
}
