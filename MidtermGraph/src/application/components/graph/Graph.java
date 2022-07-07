package application.components.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.components.vertext.Vertex;
import application.components.vertext.VertexController;

public class Graph {
	private HashMap<Vertex, List<Vertex>> adj = new HashMap<Vertex, List<Vertex>>();
	private boolean isDirected = false;
	public Graph() {
		super();
	}
	public Graph(boolean isDirected) {
		super();
		this.isDirected = isDirected;
		VertexController.resetId();
	}
	public boolean getIsDirected() {
		return isDirected;
	}
	public HashMap<Vertex, List<Vertex>> getAdj() {
		return adj;
	}
	public boolean containsEdge(Vertex from, Vertex to) {
		for (Vertex key : adj.keySet()) {
		    if(key == from) {
		    	for(Vertex temp: adj.get(key)) {
		    		if(temp == to) {
		    			return true;
		    		}
		    	}
		    }else if(key == to) {
		    	for(Vertex temp: adj.get(key)) {
		    		if(temp == from) {
		    			return true;
		    		}
		    	}
		    }
		}
		return false;
	}
	public Vertex getVertext(int id) {
		for (Vertex key : adj.keySet()) {
		    if(key.getIdOfVertex() == id) 
		    	return key;
		}
		return null;
	}
	public void addVertext(Vertex vertex) {
		if(adj.containsKey(vertex)) {
			System.out.println("This vertext has already been added to the graph");
		} else {
			adj.put(vertex, new ArrayList<Vertex>());
			System.out.println("Add successfully vertext " + vertex.getIdOfVertex());
		}
	}
	public void deleteVertext(int id) {
		Vertex v = getVertext(id);
		deleteVertext(v);
	}
	public void deleteVertext(Vertex v) {
		if(v != null) {
			for (Vertex key : adj.keySet()) {
				adj.get(key).remove(v);
			}
			adj.remove(v);
			System.out.println("Remove successfully vertext " + v.getIdOfVertex());
			VertexController.addToDeletedStack(v.getIdOfVertex());
			return;
		}
		System.out.println("This vertext is not exist");
	}
	public void addEdge(int from, int to) {
		Vertex fromVertext = getVertext(from);
		Vertex toVertext = getVertext(to);
		if(adj.containsKey(fromVertext)) {
			if(adj.get(fromVertext).contains(toVertext)) {
				System.out.println("This edge has already been added to the graph");
			}
			adj.get(fromVertext).add(toVertext);
		} else {
	        List<Vertex> tempVertextList = new ArrayList<Vertex>();
	        tempVertextList.add(toVertext);
        	adj.put(fromVertext, tempVertextList);
		}
		if(!isDirected) {
			if(adj.containsKey(toVertext)) {
				adj.get(toVertext).add(fromVertext);
			} else {
		        List<Vertex> tempVertextList = new ArrayList<Vertex>();
		        tempVertextList.add(fromVertext);
	        	adj.put(toVertext, tempVertextList);
			}
		}
    	System.out.println("Add edge successfully edge " + from + " --" + to);
	}
	public void addEdge(Vertex fromVertext, Vertex toVertext) {
		if(adj.containsKey(fromVertext)) {
			if(adj.get(fromVertext).contains(toVertext)) {
				System.out.println("This edge has already been added to the graph");
			}
			adj.get(fromVertext).add(toVertext);
		} else {
	        List<Vertex> tempVertextList = new ArrayList<Vertex>();
	        tempVertextList.add(toVertext);
        	adj.put(fromVertext, tempVertextList);
		}
		if(!isDirected) {
			if(adj.containsKey(toVertext)) {
				adj.get(toVertext).add(fromVertext);
			} else {
		        List<Vertex> tempVertextList = new ArrayList<Vertex>();
		        tempVertextList.add(fromVertext);
	        	adj.put(toVertext, tempVertextList);
			}
		}
    	System.out.println("Add edge successfully edge " + fromVertext.getIdOfVertex() + " -- " + toVertext.getIdOfVertex());
	}
	public void deleteEdge(int from, int to) {
		Vertex fromVertext = getVertext(from);
		Vertex toVertext = getVertext(to);
		if(fromVertext == null || toVertext == null) {
			System.out.println("This edge not exists");
			return;
		}
		adj.get(fromVertext).remove(toVertext);
		System.out.println("Remove successfully edge " + to + " --- " + from);
		if(!isDirected) {
			adj.get(toVertext).remove(fromVertext);
			System.out.println("Remove successfully edge " + from + " --- " + to);
		}
	}
}
