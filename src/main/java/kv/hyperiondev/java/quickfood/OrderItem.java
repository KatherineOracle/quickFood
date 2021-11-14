package kv.hyperiondev.java.quickfood;

public class OrderItem {

  // properties
  private String meal;
  private double price;
  private int quantity;

  // constructor
  public OrderItem(String meal, double price, int quantity) {
    this.meal = meal;
    this.price = price;
    this.quantity = quantity;
  }

  // return the ordered item as string to invoice object and to the GUI
  public String toString() {
    return this.quantity + " x " + this.meal +
      " (R" + String.format("%.2f", this.price) + ") \n";
  }

  // invoice will use getters below to calculate the total
  public double getPrice() {
    return this.price;
  }

  public int getQuantity() {
    return this.quantity;
  }

}