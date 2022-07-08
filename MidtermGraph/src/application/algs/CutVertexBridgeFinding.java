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
	private HashMap<Pair<Integer, Integer>, Edge> listEdge;
	public CutVertexBridgeFinding(Graph graph, Label pseudoStep, Label l, Label note, HashMap<Pair<Integer, Integer>, Edge> listEdge) {
		super(graph, pseudoStep, l, note);
		this.listEdge = listEdge;
	}
	private HashMap<Vertex, Integer> num = new HashMap<Vertex, Integer>();;
	private HashMap<Vertex, Integer> childNum = new HashMap<Vertex, Integer>();
	private HashMap<Vertex, Integer> low = new HashMap<Vertex, Integer>();
	private int curnum = 0;
	
	private List<Vertex> outerLoop = new ArrayList<Vertex>(getGraph().getAdj().keySet());
	private HashMap<Vertex, Boolean> art  = new HashMap<Vertex, Boolean>();
	
	private int dfs_child = 0;
	@Override
	public void buildStep() {
		for(int i = 0; i < outerLoop.size(); i++) {
			Vertex temp = outerLoop.get(i);
			Integer a = num.getOrDefault(temp, -1);
			step.addPseudoStep("for each vertex v in the graph G\r\n"
					+ "			if !isVisited(v)\r\n");
			step.addNote("Check the vertex " + temp.getIdOfVertex());
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			if(a == -1) {
				childNum.put(temp, 0);
				dfs_child = 0;
				step.addPseudoStep("for each vertex v in the graph G\r\n"
						+ "			if !isVisited(v)\r\n"
						+ "				runAlgorithm(u, -1)");
				step.addNote("Because we haven't traversed " + temp.getIdOfVertex() + " before, so we run the recursive");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				findBridgeAndArt(temp, null, temp, listEdge);
				step.addPseudoStep("	if art[v] == false && dfs_child > 1)\r\n");
				step.addNote("Check the vertex " + temp.getIdOfVertex());
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				if(art.getOrDefault(temp, false) == false && dfs_child > 1) {
					step.addPseudoStep("	if art[v] == false && dfs_child > 1\r\n"
							+ "				v must be an articulation point\r\n");
					step.addNote("Satisfy, so " + temp.getIdOfVertex() + " is an articulation point");
					step.addEdge(null);
					step.addVertex(temp);
					step.addRes("  " + temp.getIdOfVertex());
					System.out.println(temp.getIdOfVertex() + " is an artpoint");
					continue;
				}
				step.addPseudoStep("	if !(art[v] == false && dfs_child > 1)\r\n"
						+ "					v is not an articulation point");
				step.addNote("The vertex " + temp.getIdOfVertex() + " is not an articulation point");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				continue;
			}
			step.addPseudoStep("for each vertex v in the graph G\r\n"
					+ "			if isVisited(v)\r\n"
					+ "				continue;");
			step.addNote("We have visited " + temp.getIdOfVertex() + " before, so we continue the next loop round");
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
		}
		
	}
	
	private void findBridgeAndArt(Vertex u, Vertex p, Vertex dfs_root, HashMap<Pair<Integer, Integer>, Edge> listEdge) {
		int temp = curnum++;
		low.put(u, temp);
		num.put(u, temp);
		step.addPseudoStep("low[u] = num[u] = curnum++;");
		step.addNote("Build low and num array at " + u.getIdOfVertex());
		step.addEdge(null);
		step.addVertex(null);
		step.addRes(null);
		List<Vertex> adj = getGraph().getAdj().get(u);
		System.out.println(u.getIdOfVertex());
		for(int i = 0; i < adj.size(); i++) {
			Vertex tempVertex = adj.get(i);
			step.addPseudoStep("for each element t adjacent to u\r\n"
					+ "			if isVisited[t]");
			step.addNote("We traverse all vertex adjacent to " 
					+ u.getIdOfVertex() + " and check whether it have traversed. Check the vertex" + tempVertex.getIdOfVertex());
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			
			if(num.getOrDefault(tempVertex, -1) == -1) {
				if(u.getIdOfVertex() == dfs_root.getIdOfVertex()) {
					step.addPseudoStep("for each element t adjacent to u\r\n"
							+ "			if !isVisited[t]\r\n"
							+ "				if u == dfs_root\r\n"
							+ "					dfs_child++\r\n");
					step.addNote("Satisfy, so we increase dfs_child by 1");
					step.addEdge(null);
					step.addVertex(null);
					step.addRes(null);
					dfs_child++;
				}
				step.addPseudoStep("for each element t adjacent to u\r\n"
						+ "			if !isVisited[t]\r\n"
						+ "				if u == dfs_root\"\r\n"
						+ "					dfs_child++\r\n"
						+ "				runAlgorithm(t, u);");
				step.addNote(tempVertex.getIdOfVertex() + " haven't visited yet, so we visit it");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				findBridgeAndArt(tempVertex, u, dfs_root, listEdge);
				if(low.get(tempVertex) >= num.get(u) && art.getOrDefault(u, false) == false && p != null) {
					art.put(u, true);
					System.out.println(u.getIdOfVertex() + " is an artpoint");
					step.addPseudoStep("if low[v] >= num[u] && p != -1 && art[u] == false\r\n"
							+ "                art[u] = true;\r\n"
							+ "				   u is an articulation point\r\n");
					step.addNote(u.getIdOfVertex() + " is an articulation point");
					step.addEdge(null);
					step.addVertex(u);
					step.addRes("  " + u.getIdOfVertex());
					//u là 1 art
				}
				low.put(u, Math.min(low.get(u), low.get(tempVertex)));
				step.addPseudoStep("low[u] = min(low[u], low[v]);");
				step.addNote("Update low of " + u.getIdOfVertex());
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
			} else if(p != null && tempVertex.getIdOfVertex() != p.getIdOfVertex()) {
				step.addPseudoStep("for each element t adjacent to u\r\n"
						+ "			if !isVisited[t] and t != parent\r\n"
						+ "				update low[u] = min(low[u], num[v]);");
				step.addNote("We've traversed " + tempVertex.getIdOfVertex() + " before so we update low[" + u.getIdOfVertex() + "]");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				low.put(u, Math.min(low.get(u), num.get(tempVertex)));
			}
			step.addPseudoStep("if low[v] > num[u]\r\n");
			step.addNote("We check if low[" + tempVertex.getIdOfVertex() + "] > num[" + u.getIdOfVertex() + "]");
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			if(low.get(tempVertex) > num.get(u)) {
				//u --- v là  1 bridge
				step.addPseudoStep("if low[v] > num[u]\r\n"
						+ "			u -- v is a bridge");
				step.addNote(tempVertex.getIdOfVertex() + " ---- " + u.getIdOfVertex() + " is a bridge");
				Edge line = listEdge.get(new Pair(tempVertex.getIdOfVertex(), u.getIdOfVertex()));
				if(line == null && !getGraph().getIsDirected()) {
					line = listEdge.get(new Pair(u.getIdOfVertex(), tempVertex.getIdOfVertex()));
				}else if(line == null) {
					return;
				}
				step.addEdge(line);
				step.addVertex(null);
				step.addRes("  " + tempVertex.getIdOfVertex() + " ---- " + u.getIdOfVertex());
				System.out.println(u.getIdOfVertex() + " -- " + tempVertex.getIdOfVertex() +  " is a bridge");
			}
		}
	}
	
}
