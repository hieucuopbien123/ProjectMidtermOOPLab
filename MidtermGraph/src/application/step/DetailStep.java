package application.step;

import java.util.LinkedList;
import java.util.Queue;

import application.components.graph.Edge;
import application.components.graph.Vertex;

import javafx.scene.control.Label;

public class DetailStep {
	private Queue<Vertex> qVertex = new LinkedList<Vertex>();
	private Queue<Edge> qEdge = new LinkedList<Edge>();
	private Queue<String> qCom = new LinkedList<String>();
	private Label comment;
	private Queue<String> qNote = new LinkedList<String>();
	private Label note;
	
	public DetailStep(Label comment, Label note) {
		this.comment = comment;
		this.note = note;
	}
	
	public void addEdge(Edge e) {
		qEdge.offer(e);
	}
	public void addVertex(Vertex v) {
		qVertex.offer(v);
	}
	public void runNextStep() {
		Vertex v;
		Edge e;
		String com;
		String noteT;
		if((v = qVertex.poll()) != null)
			v.changeColor();
		if((e = qEdge.poll()) != null)
			e.setColor();
		if((com = qCom.poll()) != null)
			comment.setText(comment.getText() + com);
		if((noteT = qNote.poll()) != null)
			note.setText("Note: " + noteT);
	}
	public void addRes(String a) {
		qCom.offer(a);
	}
	public void addNote(String a) {
		qNote.offer(a);
	}
}
