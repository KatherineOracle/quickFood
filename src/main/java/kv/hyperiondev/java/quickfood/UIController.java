package kv.hyperiondev.java.quickfood;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIController {
	
//we use this function repeatedly in all controllers that change scenes, 
//thus it is stored in a super class	
	  public void changeScene(String fxmlurl, ActionEvent event) throws IOException {                   

		  //get the parent window/stage from the click event
		  Node node = (Node) event.getSource();
		  Stage stage = (Stage) node.getScene().getWindow();
		  stage.hide();
		   
		  //load up the next scene onto the stage
		  FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlurl + ".fxml"));
	      Parent rootPane = loader.load();
	      Scene scene = new Scene(rootPane);
	      stage.setScene(scene);
	      stage.show();		    
	  }

}
