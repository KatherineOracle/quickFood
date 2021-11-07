import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class StartUIController extends UIController implements Initializable {

  @FXML
  private Button btnAdministrator;

  @FXML
  private Button btnCustomer;

  public void handleBtnCustomer(ActionEvent event) throws IOException {

    changeScene("fxml/DriverUI.fxml", event);
  }

  public void handleBtnAdministrator(ActionEvent event) throws IOException {

    changeScene("fxml/AdminToolsUI.fxml", event);

  }


  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
	// Controller must implement an initialize method
  }

}