package application;
import da.project.ihm.Program;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SceneController implements ActionListener {
	private Stage stage;
	private Scene scene; 
	private Parent root;
	public File str;
	
	
	
	
	public Label static_label;
	
 
	
	public void switchToScene1(ActionEvent event) throws IOException {
		
		root=FXMLLoader.load(getClass().getResource("test1.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Analyse de Composants principales");

		stage.show();

	}
	 
    public void switchToScene2(ActionEvent event) throws IOException {
    	Program.main(str);
    	root = FXMLLoader.load(getClass().getResource("test2.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		   stage.setTitle("Analyse de Composants principales-1");

		stage.show();
		
	}
    
    public void exit(ActionEvent event) {
		System.out.println("L'application se ferme !!!");
		System.exit(0);
	}

    
	public void actionPerformed (ActionEvent event) {
		// TODO Auto-generated method stub
			
			JFileChooser fileChooser = new JFileChooser();
			File file = new File("");
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				//System.out.println(file);
				str=file;
				static_label.setText("Votre Choix est :\n"+String.valueOf(file)+"\nAppuiyer sur COMMENCER !");
				static_label.setTextAlignment(TextAlignment.CENTER);
				
				
			
		}
		
		
			
		
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
