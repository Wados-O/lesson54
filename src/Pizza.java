import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Pizza implements Comparable<Pizza> {

  private final String name;
  private final String size;
  private final double price;

  public Pizza(String name, String size, double price) {
    this.name = name;
    this.size = size;
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Pizza{" +
        "name='" + name + '\'' +
        ", size='" + size + '\'' +
        ", price=" + price +
        '}';
  }

  @Override
  public int compareTo(Pizza o) {

    if (!name.equals(o.name)) {
      return name.compareTo(o.name);
    }
    if (!size.equals(o.size)) {
      return name.compareTo(o.size);
    }

    return Double.compare(price, o.price);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Pizza other)) {
      return false;
    }
    return price == other.price &&
        name.equals(other.name) &&
        size.equals(other.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, size, price);
  }
}