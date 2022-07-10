package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import application.context.Context;
import application.algs.Algorithm;
import application.algs.CutVertexBridgeFinding;
import application.algs.DFS;
import application.algs.TopologicalSort;
import application.components.graph.Edge;
import application.components.graph.Graph;
import application.components.graph.Vertex;
import application.components.graph.VertexController;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.css.Size;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.util.Pair;

public class SceneController implements Initializable {
	private Timeline timeline;
	@FXML
	private Button autoRunButton;
	@FXML
	private AnchorPane myCanvas;
	@FXML
	private TextField DFSParam;
	@FXML 
	private TextField from;
	@FXML
	private TextField to;
	@FXML
	private Button nextStepButton;
	@FXML 
	private Label noteText;
	@FXML
	private Label resText;
	@FXML
	private Button createUGraph;
	@FXML
	private Button createDGraph;
	@FXML
	private Button removeE;
	@FXML
	private Button DFSButton;
	@FXML
	private Button RunC;
	@FXML
	private Button RunT;
	@FXML
	private VBox pseudoBox;
	@FXML
	private Button GenDGraph;
	@FXML
	private Button GenUGraph;
	
	private Context context;
    private List<Label> lines;
	private int mode = 0;
	
	private Graph graph;
	private HashMap<Pair<Integer, Integer>, Edge> listEdge = new HashMap<Pair<Integer, Integer>, Edge>();
	
	public void generateUndirectedGraph() {
		reset();
		createNewGraph();
		Vertex vertex1 = new Vertex();
		vertex1.setLayoutX(478 - 18);
		vertex1.setLayoutY(44 - 18);
		FadeTransition fade1 = new FadeTransition();
		fade1.setNode(vertex1);
		fade1.setDuration(Duration.millis(200));
		fade1.setCycleCount(1);
		fade1.setInterpolator(Interpolator.LINEAR);
		fade1.setFromValue(0);
		fade1.setToValue(1);
		fade1.play();
        myCanvas.getChildren().add(vertex1);
        graph.addVertext(vertex1);
        
        Vertex vertex2 = new Vertex();
        vertex2.setLayoutX(349 - 18);
        vertex2.setLayoutY(148 - 18);
		FadeTransition fade2 = new FadeTransition();
		fade2.setNode(vertex2);
		fade2.setDuration(Duration.millis(200));
		fade2.setCycleCount(1);
		fade2.setInterpolator(Interpolator.LINEAR);
		fade2.setFromValue(0);
		fade2.setToValue(1);
		fade2.play();
        myCanvas.getChildren().add(vertex2);
        graph.addVertext(vertex2);
        
        Vertex vertex3 = new Vertex();
        vertex3.setLayoutX(462 - 18);
        vertex3.setLayoutY(146 - 18);
		FadeTransition fade3 = new FadeTransition();
		fade3.setNode(vertex3);
		fade3.setDuration(Duration.millis(200));
		fade3.setCycleCount(1);
		fade3.setInterpolator(Interpolator.LINEAR);
		fade3.setFromValue(0);
		fade3.setToValue(1);
		fade3.play();
        myCanvas.getChildren().add(vertex3);
        graph.addVertext(vertex3);
        
        Vertex vertex4 = new Vertex();
        vertex4.setLayoutX(579 - 18);
        vertex4.setLayoutY(142 - 18);
		FadeTransition fade4 = new FadeTransition();
		fade4.setNode(vertex4);
		fade4.setDuration(Duration.millis(200));
		fade4.setCycleCount(1);
		fade4.setInterpolator(Interpolator.LINEAR);
		fade4.setFromValue(0);
		fade4.setToValue(1);
		fade4.play();
        myCanvas.getChildren().add(vertex4);
        graph.addVertext(vertex4);
        
        Vertex vertex5 = new Vertex();
        vertex5.setLayoutX(702 - 18);
        vertex5.setLayoutY(139 - 18);
		FadeTransition fade5 = new FadeTransition();
		fade5.setNode(vertex5);
		fade5.setDuration(Duration.millis(200));
		fade5.setCycleCount(1);
		fade5.setInterpolator(Interpolator.LINEAR);
		fade5.setFromValue(0);
		fade5.setToValue(1);
		fade5.play();
        myCanvas.getChildren().add(vertex5);
        graph.addVertext(vertex5);
        
        Vertex vertex6 = new Vertex();
        vertex6.setLayoutX(278 - 18);
        vertex6.setLayoutY(221 - 18);
		FadeTransition fade6 = new FadeTransition();
		fade6.setNode(vertex6);
		fade6.setDuration(Duration.millis(200));
		fade6.setCycleCount(1);
		fade6.setInterpolator(Interpolator.LINEAR);
		fade6.setFromValue(0);
		fade6.setToValue(1);
		fade6.play();
        myCanvas.getChildren().add(vertex6);
        graph.addVertext(vertex6);
        
        Vertex vertex7 = new Vertex();
        vertex7.setLayoutX(385 - 18);
        vertex7.setLayoutY(219 - 18);
		FadeTransition fade7 = new FadeTransition();
		fade7.setNode(vertex7);
		fade7.setDuration(Duration.millis(200));
		fade7.setCycleCount(1);
		fade7.setInterpolator(Interpolator.LINEAR);
		fade7.setFromValue(0);
		fade7.setToValue(1);
		fade7.play();
        myCanvas.getChildren().add(vertex7);
        graph.addVertext(vertex7);
        
        Vertex vertex8 = new Vertex();
        vertex8.setLayoutX(562 - 18);
        vertex8.setLayoutY(233 - 18);
		FadeTransition fade8 = new FadeTransition();
		fade8.setNode(vertex8);
		fade8.setDuration(Duration.millis(200));
		fade8.setCycleCount(1);
		fade8.setInterpolator(Interpolator.LINEAR);
		fade8.setFromValue(0);
		fade8.setToValue(1);
		fade8.play();
        myCanvas.getChildren().add(vertex8);
        graph.addVertext(vertex8);
        
        Vertex vertex9 = new Vertex();
        vertex9.setLayoutX(516 - 18);
        vertex9.setLayoutY(289 - 18);
		FadeTransition fade9 = new FadeTransition();
		fade9.setNode(vertex9);
		fade9.setDuration(Duration.millis(200));
		fade9.setCycleCount(1);
		fade9.setInterpolator(Interpolator.LINEAR);
		fade9.setFromValue(0);
		fade9.setToValue(1);
		fade9.play();
        myCanvas.getChildren().add(vertex9);
        graph.addVertext(vertex9);
        
        graph.addEdge(vertex1, vertex2);
		Edge edge = new Edge(graph.getIsDirected());
		edge.setStartX(463.98685313876086);
		edge.setStartY(55.29742072534003);
		edge.setEndX(363.01314686123914);
		edge.setEndY(136.7025792746599);
		Pair tempPair = new Pair(vertex1.getIdOfVertex(), vertex2.getIdOfVertex());
		listEdge.put(tempPair, edge);
        myCanvas.getChildren().add(edge);
        
        graph.addEdge(vertex1, vertex3);
		Edge edge2 = new Edge(graph.getIsDirected());
		double a = vertex1.getLayoutX() + 18;
		double b = vertex1.getLayoutY() + 18;
		double c = vertex3.getLayoutX() + 18;
		double d = vertex3.getLayoutY() + 18;
		double dx = Math.hypot(a - c, d - b);
		double tempX = c - a;
		double alpha = Math.acos(tempX/dx);
		double tempA = a + 18*Math.cos(alpha);
		double tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		double tempC = c + 18*Math.cos(Math.PI - alpha);
		double tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge2.setStartX(tempA);
		edge2.setStartY(tempB);
		edge2.setEndX(tempC);
		edge2.setEndY(tempD);
//		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair2 = new Pair(vertex1.getIdOfVertex(), vertex3.getIdOfVertex());
		listEdge.put(tempPair2, edge2);
        myCanvas.getChildren().add(edge2);
        
        graph.addEdge(vertex1, vertex4);
		Edge edge3 = new Edge(graph.getIsDirected());
		a = vertex1.getLayoutX() + 18;
		b = vertex1.getLayoutY() + 18;
		c = vertex4.getLayoutX() + 18;
		d = vertex4.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge3.setStartX(tempA);
		edge3.setStartY(tempB);
		edge3.setEndX(tempC);
		edge3.setEndY(tempD);
//		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair3 = new Pair(vertex1.getIdOfVertex(), vertex4.getIdOfVertex());
		listEdge.put(tempPair3, edge3);
        myCanvas.getChildren().add(edge3);
        
        graph.addEdge(vertex1, vertex5);
		Edge edge4 = new Edge(graph.getIsDirected());
		a = vertex1.getLayoutX() + 18;
		b = vertex1.getLayoutY() + 18;
		c = vertex5.getLayoutX() + 18;
		d = vertex5.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge4.setStartX(tempA);
		edge4.setStartY(tempB);
		edge4.setEndX(tempC);
		edge4.setEndY(tempD);
//		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair4 = new Pair(vertex1.getIdOfVertex(), vertex5.getIdOfVertex());
		listEdge.put(tempPair4, edge4);
        myCanvas.getChildren().add(edge4);
        
        graph.addEdge(vertex2, vertex6);
		Edge edge5 = new Edge(graph.getIsDirected());
		a = vertex2.getLayoutX() + 18;
		b = vertex2.getLayoutY() + 18;
		c = vertex6.getLayoutX() + 18;
		d = vertex6.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge5.setStartX(tempA);
		edge5.setStartY(tempB);
		edge5.setEndX(tempC);
		edge5.setEndY(tempD);
//		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair5 = new Pair(vertex2.getIdOfVertex(), vertex6.getIdOfVertex());
		listEdge.put(tempPair5, edge5);
        myCanvas.getChildren().add(edge5);
        
        graph.addEdge(vertex2, vertex7);
		Edge edge6 = new Edge(graph.getIsDirected());
		a = vertex2.getLayoutX() + 18;
		b = vertex2.getLayoutY() + 18;
		c = vertex7.getLayoutX() + 18;
		d = vertex7.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge6.setStartX(tempA);
		edge6.setStartY(tempB);
		edge6.setEndX(tempC);
		edge6.setEndY(tempD);
		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair6 = new Pair(vertex2.getIdOfVertex(), vertex7.getIdOfVertex());
		listEdge.put(tempPair6, edge6);
        myCanvas.getChildren().add(edge6);
        
        graph.addEdge(vertex3, vertex8);
		Edge edge7 = new Edge(graph.getIsDirected());
		a = vertex3.getLayoutX() + 18;
		b = vertex3.getLayoutY() + 18;
		c = vertex8.getLayoutX() + 18;
		d = vertex8.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge7.setStartX(tempA);
		edge7.setStartY(tempB);
		edge7.setEndX(tempC);
		edge7.setEndY(tempD);
		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair7 = new Pair(vertex3.getIdOfVertex(), vertex8.getIdOfVertex());
		listEdge.put(tempPair7, edge7);
        myCanvas.getChildren().add(edge7);
        
        graph.addEdge(vertex4, vertex8);
		Edge edge8 = new Edge(graph.getIsDirected());
		a = vertex4.getLayoutX() + 18;
		b = vertex4.getLayoutY() + 18;
		c = vertex8.getLayoutX() + 18;
		d = vertex8.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge8.setStartX(tempA);
		edge8.setStartY(tempB);
		edge8.setEndX(tempC);
		edge8.setEndY(tempD);
		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair8 = new Pair(vertex4.getIdOfVertex(), vertex8.getIdOfVertex());
		listEdge.put(tempPair8, edge8);
        myCanvas.getChildren().add(edge8);
        
        graph.addEdge(vertex8, vertex9);
		Edge edge9 = new Edge(graph.getIsDirected());
		a = vertex8.getLayoutX() + 18;
		b = vertex8.getLayoutY() + 18;
		c = vertex9.getLayoutX() + 18;
		d = vertex9.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge9.setStartX(tempA);
		edge9.setStartY(tempB);
		edge9.setEndX(tempC);
		edge9.setEndY(tempD);
		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair9 = new Pair(vertex8.getIdOfVertex(), vertex9.getIdOfVertex());
		listEdge.put(tempPair9, edge9);
        myCanvas.getChildren().add(edge9);
	}
	
	public void generateDirectedGraph() {
		reset();
		createNewDirectedGraph();
		Vertex vertex1 = new Vertex();
		vertex1.setLayoutX(478 - 18);
		vertex1.setLayoutY(44 - 18);
		FadeTransition fade1 = new FadeTransition();
		fade1.setNode(vertex1);
		fade1.setDuration(Duration.millis(200));
		fade1.setCycleCount(1);
		fade1.setInterpolator(Interpolator.LINEAR);
		fade1.setFromValue(0);
		fade1.setToValue(1);
		fade1.play();
        myCanvas.getChildren().add(vertex1);
        graph.addVertext(vertex1);
        
        Vertex vertex2 = new Vertex();
        vertex2.setLayoutX(349 - 18);
        vertex2.setLayoutY(148 - 18);
		FadeTransition fade2 = new FadeTransition();
		fade2.setNode(vertex2);
		fade2.setDuration(Duration.millis(200));
		fade2.setCycleCount(1);
		fade2.setInterpolator(Interpolator.LINEAR);
		fade2.setFromValue(0);
		fade2.setToValue(1);
		fade2.play();
        myCanvas.getChildren().add(vertex2);
        graph.addVertext(vertex2);
        
        Vertex vertex3 = new Vertex();
        vertex3.setLayoutX(462 - 18);
        vertex3.setLayoutY(146 - 18);
		FadeTransition fade3 = new FadeTransition();
		fade3.setNode(vertex3);
		fade3.setDuration(Duration.millis(200));
		fade3.setCycleCount(1);
		fade3.setInterpolator(Interpolator.LINEAR);
		fade3.setFromValue(0);
		fade3.setToValue(1);
		fade3.play();
        myCanvas.getChildren().add(vertex3);
        graph.addVertext(vertex3);
        
        Vertex vertex4 = new Vertex();
        vertex4.setLayoutX(579 - 18);
        vertex4.setLayoutY(142 - 18);
		FadeTransition fade4 = new FadeTransition();
		fade4.setNode(vertex4);
		fade4.setDuration(Duration.millis(200));
		fade4.setCycleCount(1);
		fade4.setInterpolator(Interpolator.LINEAR);
		fade4.setFromValue(0);
		fade4.setToValue(1);
		fade4.play();
        myCanvas.getChildren().add(vertex4);
        graph.addVertext(vertex4);
        
        Vertex vertex5 = new Vertex();
        vertex5.setLayoutX(702 - 18);
        vertex5.setLayoutY(139 - 18);
		FadeTransition fade5 = new FadeTransition();
		fade5.setNode(vertex5);
		fade5.setDuration(Duration.millis(200));
		fade5.setCycleCount(1);
		fade5.setInterpolator(Interpolator.LINEAR);
		fade5.setFromValue(0);
		fade5.setToValue(1);
		fade5.play();
        myCanvas.getChildren().add(vertex5);
        graph.addVertext(vertex5);
        
        Vertex vertex6 = new Vertex();
        vertex6.setLayoutX(278 - 18);
        vertex6.setLayoutY(221 - 18);
		FadeTransition fade6 = new FadeTransition();
		fade6.setNode(vertex6);
		fade6.setDuration(Duration.millis(200));
		fade6.setCycleCount(1);
		fade6.setInterpolator(Interpolator.LINEAR);
		fade6.setFromValue(0);
		fade6.setToValue(1);
		fade6.play();
        myCanvas.getChildren().add(vertex6);
        graph.addVertext(vertex6);
        
        Vertex vertex7 = new Vertex();
        vertex7.setLayoutX(385 - 18);
        vertex7.setLayoutY(219 - 18);
		FadeTransition fade7 = new FadeTransition();
		fade7.setNode(vertex7);
		fade7.setDuration(Duration.millis(200));
		fade7.setCycleCount(1);
		fade7.setInterpolator(Interpolator.LINEAR);
		fade7.setFromValue(0);
		fade7.setToValue(1);
		fade7.play();
        myCanvas.getChildren().add(vertex7);
        graph.addVertext(vertex7);
        
        Vertex vertex8 = new Vertex();
        vertex8.setLayoutX(562 - 18);
        vertex8.setLayoutY(233 - 18);
		FadeTransition fade8 = new FadeTransition();
		fade8.setNode(vertex8);
		fade8.setDuration(Duration.millis(200));
		fade8.setCycleCount(1);
		fade8.setInterpolator(Interpolator.LINEAR);
		fade8.setFromValue(0);
		fade8.setToValue(1);
		fade8.play();
        myCanvas.getChildren().add(vertex8);
        graph.addVertext(vertex8);
        
        Vertex vertex9 = new Vertex();
        vertex9.setLayoutX(516 - 18);
        vertex9.setLayoutY(289 - 18);
		FadeTransition fade9 = new FadeTransition();
		fade9.setNode(vertex9);
		fade9.setDuration(Duration.millis(200));
		fade9.setCycleCount(1);
		fade9.setInterpolator(Interpolator.LINEAR);
		fade9.setFromValue(0);
		fade9.setToValue(1);
		fade9.play();
        myCanvas.getChildren().add(vertex9);
        graph.addVertext(vertex9);
        
        graph.addEdge(vertex1, vertex2);
		Edge edge = new Edge(graph.getIsDirected());
		edge.setStartX(463.98685313876086);
		edge.setStartY(55.29742072534003);
		edge.setEndX(363.01314686123914);
		edge.setEndY(136.7025792746599);
		Pair tempPair = new Pair(vertex1.getIdOfVertex(), vertex2.getIdOfVertex());
		listEdge.put(tempPair, edge);
        myCanvas.getChildren().add(edge);
        
        graph.addEdge(vertex1, vertex3);
		Edge edge2 = new Edge(graph.getIsDirected());
		double a = vertex1.getLayoutX() + 18;
		double b = vertex1.getLayoutY() + 18;
		double c = vertex3.getLayoutX() + 18;
		double d = vertex3.getLayoutY() + 18;
		double dx = Math.hypot(a - c, d - b);
		double tempX = c - a;
		double alpha = Math.acos(tempX/dx);
		double tempA = a + 18*Math.cos(alpha);
		double tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		double tempC = c + 18*Math.cos(Math.PI - alpha);
		double tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge2.setStartX(tempA);
		edge2.setStartY(tempB);
		edge2.setEndX(tempC);
		edge2.setEndY(tempD);
//		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair2 = new Pair(vertex1.getIdOfVertex(), vertex3.getIdOfVertex());
		listEdge.put(tempPair2, edge2);
        myCanvas.getChildren().add(edge2);
        
        graph.addEdge(vertex1, vertex4);
		Edge edge3 = new Edge(graph.getIsDirected());
		a = vertex1.getLayoutX() + 18;
		b = vertex1.getLayoutY() + 18;
		c = vertex4.getLayoutX() + 18;
		d = vertex4.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge3.setStartX(tempA);
		edge3.setStartY(tempB);
		edge3.setEndX(tempC);
		edge3.setEndY(tempD);
		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair3 = new Pair(vertex1.getIdOfVertex(), vertex4.getIdOfVertex());
		listEdge.put(tempPair3, edge3);
        myCanvas.getChildren().add(edge3);
        
        graph.addEdge(vertex1, vertex5);
		Edge edge4 = new Edge(graph.getIsDirected());
		a = vertex1.getLayoutX() + 18;
		b = vertex1.getLayoutY() + 18;
		c = vertex5.getLayoutX() + 18;
		d = vertex5.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge4.setStartX(tempA);
		edge4.setStartY(tempB);
		edge4.setEndX(tempC);
		edge4.setEndY(tempD);
		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair4 = new Pair(vertex1.getIdOfVertex(), vertex5.getIdOfVertex());
		listEdge.put(tempPair4, edge4);
        myCanvas.getChildren().add(edge4);
        
        graph.addEdge(vertex2, vertex6);
		Edge edge5 = new Edge(graph.getIsDirected());
		a = vertex2.getLayoutX() + 18;
		b = vertex2.getLayoutY() + 18;
		c = vertex6.getLayoutX() + 18;
		d = vertex6.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge5.setStartX(tempA);
		edge5.setStartY(tempB);
		edge5.setEndX(tempC);
		edge5.setEndY(tempD);
		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair5 = new Pair(vertex2.getIdOfVertex(), vertex6.getIdOfVertex());
		listEdge.put(tempPair5, edge5);
        myCanvas.getChildren().add(edge5);
        
        graph.addEdge(vertex2, vertex7);
		Edge edge6 = new Edge(graph.getIsDirected());
		a = vertex2.getLayoutX() + 18;
		b = vertex2.getLayoutY() + 18;
		c = vertex7.getLayoutX() + 18;
		d = vertex7.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge6.setStartX(tempA);
		edge6.setStartY(tempB);
		edge6.setEndX(tempC);
		edge6.setEndY(tempD);
		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair6 = new Pair(vertex2.getIdOfVertex(), vertex7.getIdOfVertex());
		listEdge.put(tempPair6, edge6);
        myCanvas.getChildren().add(edge6);
        
        graph.addEdge(vertex3, vertex8);
		Edge edge7 = new Edge(graph.getIsDirected());
		a = vertex3.getLayoutX() + 18;
		b = vertex3.getLayoutY() + 18;
		c = vertex8.getLayoutX() + 18;
		d = vertex8.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge7.setStartX(tempA);
		edge7.setStartY(tempB);
		edge7.setEndX(tempC);
		edge7.setEndY(tempD);
		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair7 = new Pair(vertex3.getIdOfVertex(), vertex8.getIdOfVertex());
		listEdge.put(tempPair7, edge7);
        myCanvas.getChildren().add(edge7);
        
        graph.addEdge(vertex8, vertex4);
		Edge edge8 = new Edge(graph.getIsDirected());
		a = vertex8.getLayoutX() + 18;
		b = vertex8.getLayoutY() + 18;
		c = vertex4.getLayoutX() + 18;
		d = vertex4.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge8.setStartX(tempA);
		edge8.setStartY(tempB);
		edge8.setEndX(tempC);
		edge8.setEndY(tempD);
		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair8 = new Pair(vertex8.getIdOfVertex(), vertex4.getIdOfVertex());
		listEdge.put(tempPair8, edge8);
        myCanvas.getChildren().add(edge8);
        
        graph.addEdge(vertex8, vertex9);
		Edge edge9 = new Edge(graph.getIsDirected());
		a = vertex8.getLayoutX() + 18;
		b = vertex8.getLayoutY() + 18;
		c = vertex9.getLayoutX() + 18;
		d = vertex9.getLayoutY() + 18;
		dx = Math.hypot(a - c, d - b);
		tempX = c - a;
		alpha = Math.acos(tempX/dx);
		tempA = a + 18*Math.cos(alpha);
		tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
		tempC = c + 18*Math.cos(Math.PI - alpha);
		tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
		edge9.setStartX(tempA);
		edge9.setStartY(tempB);
		edge9.setEndX(tempC);
		edge9.setEndY(tempD);
		//Systemout.println(tempA + " " + tempB + " " + tempC + " " + tempD);
		Pair tempPair9 = new Pair(vertex8.getIdOfVertex(), vertex9.getIdOfVertex());
		listEdge.put(tempPair9, edge9);
        myCanvas.getChildren().add(edge9);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lines = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            Label label = new Label("");
//            label.setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
            lines.add(label);
            label.setMaxWidth(1000);
            pseudoBox.getChildren().add(label);
        }
		graph = new Graph(false);
		createUGraph.setOnMouseEntered(event -> {
			createUGraph.setStyle("-fx-background-color: blue");
	    });
		createUGraph.setOnMouseExited(event -> {
			createUGraph.setStyle("-fx-background-color: #2574cf");
	    });
		createDGraph.setOnMouseEntered(event -> {
			createDGraph.setStyle("-fx-background-color: blue");
	    });
		createDGraph.setOnMouseExited(event -> {
			createDGraph.setStyle("-fx-background-color: #2574cf");
	    });
		removeE.setOnMouseEntered(event -> {
			removeE.setStyle("-fx-background-color: blue");
	    });
		removeE.setOnMouseExited(event -> {
			removeE.setStyle("-fx-background-color: #2574cf");
	    });
		DFSButton.setOnMouseEntered(event -> {
			DFSButton.setStyle("-fx-background-color: blue");
	    });
		DFSButton.setOnMouseExited(event -> {
			DFSButton.setStyle("-fx-background-color: #2574cf");
	    });
		RunC.setOnMouseEntered(event -> {
			RunC.setStyle("-fx-background-color: blue");
	    });
		RunC.setOnMouseExited(event -> {
			RunC.setStyle("-fx-background-color: #2574cf");
	    });
		RunT.setOnMouseEntered(event -> {
			RunT.setStyle("-fx-background-color: blue");
	    });
		RunT.setOnMouseExited(event -> {
			RunT.setStyle("-fx-background-color: #2574cf");
	    });
		nextStepButton.setOnMouseEntered(event -> {
			nextStepButton.setStyle("-fx-background-color: blue");
	    });
		nextStepButton.setOnMouseExited(event -> {
			nextStepButton.setStyle("-fx-background-color: #2574cf");
	    });
		autoRunButton.setOnMouseEntered(event -> {
			autoRunButton.setStyle("-fx-background-color: blue");
	    });
		autoRunButton.setOnMouseExited(event -> {
			autoRunButton.setStyle("-fx-background-color: #2574cf");
	    });
	}
	
	public void handleMouseOnCanvas(MouseEvent e) {
		if(mode == 0) {
			Vertex temp = getVertex(e);
			if(temp == null) {
				//Systemout.println(e.getX());
				//Systemout.println(e.getY());
				Vertex vertex = new Vertex();
				vertex.setLayoutX(e.getX() - 18);
				vertex.setLayoutY(e.getY() - 18);
				FadeTransition fade = new FadeTransition();
				fade.setNode(vertex);
				fade.setDuration(Duration.millis(200));
				fade.setCycleCount(1);
				fade.setInterpolator(Interpolator.LINEAR);
				fade.setFromValue(0);
				fade.setToValue(1);
				fade.play();
		        myCanvas.getChildren().add(vertex);
		        graph.addVertext(vertex);
		        noteText.setText("Note: " + "Node " + vertex.getIdOfVertex() + " created succesfully!!");
			} else {
				if(e.getButton() == MouseButton.PRIMARY) {
					if(temp.getIsChosenItem()) {
						temp.resetColor();
					} else if(Vertex.getNumberOfChosenItem() == 1){
						Vertex from = null;
						for (Vertex key : graph.getAdj().keySet()) {
						    if(key.getIsChosenItem()) { 
						    	from = key;
						    }
						}
						if(!graph.containsEdge(from, temp)) {
							graph.addEdge(from, temp);
							from.resetColor();
							Edge edge = new Edge(graph.getIsDirected());
							double a = from.getLayoutX() + 18;
							double b = from.getLayoutY() + 18;
							double c = temp.getLayoutX() + 18;
							double d = temp.getLayoutY() + 18;
							double dx = Math.hypot(a - c, d - b);
							
							double tempX = c - a;
							double alpha = Math.acos(tempX/dx);
							//Systemout.println(alpha);
							//Systemout.println(tempX);
							//Systemout.println(dx);
							//Systemout.println(a);
							double tempA = a + 18*Math.cos(alpha);
							//Systemout.println(a);
							//Systemout.println(a + " " + b + " " + c + " " + d);
							
							double tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
							double tempC = c + 18*Math.cos(Math.PI - alpha);
							double tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
							
							edge.setStartX(tempA);
							edge.setStartY(tempB);
							edge.setEndX(tempC);
							edge.setEndY(tempD);
							
							Pair tempPair = new Pair(from.getIdOfVertex(), temp.getIdOfVertex());
							listEdge.put(tempPair, edge);
					        noteText.setText("Note: " + "Edge " + from.getIdOfVertex() + " -- " +  temp.getIdOfVertex() + " created succesfully!!");
					        myCanvas.getChildren().add(edge);
						}else {
							noteText.setText("Note: Cannot create multigraph");
						}
					}else {
						temp.changeColor();
					}
				}else if(e.getButton() == MouseButton.SECONDARY) {
					ContextMenu contextMenu = new ContextMenu();
					MenuItem item1 = new MenuItem("Delete Vertex");
					item1.setOnAction(event -> {
						if(temp.getIsChosenItem()) {
							temp.resetColor();
						}
						graph.deleteVertext(temp.getIdOfVertex());
						myCanvas.getChildren().remove(temp);
						List<Pair<Integer, Integer>> tempRemoveEdge = new ArrayList<Pair<Integer, Integer>>();
						for(Pair<Integer, Integer> pair: listEdge.keySet()) {
							if(pair.getKey() == temp.getIdOfVertex() || pair.getValue() == temp.getIdOfVertex()) {
								tempRemoveEdge.add(pair);
							}
						}
						for(Pair<Integer, Integer> pair: tempRemoveEdge) {
							Edge removedEdge = listEdge.remove(pair);
							myCanvas.getChildren().remove(removedEdge);
						}
						//Systemout.println("Delete Vertex successfully");
				        noteText.setText("Note: " + "Delete vertex " + temp.getIdOfVertex() + " successfully");
					});
					contextMenu.getItems().addAll(item1);
					contextMenu.show(temp, e.getScreenX(), e.getScreenY());
				}
			}
		} else if(mode == 2) {
			mode = 0;
	        noteText.setText("Note: Now you can edit graph");
			reset();
		} else {
	        noteText.setText("Note: Cannot edit while running algs");
		}
	}
	private Vertex getVertex(MouseEvent e) {
		double xPos = e.getX();
		double yPos = e.getY();
		for (Vertex key : graph.getAdj().keySet()) {
			double layoutX = key.getLayoutX();
			double layoutY = key.getLayoutY();
			if(xPos > layoutX && xPos < layoutX + 36 && yPos > layoutY && yPos < layoutY + 36) {
				return key;
			}
		}
		return null;
	}
	
	public void runDFS() {
		//Systemout.println(listEdge);

		DFSButton.setStyle("-fx-background-color: black");
		PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
		pause.setOnFinished(e -> DFSButton.setStyle("-fx-background-color: #2574cf"));
		pause.play();
		if(graph.getAdj().keySet().size() > 0) {
			mode = 1;
			reset();
			nextStepButton.setDisable(false);
			autoRunButton.setDisable(false);
			lines.get(0).setText("DFS(u)");
			lines.get(0).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
			lines.get(1).setText("  visited[u] = true");
			lines.get(1).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
			lines.get(2).setText("  for each neighbor v of u");
			lines.get(2).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px;-fx-font-family: SansSerif;");
			lines.get(3).setText("    if v is unvisited, DFS(v)");
			lines.get(3).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
			lines.get(4).setText("    if v is visited, continue loop");
			lines.get(4).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
			Algorithm alg = new DFS(graph, lines, resText, noteText, listEdge, Integer.valueOf(DFSParam.getText()));
			context = new Context();
			context.setAlgorithm(alg);
			context.play();
		} else {
			noteText.setText("Note: Your graph is empty!!");
		}
	}
	public void runNextStep() {
		nextStepButton.setStyle("-fx-background-color: black");
		PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
		pause.setOnFinished(e -> nextStepButton.setStyle("-fx-background-color: #2574cf"));
		pause.play();
		if(!context.getAlgorithm().runNextStep()) {
			nextStepButton.setDisable(true);
			mode = 2;
	        noteText.setText("Note: Finish alg");
		}
	}
	public void autoRunAll() {
		autoRunButton.setStyle("-fx-background-color: black");
		PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
		pause.setOnFinished(e -> autoRunButton.setStyle("-fx-background-color: #2574cf"));
		pause.play();
		if(timeline != null)
			timeline.stop();
		timeline = new Timeline(new KeyFrame(Duration.millis(200), e -> {
	    	if(context.getAlgorithm().runNextStep()){
	    		return;
	    	}
	    	if(!context.getAlgorithm().runNextStep()) {
				nextStepButton.setDisable(true);
				autoRunButton.setDisable(true);
				mode = 2;
		        noteText.setText("Note: Finish alg");
		        timeline.stop();
			}
	    }));
	    timeline.setCycleCount(Animation.INDEFINITE); // loop forever
	    timeline.play();
	}
	
	public void createNewGraph() {
		reset();
		createUGraph.setStyle("-fx-background-color: black");
		PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
		pause.setOnFinished(e -> createUGraph.setStyle("-fx-background-color: #2574cf"));
		pause.play();
		mode = 0;
		graph = new Graph(false);
		listEdge = new HashMap<Pair<Integer, Integer>, Edge>();
		Vertex.resetStaticVar();
		VertexController.resetId();
		System.gc();
        noteText.setText("Note: Created a new undirected graph");
		myCanvas.getChildren().clear();
	}
	
	public void createNewDirectedGraph() {
		reset();
		createDGraph.setStyle("-fx-background-color: black");
		PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
		pause.setOnFinished(e -> createDGraph.setStyle("-fx-background-color: #2574cf"));
		pause.play();
		mode = 0;
		graph = new Graph(true);
		listEdge = new HashMap<Pair<Integer, Integer>, Edge>();
		Vertex.resetStaticVar();
		VertexController.resetId();
		System.gc();
        noteText.setText("Note: Created a new directed graph");
		myCanvas.getChildren().clear();
	}
	public void runTopo() {
		RunT.setStyle("-fx-background-color: black");
		PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
		pause.setOnFinished(e -> RunT.setStyle("-fx-background-color: #2574cf"));
		pause.play();
		if(graph.getAdj().keySet().size() > 0) {
			mode = 1;
			reset();
	        noteText.setText("Note: Running topological sort alg");
			nextStepButton.setDisable(false);
			autoRunButton.setDisable(false);
			if(graph.getIsDirected()) {
				Algorithm alg = new TopologicalSort(graph, lines, resText, noteText);
				context = new Context();
				lines.get(0).setText("setup parameter for topological sort");
				lines.get(0).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px;-fx-font-family: SansSerif;");				
				lines.get(1).setText("while Q not empty");
				lines.get(1).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px;-fx-font-family: SansSerif;");
				lines.get(2).setText("  v <- dequeue Q and add v to topo");
				lines.get(2).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
				lines.get(3).setText("  for each adj vertex av of v");
				lines.get(3).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
				lines.get(4).setText("    indegree[av]--");
				lines.get(4).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
				lines.get(5).setText("    if indegree[av] == 0 => add av to Q");
				lines.get(5).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px;-fx-font-family: SansSerif;");
				lines.get(6).setText("  Visited++");
				lines.get(6).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
				lines.get(7).setText("if visited != V => error graph contains cycle");
				lines.get(7).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
				context.setAlgorithm(alg);
				context.play();
				resText.setText("Result:");
			}else {
				//Systemout.println("Cannot run topological sort when it is undirected graph");
		        noteText.setText("Note: Cannot run topological sort when it is undirected graph");
				nextStepButton.setDisable(true);
				autoRunButton.setDisable(true);
				mode = 2;
			}
		} else {
			noteText.setText("Note: Your graph is empty!!");
		}
	}
	public void removeEdge() {
		removeE.setStyle("-fx-background-color: black");
		PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
		pause.setOnFinished(e -> removeE.setStyle("-fx-background-color: #2574cf"));
		pause.play();
		try {
			if(mode == 0) {
				graph.deleteEdge(Integer.valueOf(from.getText()), Integer.valueOf(to.getText()));
				Pair<Integer, Integer> tempRemoveEdge = null;
				for(Pair<Integer, Integer> pair: listEdge.keySet()) {
					if(pair.getKey() == Integer.parseInt(from.getText()) && pair.getValue() == Integer.parseInt(to.getText())
							|| pair.getKey() == Integer.parseInt(to.getText()) && pair.getValue() == Integer.parseInt(from.getText())
					) {
						tempRemoveEdge = pair;
					}
				}
				Edge removedEdge = listEdge.remove(tempRemoveEdge);
				myCanvas.getChildren().remove(removedEdge);
		        noteText.setText("Note: Edge " + Integer.parseInt(from.getText()) + " -- " + Integer.parseInt(to.getText()) + " removed");
		        if(tempRemoveEdge == null) {
		        	noteText.setText("Note: This edge is not existed");
		        }
			} else {
		        noteText.setText("Note: Cannot remove edge while running");
			}
		} catch(NumberFormatException e) {
	        noteText.setText("Note: Wrong input vertex to remove");
		}
	}
	public void runCutVertex() {
		RunC.setStyle("-fx-background-color: black");
		PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
		pause.setOnFinished(e -> RunC.setStyle("-fx-background-color: #2574cf"));
		pause.play();
		if(graph.getAdj().keySet().size() > 0) {
			mode = 1;
			reset();
	        noteText.setText("Note: Running cut vertex and bridge finding alg");
			nextStepButton.setDisable(false);
			autoRunButton.setDisable(false);
			if(!graph.getIsDirected()) {
				Algorithm alg = new CutVertexBridgeFinding(graph, lines, resText, noteText, listEdge);
				context = new Context();
				context.setAlgorithm(alg);
				lines.get(0).setText("try all vertex u, if u hasnt been visited, DFS(u)");
				lines.get(0).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px;-fx-font-family: SansSerif;");				
				lines.get(1).setText("DFS(u), initiate num[u] = low[u] = DFSCount");
				lines.get(1).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px;-fx-font-family: SansSerif;");
				lines.get(2).setText("  try all neighbor v of u");
				lines.get(2).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
				lines.get(3).setText("    if v is free, DFS(v)");
				lines.get(3).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
				lines.get(4).setText("      low[u] = min(low[u], low[v])-");
				lines.get(4).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
				lines.get(5).setText("      check the condition");
				lines.get(5).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px;-fx-font-family: SansSerif;");
				lines.get(6).setText("    else low[u] = min(low[u], num[v])");
				lines.get(6).setStyle("-fx-text-fill: #1b00e4; -fx-font-size: 14px; -fx-font-family: SansSerif;");
				context.play();
				resText.setText("Result:");
			}else {
//				//Systemout.println("Cannot run cut vertext and bridge finding when it is directed graph");
		        noteText.setText("Note: Cannot run cut vertext and bridge finding when it is directed graph");
				nextStepButton.setDisable(true);
				autoRunButton.setDisable(true);
				mode = 2;
			}
		} else {
			noteText.setText("Note: Your graph is empty!!");
		}
	}
	public void reset() {
		nextStepButton.setDisable(true);
		autoRunButton.setDisable(true);
		resetColor();
		resText.setText("");
		for(Label element : lines) {
			element.setText(" ");
			element.setStyle("");
		}
	}
	private void resetColor() {
		for(Edge ed: listEdge.values()) {
			ed.resetColor();
		}
		for(Vertex v: graph.getAdj().keySet()) {
			v.resetColor();
		}
		Vertex.resetStaticVar();
	}
}
