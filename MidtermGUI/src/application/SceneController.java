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
import application.components.edge.Edge;
import application.components.graph.Graph;
import application.components.vertext.Vertex;
import application.components.vertext.VertexController;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.util.Pair;

public class SceneController implements Initializable {
	
	@FXML
	AnchorPane myCanvas;
	@FXML
	TextField DFSParam;
	@FXML 
	TextField from;
	@FXML
	TextField to;
	@FXML
	Button nextStepButton;
	@FXML 
	Label noteText;
	@FXML
	Label resText;
	@FXML
	Button createUGraph;
	@FXML
	Button createDGraph;
	@FXML
	Button removeE;
	@FXML
	Button DFSButton;
	@FXML
	Button RunC;
	@FXML
	Button RunT;
	
	Context context;
	
	private int mode = 0;
	
	Graph graph;
	HashMap<Pair<Integer, Integer>, Edge> listEdge = new HashMap<Pair<Integer, Integer>, Edge>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
	}
	
	public void handleMouseOnCanvas(MouseEvent e) {
		if(mode == 0) {
			Vertex temp = getVertex(e);
			if(temp == null) {
				System.out.println(e.getX());
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
							
//							Tìm được a = xA r
							double tempX = c - a;
							double alpha = Math.acos(tempX/dx);
							System.out.println(alpha);
							System.out.println(tempX);
							System.out.println(dx);
							System.out.println(a);
							double tempA = a + 18*Math.cos(alpha);
							System.out.println(a);
							System.out.println(a + " " + b + " " + c + " " + d);
							
							double tempB = (b-d)/(a-c)*tempA + b - (b-d)/(a-c)*a;
							double tempC = c + 18*Math.cos(Math.PI - alpha);
							double tempD = (b-d)/(a-c)*tempC + b - (b-d)/(a-c)*a;
							
//							double res1 = 0, res2 = 0, res3 = 0, res4 = 0;
//							if(a == c) {
//								if(d > b) {
//									res1 = a;
//									res3 = a;
//									res2 = b + 18;
//									res4 = d - 18;
//								}else {
//									res1 = a;
//									res3 = a;
//									res2 = b - 18;
//									res4 = d + 18;
//								}
//							}else {
//								double x = 18*Math.abs((c-a)/(d-b));
//								if(c > a) {
//									res1 = a + x;
//								}else {
//									res1 = a - x;
//								}
//								res2 = res1*((b-d)/(a-c)) + b - (b-d)*a/(a-c);
//							}
//							edge.setStartX(a);
//							edge.setStartY(b);
//							edge.setEndX(c);
//							edge.setEndY(d);
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
						graph.deleteVertext(temp.getIdOfVertex());
						myCanvas.getChildren().remove(temp);
						List<Pair<Integer, Integer>> tempRemoveEdge = new ArrayList<Pair<Integer, Integer>>();
						for(Pair<Integer, Integer> pair: listEdge.keySet()) {
							if(pair.getKey() == temp.getIdOfVertex() || pair.getValue() == temp.getIdOfVertex()) {
								tempRemoveEdge.add(pair);
							}
						}
						//xóa trong vòng for gây lỗi vì sau đó duyệt đến k có -> rất đơn giản fix băng cách cho vào list r xóa 1 thể
						for(Pair<Integer, Integer> pair: tempRemoveEdge) {
							Edge removedEdge = listEdge.remove(pair);
							myCanvas.getChildren().remove(removedEdge);
						}
						System.out.println("Delete Vertex successfully");
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
		DFSButton.setStyle("-fx-background-color: black");
		PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
		pause.setOnFinished(e -> DFSButton.setStyle("-fx-background-color: #2574cf"));
		pause.play();
		if(graph.getAdj().keySet().size() > 0) {
			System.out.println(graph.getAdj().keySet().size());
			mode = 1;
			reset();
			nextStepButton.setDisable(false);
			Algorithm alg = new DFS(graph);
			context = new Context();
			context.setupAlgorithm(alg);
			context.play(Integer.valueOf(DFSParam.getText()), listEdge, noteText, resText);
		} else {
			noteText.setText("Note: Your graph is empty!!");
		}
	}
	public void runNextStep() {
		nextStepButton.setStyle("-fx-background-color: black");
		PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
		pause.setOnFinished(e -> nextStepButton.setStyle("-fx-background-color: #2574cf"));
		pause.play();
		if(!context.getAlgorithm().runNextStep(listEdge, noteText, resText)) {
			nextStepButton.setDisable(true);
			mode = 2;
	        noteText.setText("Note: Finish alg");
		}
	}
	
	public void createNewGraph() {
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
//		Rectangle rec = new Rectangle();
//		rec.setWidth(myCanvas.getWidth());
//		rec.setHeight(myCanvas.getHeight());
//		rec.setX(0);
//		rec.setY(0);
//		rec.setStyle("-fx-fill: #f4f4f4");
		myCanvas.getChildren().clear();
//		myCanvas.getChildren().add(rec);
	}
	
	public void createNewDirectedGraph() {
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
//		Rectangle rec = new Rectangle();
//		rec.setWidth(myCanvas.getWidth());
//		rec.setHeight(myCanvas.getHeight());
//		rec.setX(0);
//		rec.setY(0);
//		rec.setStyle("-fx-fill: #f4f4f4");
		myCanvas.getChildren().clear();
//		myCanvas.getChildren().add(rec);
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
			if(graph.getIsDirected()) {
				Algorithm alg = new TopologicalSort(graph);
				context = new Context();
				context.setupAlgorithm(alg);
				context.play();
				resText.setText("Result:");
			}else {
				System.out.println("Cannot run topological sort when it is undirected graph");
		        noteText.setText("Note: Cannot run topological sort when it is undirected graph");
				nextStepButton.setDisable(true);
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
			if(!graph.getIsDirected()) {
				Algorithm alg = new CutVertexBridgeFinding(graph);
				context = new Context();
				context.setupAlgorithm(alg);
				context.play();
				resText.setText("Result:");
			}else {
				System.out.println("Cannot run topological sort when it is directed graph");
		        noteText.setText("Note: Cannot run topological sort when it is directed graph");
				nextStepButton.setDisable(true);
				mode = 2;
			}
		} else {
			noteText.setText("Note: Your graph is empty!!");
		}
	}
	public void reset() {
		resetColor();
		resText.setText("");
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