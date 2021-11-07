
public class Driver {

  //properties
  private String name;
  private String city;
  private int load;

  //constructor
  public Driver(String name, String city, int load) {
    this.name = name;
    this.city = city;
    this.load = load;
  }

  //getters
  public String getCity() {
    return this.city;
  }

  public String getName() {
    return this.name;
  }

  public String toString() {
    return this.name + ", " + this.city + ", " + this.load;
  }

  public int getLoad() {
    return this.load;
  }

  public void addToLoad() {
    this.load++;
  }
  

}