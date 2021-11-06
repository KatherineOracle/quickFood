import java.awt.Desktop;
import java.net.URL;
import java.util.Formatter;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class NoDriverUIController implements Initializable {

  //declare control objects that hook into the FXML file 
  @FXML
  private Button btnDownloadNote;
  @FXML
  private Label lblDownloadError;
  @FXML
  private Label lblSuccessFail;
  
  private Invoice invoice  =  Invoice.getInstance();
  

  // generate the notice to customer if no driver is available
  public  String noDriverNotice() {
	
    String noticeTxt = "Sorry! Our drivers are too far away from you to be " +
      "able to deliver to your location.";

    try {

      //write the message to the invoice
      Formatter writer = new Formatter("data/invoice.txt");
      writer.format("%s", noticeTxt);
      writer.close();

      //if all went well, return the message url to the GUI for the open 
      //notification button 			
      return "data/invoice.txt";

    } catch (Exception e) {
      //Something went wrong
      return "Error";

    }

  }

//handle click on download 
  public void handleBtnDownloadNote() {
    //generate the notice and get the file path
	  String theNoteUrl = noDriverNotice();
	  
	//attempt to open file   
    try {
      Desktop.getDesktop().open(new java.io.File(theNoteUrl));
    } catch (Exception y) {
      lblDownloadError.setText("Could not open notificaton");
    }

  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // Show message on open of scene
	  String restaurantCity = invoice.getDriver().getCity();
	  lblSuccessFail.setText("There are no drivers available in " + restaurantCity);

  }

}