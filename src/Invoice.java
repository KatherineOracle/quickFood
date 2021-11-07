import java.io.IOException;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

//implementing the Singleton pattern!
//Ref https://dev.to/devtony101/javafx-3-ways-of-passing-information-between-scenes-1bm8 

public class Invoice {

	  private Customer customer;
	  private Restaurant restaurant;
	  private Driver driver;	
	  private List < OrderItem > orderItems;
	  private static final Invoice INSTANCE = new Invoice();
	  private int orderNumber;
	  
	  
	  private Invoice() {}
	  
	  public static Invoice getInstance() {
	    return INSTANCE;
	  }
	  
	  public void setCustomer(Customer c) {
	    this.customer = c;
	  }
	  
	  public void setRestaurant(Restaurant r) {
		    this.restaurant = r;
		  }	  
	  
	  public void setDriver(Driver d) {
		    this.driver = d;
		  }	
	  
	  public void setOrderItems(List < OrderItem > o) {
		    this.orderItems = o;
		  }		  
	  
	  public Customer getCustomer() {
	    return this.customer;
	  }
	  public Restaurant getRestaurant() {
		    return this.restaurant;
	  }
	  public Driver getDriver() {
		    return this.driver;
	}
	  
	  public List < OrderItem > getOrderItems() {
		    return this.orderItems;
	}
	  
	  private Random r = new Random();
	  // create order number 
	  protected int genOrderNumber() {		  
		  return r.nextInt(10000);
	  }

	  // method to calculate total 
	  protected String genTotal() {

	    double orderTotal = 0.00;
	    for (OrderItem item: orderItems) {
	      orderTotal += item.getPrice() * item.getQuantity();
	    }
	    return "R" + String.format("%.2f", orderTotal);
	  }

	  // method to concatenate ordered items list
	  protected String genItemString() {

		StringBuilder bld = new StringBuilder();
	    for (OrderItem item: orderItems) {
	    	bld.append(item.toString());
	    }
	    return bld.toString();
	  }

	  // method to build the invoice
	  public String generate() throws SecurityException, IOException {

		orderNumber  = genOrderNumber(); 
		
		InvoiceRecords invoiceRecords  = new InvoiceRecords();
	    //save record of invoice to text file
	    try {
			invoiceRecords.saveToFile(this.orderNumber, this.customer.getName(), this.restaurant.getCity());
		} catch (SecurityException | IOException e1) {
			
			e1.printStackTrace();
		}

	    //append all the invoice lines into one string
	    String invoiceTxt = "" +
	      "Order number " + this.orderNumber + " \n" +
	      this.customer.toString() +
	      "\n" +
	      "You have ordered the following from " + this.restaurant.getName() + " in " + this.restaurant.getCity() + ":\n" +
	      "\n" +
	      this.genItemString() + "\n" +
	      "----------------------------\n" +
	      "Total: " + this.genTotal() + " \n" +
	      "----------------------------\n\n" +
	      "Special instructions: \n" + this.customer.getInstructions() + " \n" +

	      this.driver.getName() + " is nearest to the restaurant and so he will be delivering your \n" +
	      "order to you at: \n" +
	      this.customer.getAddress() +
	      "\r\n\r\n" +
	      "If you need to contact the restaurant, their number is " + this.restaurant.getphoneNumber() + ".\n";

	    try (Formatter writer = new Formatter("data/invoice.txt")) {
	      //dump the string into a file	      
	      writer.format("%s", invoiceTxt);

	      //if all went well, return the invoice url to the GUI for the open 
	      //invoice button
	      return "data/invoice.txt";

	    } catch (Exception e) {

	      //Something went wrong
	      return "Error";

	    }

	  }	  
	
}
