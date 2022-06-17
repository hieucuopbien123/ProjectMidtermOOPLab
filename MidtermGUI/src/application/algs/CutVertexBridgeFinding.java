package application.algs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import application.components.edge.Edge;
import application.components.graph.*;
import application.components.vertext.*;
import javafx.scene.control.Label;
import javafx.util.Pair;

public class CutVertexBridgeFinding extends Algorithm {
	public CutVertexBridgeFinding(Graph graph) {
		super(graph);
	}
	private HashMap<Vertex, Integer> num;
	private HashMap<Vertex, Integer> childNum;
	private HashMap<Vertex, Integer> low;
	private int curnum;
	
	private Stack<Vertex> stackVertex;
	private List<Vertex> outerLoop;
	private Vertex currentVertex = null;
	private HashMap<Vertex, Boolean> isVisited;
	private HashMap<Vertex, Boolean> art;
	public boolean runNextStep(HashMap<Pair<Integer, Integer>, Edge> listEdge, Label noteText, Label resText) {
		if(curnum == outerLoop.size()) {
			return false;
		}
		if(stackVertex.isEmpty()) {
			while(isVisited.getOrDefault(outerLoop.get(curnum), false)) {
				++curnum;
				if(curnum == outerLoop.size()) {
					return false;
				}
			}
			System.out.println(curnum);
			currentVertex = outerLoop.get(curnum);
			System.out.println("OK: "+ currentVertex.getIdOfVertex());
			if(art.getOrDefault(currentVertex, false) == false && childNum.getOrDefault(currentVertex, 0) > 1) {
				//temp la art point
				currentVertex.changeColor();
				System.out.println("CCCCC: " + currentVertex.getIdOfVertex());
				noteText.setText("Note: " + currentVertex.getIdOfVertex() + " is a cut vertex");
				resText.setText(resText.getText() + "  " + currentVertex.getIdOfVertex());
				stackVertex.push(currentVertex);
				art.put(currentVertex, true);
				return true;
			}
			stackVertex.push(currentVertex);
			System.out.println("CHeck");
			noteText.setText("Note: Traverse from new vertext " + currentVertex.getIdOfVertex());
		}
		if(!stackVertex.isEmpty()) {
			Vertex temp1 = stackVertex.pop();
			isVisited.put(temp1, true);
			List<Vertex> adj = getGraph().getAdj().get(temp1);
			noteText.setText("Note: Traverse from new vertext " + temp1.getIdOfVertex() + " having no child that haven't been visited");
			System.out.println("Parent: " + temp1.getIdOfVertex());
			for(int i = 0; i < adj.size(); i++) {
				Vertex tempVertex = adj.get(i);
				System.out.println("Child: " + tempVertex.getIdOfVertex());
				if(isVisited.getOrDefault(tempVertex, false)) {
					continue;
				}
				stackVertex.push(tempVertex);
				System.out.println("Check bridge");
				noteText.setText("Note: Traverse from vertext " + temp1.getIdOfVertex() + " to " + tempVertex.getIdOfVertex());
				String text = "Note: ";
				if(low.get(tempVertex) > num.get(temp1)) {
					//bridge
					Edge line = listEdge.get(new Pair(temp1.getIdOfVertex(), tempVertex.getIdOfVertex()));
					if(line == null && !getGraph().getIsDirected()) {
						line = listEdge.get(new Pair(tempVertex.getIdOfVertex(), temp1.getIdOfVertex()));
					}else if(line == null) {
						return true;
					}
					line.setColor();
					System.out.println("CCCCC: " + tempVertex.getIdOfVertex() + " - " + temp1.getIdOfVertex());
					text += "The edge " + tempVertex.getIdOfVertex() + " -- " + temp1.getIdOfVertex() + " is a bridge";
					resText.setText(resText.getText() + "  " + tempVertex.getIdOfVertex() + "--" + temp1.getIdOfVertex());
//					noteText.setText("Note: The edge " + tempVertex.getIdOfVertex() + " -- " + temp1.getIdOfVertex() + " is a bridge");
				}
				System.out.println("Check art point");
				if(low.get(tempVertex) >= num.get(temp1) && art.getOrDefault(temp1, false) == false 
				&& temp1.getIdOfVertex() != currentVertex.getIdOfVertex()) {
					art.put(temp1, true);
					System.out.println("CCCCC: " + temp1.getIdOfVertex());
					text += "; "+ temp1.getIdOfVertex() + " is a cut vertex";
//					noteText.setText("Note: " + temp1.getIdOfVertex() + " is a cut vertex");
					//art point mới
					resText.setText(resText.getText() + "  " + temp1.getIdOfVertex());
					temp1.changeColor();
				}
				if(text != "Note: ")
					noteText.setText(text);
			}
			if(stackVertex.isEmpty()) {
				curnum++;
			}
		}
		return true;
	}

	@Override
	public void setup() {
		num = new HashMap<Vertex, Integer>();
		childNum = new HashMap<Vertex, Integer>();
		isVisited = new HashMap<Vertex, Boolean>();
		art = new HashMap<Vertex, Boolean>();
		curnum = 0;
		stackVertex = new Stack<Vertex>();
		low = new HashMap<Vertex, Integer>();
		System.out.println("Test1");
		outerLoop = new ArrayList<Vertex>(getGraph().getAdj().keySet());
		System.out.println("Test2");
		for(int i = 0; i < outerLoop.size(); i++) {
			Vertex temp = outerLoop.get(i);
			Integer a = num.getOrDefault(temp, -1);
			if(a == -1) {
				childNum.put(temp, 0);
				findBridgeAndArt(temp, null, temp);
			}
		}
		System.out.println("Test");
		curnum = 0;
		System.out.println(outerLoop.get(0).getIdOfVertex());
		System.out.println(outerLoop.get(1).getIdOfVertex());
		System.out.println(outerLoop.get(2).getIdOfVertex());
		System.out.println(low.get(outerLoop.get(0)));
		System.out.println(low.get(outerLoop.get(1)));
		System.out.println(low.get(outerLoop.get(2)));
		System.out.println(num.get(outerLoop.get(0)));
		System.out.println(num.get(outerLoop.get(1)));
		System.out.println(num.get(outerLoop.get(2)));
	}
	
	private void findBridgeAndArt(Vertex u, Vertex p, Vertex dfs_root) {
		int temp = curnum++;
		low.put(u, temp);
		num.put(u, temp);
		List<Vertex> adj = getGraph().getAdj().get(u);
		System.out.println(u.getIdOfVertex());
		for(int i = 0; i < adj.size(); i++) {
			Vertex tempVertex = adj.get(i);
			if(num.getOrDefault(tempVertex, -1) == -1) {
				if(u.getIdOfVertex() == dfs_root.getIdOfVertex()) {
					childNum.put(u, childNum.getOrDefault(u, 0) + 1);
				}
				findBridgeAndArt(tempVertex, u, dfs_root);
				low.put(u, Math.min(low.get(u), low.get(tempVertex)));
			} else if(p != null && tempVertex.getIdOfVertex() != p.getIdOfVertex()) {
				low.put(u, Math.min(low.get(u), num.get(tempVertex)));
			}
		}
	}
	
}