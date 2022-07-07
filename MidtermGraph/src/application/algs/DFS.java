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
	
	public DFS(Graph graph, Label pseudoStep, Label comment, Label note) {
		super(graph, pseudoStep, comment, note);
	}

//	Stack<Vertex> listVertex = new Stack<Vertex>();
	private HashMap<Vertex, Boolean> isVisited = new HashMap<Vertex, Boolean>();
//	Stack<Vertex> deletedVertex = new Stack<Vertex>();

//	@Override
//	public void setup(Vertex startPoint, HashMap<Pair<Integer, Integer>, Edge> listEdge) {
//		listVertex = new Stack<Vertex>();
//		listVertex.push(startPoint);
//		if(listVertex.size() > 0) {
//			Vertex temp = listVertex.pop();
//			temp.changeColor();
//			deletedVertex.push(temp);
//			isVisited.put(temp, true);
//			List<Vertex> adj = getGraph().getAdj().get(temp);
//			System.out.println("Start from " + temp.getIdOfVertex());
//			for(int i = 0; i < adj.size(); i++) {
//				Vertex tempVertext = adj.get(i);
//				if(isVisited.getOrDefault(tempVertext, false)) {
//					continue;
//				}
//				listVertex.push(tempVertext);
//			}
//		}
//	}
//	
//	public boolean runNextStep(HashMap<Pair<Integer, Integer>, Edge> listEdge, Label noteText, Label resText) {
//		if(listVertex.size() > 0) {
//			Vertex temp = listVertex.pop();
//			if(deletedVertex.size() <= 0) {
//				//reset láº¡i tá»« Ä‘áº§u
//				return false;
//			}
//			System.out.println("Go from " + deletedVertex.peek().getIdOfVertex() + " to " + temp.getIdOfVertex());
//			Edge line = listEdge.get(new Pair(deletedVertex.peek().getIdOfVertex(), temp.getIdOfVertex()));
//			if(line == null && !getGraph().getIsDirected()) {
//				line = listEdge.get(new Pair(temp.getIdOfVertex(), deletedVertex.peek().getIdOfVertex()));
//			}else if(line == null) {
////				reset láº¡i tá»« Ä‘áº§u vÃ¬ Ä‘Æ°á»�ng Ä‘i tiáº¿p k cÃ²n mÃ  bá»‹ ngÆ°á»£c hÆ°á»›ng
//				return false;
//			}
//			noteText.setText("Note: " + "Go from " + deletedVertex.peek().getIdOfVertex() + " to " + temp.getIdOfVertex());
//			resText.setText(resText.getText() + " " + temp.getIdOfVertex());
//			line.setColor();
//			temp.changeColor();
//			deletedVertex.push(temp);
//			isVisited.put(temp, true);
//			List<Vertex> adj = getGraph().getAdj().get(temp);
//			boolean check = false;
//			for(int i = 0; i < adj.size(); i++) {
//				Vertex tempVertext = adj.get(i);
//				if(isVisited.getOrDefault(tempVertext, false)) {
//					continue;
//				}
//				check = true;
//				listVertex.push(tempVertext);
//			}
//			if(check == false) {
//				deletedVertex.pop().getIdOfVertex();
//				while(check == false) {
//					Vertex abc = deletedVertex.peek();
//					List<Vertex> adj1 = getGraph().getAdj().get(abc);
//					for(int i = 0; i < adj1.size(); i++) {
//						Vertex tempVertext = adj1.get(i);
//						if(isVisited.getOrDefault(tempVertext, false)) {
//							continue;
//						}
//						check = true;
//					}
//					if(adj1.size() <= 0) {
//						check = true;
//					}
//					if(check == false && deletedVertex.size() > 0) {
//						deletedVertex.pop();
//					}
//					if(deletedVertex.size() <= 0){
//						check = true;
//					}
//				}
//			}
//			return true;
//		}
//		return false;
//	}

//	@Override
//	public void setup(Vertex startPoint, HashMap<Pair<Integer, Integer>, Edge> listEdge) {
//		Stack<Vertex> listVertex = new Stack<Vertex>();
//		listVertex.push(startPoint);
//		int check = 0;
//		while(listVertex.size() > 0) {
////			while(check == 1) {
////				try {
////					Thread.sleep(2000);
////					check = 0;
////				} catch (InterruptedException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////			}
//			if(check == 0) {
//				Vertex temp = listVertex.pop();
//				isVisited.put(temp, true);
//				List<Vertex> adj = getGraph().getAdj().get(temp);
//				System.out.println(temp.getIdOfVertex());
//				for(int i = 0; i < adj.size(); i++) {
//					Vertex tempVertext = adj.get(i);
//					if(isVisited.getOrDefault(tempVertext, false)) {
//						continue;
//					}
//					listVertex.push(tempVertext);
//				}
//			}
//			check = 1;
//		}
//	}
	
//	@Override
//	public void execute(Vertex startPoint, HashMap<Pair<Integer, Integer>, Line> listEdge) {
//		Stack<Vertex> listVertex = new Stack<Vertex>();
//		listVertex.push(startPoint);
//		while(listVertex.size() > 0) {
//			Vertex temp = listVertex.pop();
//			isVisited.put(temp, true);
//			List<Vertex> adj = getGraph().getAdj().get(temp);
//			System.out.println(temp.getIdOfVertex());
//			for(int i = 0; i < adj.size(); i++) {
//				Vertex tempVertext = adj.get(i);
//				if(isVisited.getOrDefault(tempVertext, false)) {
//					continue;
//				}
//				listVertex.push(tempVertext);
//			}
//		}
//	}
	
	@Override
	public void buildStep(Vertex startPoint, HashMap<Pair<Integer, Integer>, Edge> listEdge) {
		isVisited.put(startPoint, true);
		List<Vertex> adj = getGraph().getAdj().get(startPoint);
		step.addPseudoStep("u.visited = true");
		step.addEdge(null);
		step.addVertex(startPoint);
		step.addRes(null);
		step.addNote("Assign node " + startPoint.getIdOfVertex() + " to be visited");
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
			step.addNote("Check Edge " + startPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex());
			if(isVisited.getOrDefault(tempVertext, false)) {
				step.addPseudoStep("else go next");
				step.addNote("Edge " + startPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex() + " was visited, so we continue the loop");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				continue;
			}
//			Edge temp = listEdge.get(new Pair(startPoint.getIdOfVertex(), tempVertext.getIdOfVertex()));
			Edge line = listEdge.get(new Pair(startPoint.getIdOfVertex(), tempVertext.getIdOfVertex()));
			if(line == null && !getGraph().getIsDirected()) {
				line = listEdge.get(new Pair(tempVertext.getIdOfVertex(), startPoint.getIdOfVertex()));
			}else if(line == null) {
				return;
			}
			step.addPseudoStep("DFS(G,v)");
			step.addEdge(line);
			step.addVertex(tempVertext);
			step.addRes(" " + String.valueOf(tempVertext.getIdOfVertex()));
			step.addNote("Edge " + startPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex() + " was not visited, so we"
					+ " get the edge " + startPoint.getIdOfVertex() + " -- " + tempVertext.getIdOfVertex() + " and run recursive");
//			temp.setStroke(Color.RED);
//			qEdge.offer(temp);
//			qVertex.offer(startPoint);
//			qVertex.offer(tempVertext);
//			temp.setStroke(Color.BLACK);
			System.out.println("Go from " + startPoint.getIdOfVertex() + " to " + tempVertext.getIdOfVertex());
			buildStep(tempVertext, listEdge);
		}
	}
	
	
}
