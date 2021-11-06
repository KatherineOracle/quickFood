import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class RestaurantUIController extends UIController implements Initializable {

  //declare control objects that hook into the FXML file  
  @FXML
  private TextField textNameRestaurant;
  @FXML
  private TextField textPhoneRestaurant;
  @FXML
  private TextArea textAddressRestaurant;
  @FXML
  private Button btnCreateRestaurant;
  @FXML
  private Label lblAppointedDriverName;

  private Restaurant restaurant;
  Invoice invoice = Invoice.getInstance();


  public void handleBtnCreateRestaurant(ActionEvent event) throws IOException {
	  
    //trim up all the text fields
    String textRestaurantCity = invoice.getDriver().getCity();
    String textRestaurantName = textNameRestaurant.getText().trim();
    String textRestaurantAddress = textAddressRestaurant.getText().trim();
    String textRestaurantPhone = textPhoneRestaurant.getText().trim();

    //create the restaurant object
    restaurant = new Restaurant(textRestaurantName, textRestaurantAddress, textRestaurantCity, textRestaurantPhone);
    
    //store restaurant in the invoice instance
    Invoice invoice = Invoice.getInstance();
    invoice.setRestaurant(restaurant); 
    
    //super class function to go to the next scene
    changeScene("OrderItemsUI.fxml", event);    

  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // message to confirm selected drive on scene initialisation
	  lblAppointedDriverName.setText(invoice.getDriver().getName()+" will deliver your order");
  }

}