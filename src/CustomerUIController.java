import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CustomerUIController extends UIController implements Initializable {

  //declare control objects that hook into the FXML file 	
  @FXML
  private TextField textCityCustomer;
  @FXML
  private TextField textNameCustomer;
  @FXML
  private TextField textPhoneCustomer;
  @FXML
  private TextField textEmailCustomer;
  @FXML
  private TextArea textAddressCustomer;
  @FXML
  private TextArea textInstructionsCustomer;
  @FXML
  private Button btnCreateCustomer;

  private Customer customer;

  //handle click on the "Complete order" button  
  public void handleBtnCreateCustomer(ActionEvent event) throws IOException {

	// trim up text from input fields  
    String customerCity = textCityCustomer.getText().trim();
    String customerName = textNameCustomer.getText().trim();
    String customerAddress = textAddressCustomer.getText();
    String customerPhone = textPhoneCustomer.getText().trim();
    String customerEmail = textEmailCustomer.getText().trim();
    String customerInstructions = textInstructionsCustomer.getText();

    //create a customer from field data
    customer = new Customer(customerName, customerAddress, customerCity, customerPhone, customerEmail, customerInstructions);
    
    //store the customer to the invoice instance (constant)
    Invoice invoice = Invoice.getInstance();
    invoice.setCustomer(customer);  
    
    //super class function to go to the next scene
    changeScene("InvoiceUI.fxml", event);

  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

}