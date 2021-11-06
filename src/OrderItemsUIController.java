import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class OrderItemsUIController extends UIController implements Initializable {

  @FXML
  private TextField textMenuItem;
  @FXML
  private TextField textMenuQuantity;
  @FXML
  private TextField textMenuPrice;
  @FXML
  private TextArea txtOrderItems;
  @FXML
  private Button btnAddtoBasket;
  @FXML
  private Button btnChangeScene;

  private List < OrderItem > theOrderItems = new ArrayList < OrderItem > ();


  public void handleBtnAddItem(ActionEvent event) throws IOException {
    System.out.println("adding items");
    //trim up the user input
    String itemName = textMenuItem.getText().trim();
    int itemQuantity = Integer.parseInt(textMenuQuantity.getText().trim());
    double itemPrice = Double.parseDouble(textMenuPrice.getText().trim());

    //create the ordered item object
    OrderItem orderItem = new OrderItem(itemName, itemPrice, itemQuantity);
    // add item to array list
    theOrderItems.add(orderItem);

    // set text of order items textArea.
    txtOrderItems.setText(listify());

    //Make the order item text fields empty so user can add another item
    textMenuItem.setText("");
    textMenuQuantity.setText("");
    textMenuPrice.setText("");

  }

 //function to convert list into printable string
  private String listify() {

    String listString = "";

    for (OrderItem item: theOrderItems) {

      listString += item.toString();
    }

    return listString;
  }

  //handle change on "Continue" button click  
  public void handleBtnChangeScene(ActionEvent event) throws IOException {
	 
	//store the list of order items to the invoice instance  
	Invoice invoice = Invoice.getInstance();
	invoice.setOrderItems(theOrderItems);  	
	
	//super class function to go to the next scene
	changeScene("CustomerUI.fxml", event);


  }
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

}