import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class InvoiceRecords {

  //properties
  private List < InvoiceRecord > invoices = new ArrayList <> ();

  //constructor	
  public InvoiceRecords() throws IOException {

    // read through the invoices text file 

    try {
      File invoiceSrc = new File("data/invoices.txt");
      Scanner sc = new Scanner(invoiceSrc);

      while (sc.hasNextLine()) {
        //read the line
        String invoiceString = sc.nextLine();

        //split the line of text into an array at the comma
        String[] invoiceArr = invoiceString.split(", ");

        
        //create the driver and add it to our ArrayList of drivers
        invoices.add(new InvoiceRecord(Integer.parseInt(invoiceArr[0]), invoiceArr[1], invoiceArr[2]));

      }

      //close scanner as we should
      sc.close();

    } catch (FileNotFoundException e) {

		Handler handler = new FileHandler("data/errors.log");
		Logger.getLogger("Invoices file not found").addHandler(handler);

    }

  }

  //method to reorder and store sales records 
  public void saveToFile(Integer orderNumber, String customerName, String location) throws SecurityException, IOException {

	//build the new record string  
    String recordTxt = '\n' + orderNumber + ", " + customerName + ", " + location;

    try (FileWriter fw = new FileWriter("data/invoices.txt", true)){

      //append the invoice summary to file
      //https://www.java67.com/2015/07/how-to-append-text-to-existing-file-in-java-example.html#ixzz7AxW2pTmz
      // In order to append text to a file, you need to open
      // file into append mode, you do it by using
      // FileReader and passing append = true
      
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);

      //write the record to end of file
      pw.println(recordTxt);

      pw.close();
      bw.close();


    } catch (SecurityException | IOException e) {
      //Something went wrong
		Handler handler = new FileHandler("data/errors.log");
		Logger.getLogger("Invoices file not found").addHandler(handler);
    }

  }

  //method to reorder and store sales records 
  public void orderByCustomer() {


    //sort the list alphabetically by customer name, case insensitive
    List < InvoiceRecord > sortedList = invoices.stream()
      .sorted(Comparator.comparing(InvoiceRecord::getCustomer, String.CASE_INSENSITIVE_ORDER))
      .toList();

    this.invoices = sortedList;

  }

  //method to reorder and store sales records 
  public void orderByLocation() {

    //sort the list alphabetically by location, case insensitive
    List < InvoiceRecord > sortedList = invoices.stream()
      .sorted(Comparator.comparing(InvoiceRecord::getLocation, String.CASE_INSENSITIVE_ORDER))
      .toList();
    
    
    this.invoices = sortedList;

  }

  
  //function to rewrite the ordered list based on lists sorted in functions above
  public String generateFile() {
    try (Formatter writer = new Formatter("data/ordered.txt")) {

      this.invoices.forEach((invoiceRecord) -> {
        writer.format("%s%n", invoiceRecord.toString());
      });


      return "data/ordered.txt";

    } catch (Exception e) {
      //Something went wrong
      return "Sorry. There was a problem.";
    }

  }

}