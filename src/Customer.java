public class Customer {

  //declare properties
  private String name;
  private String streetAddress;
  private String city;
  private String phoneNumber;
  private String email;
  private String instructions;

  //constructor
  public Customer(String name, String streetAddress, String city, String phoneNumber, String email, String instructions) {
    this.name = name;
    this.streetAddress = streetAddress;
    this.city = city;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.instructions = instructions;
  }

  //method to return customer details in a string
  public String toString() {
    String customerString = "Customer: " + this.name + " \n" +
      "Email: " + this.email + " \n" +
      "Phone number: " + this.phoneNumber + " \n" +
      "Location: " + this.city + " \n";
    return customerString;
  }

  //return street address to invoice	
  public String getName() {
    return this.name;
  }

  //return street address to invoice	
  public String getAddress() {
    return this.streetAddress;
  }

  //return instructions to invoice	
  public String getInstructions() {
    return this.instructions;
  }
}