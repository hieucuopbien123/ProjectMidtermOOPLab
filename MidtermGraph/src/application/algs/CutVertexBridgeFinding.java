package application.algs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import application.components.graph.*;
import javafx.scene.control.Label;
import javafx.util.Pair;

public class CutVertexBridgeFinding extends Algorithm {
	private HashMap<Pair<Integer, Integer>, Edge> listEdge;
	public CutVertexBridgeFinding(Graph graph, List<Label> pseudoStep, Label comment, Label note, HashMap<Pair<Integer, Integer>, Edge> listEdge) {
		super(graph, pseudoStep, comment, note);
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
			step.addPseudoStep(0);
			step.addNote("Check the vertex " + temp.getIdOfVertex());
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			if(a == -1) {
				childNum.put(temp, 0);
				dfs_child = 0;
				step.addPseudoStep(0);
				step.addNote("Because we haven't traversed " + temp.getIdOfVertex() + " before, so we run the recursive");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				findBridgeAndArt(temp, null, temp);
				step.addPseudoStep(5);
				step.addNote("Check the vertex " + temp.getIdOfVertex());
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				if(art.getOrDefault(temp, false) == false && dfs_child > 1) {
					step.addPseudoStep(5);
					step.addNote("Because art[v] == false && dfs_child > 1, so v=" + temp.getIdOfVertex() + " is an articulation point");
					step.addEdge(null);
					step.addVertex(temp);
					step.addRes("  " + temp.getIdOfVertex());
					//Systemout.println(temp.getIdOfVertex() + " is an artpoint");
					continue;
				}
				step.addPseudoStep(5);
				step.addNote("Because !(art[v] == false && dfs_child > 1), so the vertex " + temp.getIdOfVertex() + " may be not a cut vertex");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				continue;
			}
			step.addPseudoStep(0);
			step.addNote("We have visited " + temp.getIdOfVertex() + " before, so we continue the next loop round");
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
		}
		
	}
	
	private void findBridgeAndArt(Vertex u, Vertex p, Vertex dfs_root) {
		int temp = curnum++;
		low.put(u, temp);
		num.put(u, temp);
		step.addPseudoStep(1);
		step.addNote("Build low and num array at " + u.getIdOfVertex());
		step.addEdge(null);
		step.addVertex(null);
		step.addRes(null);
		List<Vertex> adj = getGraph().getAdj().get(u);
		//Systemout.println(u.getIdOfVertex());
		for(int i = 0; i < adj.size(); i++) {
			Vertex tempVertex = adj.get(i);
			step.addPseudoStep(2);
			step.addNote("We traverse all vertex adjacent to " + u.getIdOfVertex());
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			
			step.addPseudoStep(3);
			step.addNote("Check whether it have traversed. Check the vertex " + tempVertex.getIdOfVertex());
			step.addEdge(null);
			step.addVertex(null);
			step.addRes(null);
			
			if(num.getOrDefault(tempVertex, -1) == -1) {
				if(u.getIdOfVertex() == dfs_root.getIdOfVertex()) {
					dfs_child++;
				}
				step.addPseudoStep(3);
				step.addNote(tempVertex.getIdOfVertex() + " haven't visited yet, so we visit it");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				findBridgeAndArt(tempVertex, u, dfs_root);
				step.addPseudoStep(4);
				step.addNote("Update low of " + u.getIdOfVertex());
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				if(low.get(tempVertex) >= num.get(u) && art.getOrDefault(u, false) == false && p != null) {
					art.put(u, true);
					//Systemout.println(u.getIdOfVertex() + " is an artpoint");
					step.addPseudoStep(5);
					step.addNote("Check low[v] >= num[u] && p != -1 && art[u] == false => " + u.getIdOfVertex() + " is an articulation point");
					step.addEdge(null);
					step.addVertex(u);
					step.addRes("  " + u.getIdOfVertex());
				}
				low.put(u, Math.min(low.get(u), low.get(tempVertex)));
			} else if(p != null && tempVertex.getIdOfVertex() != p.getIdOfVertex()) {
				step.addPseudoStep(6);
				step.addNote("We've traversed " + tempVertex.getIdOfVertex() + " before so we update low[" + u.getIdOfVertex() + "]");
				step.addEdge(null);
				step.addVertex(null);
				step.addRes(null);
				low.put(u, Math.min(low.get(u), num.get(tempVertex)));
			}
			if(low.get(tempVertex) > num.get(u)) {
				step.addPseudoStep(5);
				step.addNote("We check low[" + tempVertex.getIdOfVertex() + "] > num[" + u.getIdOfVertex() + "]" + ", so " + tempVertex.getIdOfVertex() + " ---- " + u.getIdOfVertex() + " is a bridge");
				Edge line = listEdge.get(new Pair(tempVertex.getIdOfVertex(), u.getIdOfVertex()));
				if(line == null && !getGraph().getIsDirected()) {
					line = listEdge.get(new Pair(u.getIdOfVertex(), tempVertex.getIdOfVertex()));
				}else if(line == null) {
					return;
				}
				step.addEdge(line);
				step.addVertex(null);
				step.addRes("  " + tempVertex.getIdOfVertex() + " ---- " + u.getIdOfVertex());
				//Systemout.println(u.getIdOfVertex() + " -- " + tempVertex.getIdOfVertex() +  " is a bridge");
			}
		}
	}
	
}
