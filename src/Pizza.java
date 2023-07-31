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
    // метод compareTo сравнивает текущий объект (this) с аргументом (o - object - other)
    // если this < o, то метод должен вернуть любое отрицательное число - ответ < 0
    // если this = o, то метод должен вернуть 0                         - ответ = 0
    // если this > o, то метод должен вернуть любое положительное число - ответ > 0
    // a < b  -->  a - b < b - b  -->  a - b < 0
    // a = b  -->  a - b = b - b  -->  a - b = 0
    // a > b  -->  a - b > b - b  -->  a - b > 0
    // метод compareTo устроен так, чтобы возвращать разницу (this - o)
    // если сравнение объектов можно превратить в сравнение чисел (есть метрика), то такие числа
    //   иногда называют ключом сравнения (comparison key)

    // если в числа превратить нельзя или сложно:
    // если названия разные, то по названиям
    if (!name.equals(o.name)) { // (compareTo != 0) --> названия не равны (разные)
      return name.compareTo(o.name); // по названиям
    }
    if (!size.equals(o.size)) {
      return name.compareTo(o.size);
    }
    // если названия одинаковые, то по цене
    // (double - double) нельзя превращать в int - потеряется дробная часть
//    return (int) Math.signum(price - o.price); // знак числа (отриц. в -1.0, полож. +1.0)
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