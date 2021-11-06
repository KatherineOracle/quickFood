public class InvoiceRecord {

  //properties
  private String customer;
  private String location;
  private int id;

  //constructor
  public InvoiceRecord(int id, String customer, String location) {
    this.id = id;
    this.customer = customer;
    this.location = location;
  }

  //getters
  public String getLocation() {
    return this.location;
  }

  public String getCustomer() {
    return this.customer;
  }

  public int getId() {
    return this.id;
  }

  public String toString() {
    return this.id + ", " + this.customer + ", " + this.location;
  }

}