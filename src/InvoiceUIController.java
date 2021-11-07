import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InvoiceUIController implements Initializable {

  @FXML
  private Button btnDownloadInvoice;
  @FXML
  private Label lblInvoiceErrors;
  @FXML
  private Label lblSuccessFail;

  private Invoice invoice  =  Invoice.getInstance();


  public void handleBtnDownloadInvoice() throws SecurityException, IOException {
	  
    //Generate the invoice and get the file path	  
	String theInvoiceUrl = invoice.generate();
	
	//attempt to open file
    try {
      Desktop.getDesktop().open(new java.io.File(theInvoiceUrl));
    } catch (Exception y) {
      lblInvoiceErrors.setText("Could not open invoice");
    }

  }
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
	// Controller must implement an initialize method
  }

}