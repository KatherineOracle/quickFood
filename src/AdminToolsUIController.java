import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AdminToolsUIController implements Initializable {

  //declare control objects that hook into the FXML file 
  @FXML
  private Button btnCustomersAlphabetical;
  @FXML
  private Button btnCustomersLocation;
  @FXML
  private Label lblError;

  //handle click on "Orders by customer name button"
  public void handleBtnCustomersAlphabetical(ActionEvent event) throws IOException {

	//load invoice records to object  
    InvoiceRecords allInvoices = new InvoiceRecords();
    
    //order invoice records
    allInvoices.orderByCustomer();
    
    //get the url of the ordered file
    String orderListUrl = allInvoices.generateFile();

    //try to open file
    try {

      Desktop.getDesktop().open(new java.io.File(orderListUrl));

    } catch (Exception y) {

      lblError.setText("Could not open Order file");
    }

  }

  //handle click on "Orders by location"  
  public void handleBtnCustomersLocation(ActionEvent event) throws IOException {

	//load invoice records to object
    InvoiceRecords allInvoices = new InvoiceRecords();
    
    //order invoice records    
    allInvoices.orderByLocation();
    
    //get the url of the ordered file    
    String orderListUrl = allInvoices.generateFile();

    //try to open file    
    try {

      Desktop.getDesktop().open(new java.io.File(orderListUrl));

    } catch (Exception y) {

      lblError.setText("Could not open Order file");
    }

  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

}