import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) throws Exception {
	  
	//set application name in title bar
    stage.setTitle("QuickFood app");

    //load up the first scene
    Parent root = FXMLLoader.load(getClass().getResource("StartUI.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    
  }

  public static void main(String[] args) {
    launch(args);
  }
}