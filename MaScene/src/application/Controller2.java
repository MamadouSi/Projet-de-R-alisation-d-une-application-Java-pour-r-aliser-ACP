package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
	private Stage stage;
	private Scene scene; 
	private Parent root;
	List<Vector> vectors=filec.loadData("C:\\Users\\mamadou\\eclispe\\MaScene\\OriginalData.txt");
	double[][] matrix=filec.vector_to_matrice (vectors);
	
	
	
    @FXML
    private BubbleChart<Double, Double> bubbleChart;

    XYChart.Series series1 = new XYChart.Series();
 

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bubbleChart.getXAxis().setLabel("Axe_1");
        bubbleChart.getYAxis().setLabel("Axe_2");

        series1.setName("Individu");
        for(int i=0;i<matrix.length;i++) {
        	series1.getData().add(new XYChart.Data(matrix[i][0],matrix[i][1],0.2));
        	
        }
        

        

        bubbleChart.getData().addAll(series1);
    }
    
    
    public void exit(ActionEvent event) {
		System.out.println("L'application se ferme");
		System.exit(0);
	}
    
    public void switchToScene1(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("test1.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		   stage.setTitle("Analyse de Composants principales");

		stage.show();
		
	}
    
    public void switchToScene4(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("test4.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		   stage.setTitle("Analyse de Composants principales-2");

		stage.show();
		
	}
    
}
