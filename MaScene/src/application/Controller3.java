package application;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import da.project.ihm.Program;

public class Controller3 implements Initializable {
	List<Vector> vectors=filec.loadData("C:\\Users\\mamadou\\eclispe\\MaScene\\PourcentageAxe.txt");
	double[] ptr=filec.vector_to_vecteur (vectors);
	
	private Stage stage;
	private Scene scene; 
	private Parent root;
	
	
	
	public void switchToScene2(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("test2.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		   stage.setTitle("Analyse de Composants principales-1");

		stage.show();
		
	}
	public void switchToScene3(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("test3.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		   stage.setTitle("Analyse de Composants principales-3");

		stage.show();
		
	}

    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                
                        new PieChart.Data("Axe-1", ptr[0]));
       
        for(int i=1;i<ptr.length;i++) {
        	pieChartData.add(new PieChart.Data("Axe-"+(i+1), ptr[i]));
        	
        }
        
        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " Axe pricipale: ", data.pieValueProperty()
                        )
                )
        );

        pieChart.getData().addAll(pieChartData);
    }
}