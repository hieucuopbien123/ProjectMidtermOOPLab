package application.algs;

import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	HashMap<Vertex, Boolean> isVisited = new HashMap<Vertex, Boolean>();
	Stack<Vertex> deletedVertex = new Stack<Vertex>();
	public DFS(Graph graph) {
		super(graph);
	}
	
	Stack<Vertex> listVertex = new Stack<Vertex>();

	@Override
	public void setup(Vertex startPoint, HashMap<Pair<Integer, Integer>, Edge> listEdge) {
		listVertex = new Stack<Vertex>();
		listVertex.push(startPoint);
		if(listVertex.size() > 0) {
			Vertex temp = listVertex.pop();
			temp.changeColor();
			deletedVertex.push(temp);
			isVisited.put(temp, true);
			List<Vertex> adj = getGraph().getAdj().get(temp);
			System.out.println("Start from " + temp.getIdOfVertex());
			for(int i = 0; i < adj.size(); i++) {
				Vertex tempVertext = adj.get(i);
				if(isVisited.getOrDefault(tempVertext, false)) {
					continue;
				}
				listVertex.push(tempVertext);
			}
		}
	}
	
	public boolean runNextStep(HashMap<Pair<Integer, Integer>, Edge> listEdge, Label noteText, Label resText) {
		if(listVertex.size() > 0) {
			Vertex temp = listVertex.pop();
			if(deletedVertex.size() <= 0) {
				//reset lại từ đầu
				return false;
			}
			System.out.println("Go from " + deletedVertex.peek().getIdOfVertex() + " to " + temp.getIdOfVertex());
			Edge line = listEdge.get(new Pair(deletedVertex.peek().getIdOfVertex(), temp.getIdOfVertex()));
			if(line == null && !getGraph().getIsDirected()) {
				line = listEdge.get(new Pair(temp.getIdOfVertex(), deletedVertex.peek().getIdOfVertex()));
			}else if(line == null) {
//				reset lại từ đầu vì đường đi tiếp k còn mà bị ngược hướng
				return false;
			}
			noteText.setText("Note: " + "Go from " + deletedVertex.peek().getIdOfVertex() + " to " + temp.getIdOfVertex());
			resText.setText(resText.getText() + " " + temp.getIdOfVertex());
			line.setColor();
			temp.changeColor();
			deletedVertex.push(temp);
			isVisited.put(temp, true);
			List<Vertex> adj = getGraph().getAdj().get(temp);
			boolean check = false;
			for(int i = 0; i < adj.size(); i++) {
				Vertex tempVertext = adj.get(i);
				if(isVisited.getOrDefault(tempVertext, false)) {
					continue;
				}
				check = true;
				listVertex.push(tempVertext);
			}
			if(check == false) {
				deletedVertex.pop().getIdOfVertex();
				while(check == false) {
					Vertex abc = deletedVertex.peek();
					List<Vertex> adj1 = getGraph().getAdj().get(abc);
					for(int i = 0; i < adj1.size(); i++) {
						Vertex tempVertext = adj1.get(i);
						if(isVisited.getOrDefault(tempVertext, false)) {
							continue;
						}
						check = true;
					}
					if(adj1.size() <= 0) {
						check = true;
					}
					if(check == false && deletedVertex.size() > 0) {
						deletedVertex.pop();
					}
					if(deletedVertex.size() <= 0){
						check = true;
					}
				}
			}
			return true;
		}
		return false;
	}

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
	
//	@Override
//	public void execute(Vertex startPoint, HashMap<Pair<Integer, Integer>, Line> listEdge) {
//		isVisited.put(startPoint, true);
//		List<Vertex> adj = getGraph().getAdj().get(startPoint);
//		for(int i = 0; i < adj.size(); i++) {
//			Vertex tempVertext = adj.get(i);
//			if(isVisited.getOrDefault(tempVertext, false)) {
//				continue;
//			}
//			Line temp = listEdge.get(new Pair(startPoint.getIdOfVertex(), tempVertext.getIdOfVertex()));
//			temp.setStroke(Color.RED);
//			
//			temp.setStroke(Color.BLACK);
//			System.out.println("Go from " + startPoint.getIdOfVertex() + " to " + tempVertext.getIdOfVertex());
//			execute(tempVertext, listEdge);
//		}
//	}
}