public class Restaurant {

  //properties
  private String name;
  private String streetAddress;
  private String city;
  private String phoneNumber;

  //constructor
  public Restaurant(String name, String streetAddress, String city, String phoneNumber) {
    this.name = name;
    this.streetAddress = streetAddress;
    this.city = city;
    this.phoneNumber = phoneNumber;
  }

  //getters
  public String getCity() {
    return this.city;
  }

  public String getName() {
    return this.name;
  }

  public String getAddress() {
    return this.streetAddress;
  }

  public String getphoneNumber() {
    return this.phoneNumber;
  }

}