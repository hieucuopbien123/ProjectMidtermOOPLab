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

import application.components.graph.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Pair;

public class DFS extends Algorithm {
	private HashMap<Pair<Integer, Integer>, Edge> listEdge;
	private Vertex startPoint;
	
	public DFS(Graph graph, List<Label> pseudoStep, Label comment, Label note, HashMap<Pair<Integer, Integer>, Edge> listEdge, int start) {
		super(graph, pseudoStep, comment, note);
		this.listEdge = listEdge;
		this.startPoint = getGraph().getVertext(start);
	}

	private HashMap<Vertex, Boolean> isVisited = new HashMap<Vertex, Boolean>();
	
	@Override
	public void buildStep() {
		if(startPoint != null) {
			//Systemout.println("Starting from " + startPoint.getIdOfVertex());
			step.addPseudoStep(0);
			step.addEdge(null);
			step.addVertex(null);
			step.addRes("Result:");
			step.addNote("Visited from starting point " + startPoint.getIdOfVertex());
		}else {
			step.addNote("Input node not exist in graph");
		}
		runRecursive(startPoint, null);
	}
	
	private void runRecursive(Vertex sPoint, Edge tempEdge) {
		isVisited.put(sPoint, true);
		List<Vertex> adj = getGraph().getAdj().get(sPoint);
		step.addPseudoStep(1);
		step.addEdge(tempEdge);
		step.addVertex(sPoint);
		step.addRes(" " + String.valueOf(sPoint.getIdOfVertex()));
		step.addNote("Assign node " + sPoint.getIdOfVertex() + " to be visited");
		for(int i = 0; i < adj.size(); i++) {
			step.addPseudoStep(2);
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			step.addNote("for loop of node " + sPoint.getIdOfVertex());
			
			step.addPseudoStep(3);
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			Vertex tempVertext = adj.get(i);
			step.addNote("Check Edge " + sPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex());
			
			if(isVisited.getOrDefault(tempVertext, false)) {
				step.addPseudoStep(4);
				step.addNote("Edge " + sPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex() + " was visited, so we continue the loop");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				continue;
			}
			Edge line = listEdge.get(new Pair(sPoint.getIdOfVertex(), tempVertext.getIdOfVertex()));
			if(line == null && !getGraph().getIsDirected()) {
				line = listEdge.get(new Pair(tempVertext.getIdOfVertex(), sPoint.getIdOfVertex()));
			}else if(line == null) {
				return;
			}
			step.addPseudoStep(0);
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			step.addNote("Edge " + sPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex() + " was not visited, so we"
					+ " get the edge " + sPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex() + " and run recursive");
			//Systemout.println("Go from " + sPoint.getIdOfVertex() + " to " + tempVertext.getIdOfVertex());
			runRecursive(tempVertext, line);
		}
	}
	
	
}
