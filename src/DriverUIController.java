import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DriverUIController extends UIController implements Initializable {

  //declare control objects that hook into the FXML file  
  @FXML
  private TextField textCityRestaurant;
  @FXML
  private Button btnPairDriver;


  public void handleBtnPairDriver(ActionEvent event) throws IOException {

    //get data from the city restaurant field 
    //trim = removes spaces from start & end of the string
    String textRestaurantCity = textCityRestaurant.getText().trim();

    // instantiate a drivers object
    Drivers drivers = new Drivers();

    //search the list of drivers for match in same city
    if (drivers.isAvailable(textRestaurantCity)) {

      //We have a match! Appoint the driver and move onto the next panel
      //hide the current panel
    	Driver driver = drivers.appoint(textRestaurantCity);
      
      //pass driver info to the invoice instance (constant)
      Invoice invoice = Invoice.getInstance();
      invoice.setDriver(driver);        
      
      //super class function to go to the next scene
      changeScene("fxml/RestaurantUI.fxml", event);


    } else {

      //No driver match in this city! 
      //save driver to invoice instance with name as null	
      Invoice holder = Invoice.getInstance();
      holder.setDriver(new Driver(null, textRestaurantCity, 0));  
      
      //super class function to go to the "Sorry No Driver" scene
      changeScene("fxml/NoDriverUI.fxml", event);

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