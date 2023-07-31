import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Pizza implements Comparable<Pizza> {
  // интерфейс Comparable<Класс> говорит, что объекты этого класса (и наследников) можно сравнивать
  // В этом интерфейсе обязательно нужно реализовать метод `compareTo()`

  private static final String SEP = ",";
  // Map<НазваниеПиццы, Map<Размер, Стоимость>>
  private static final Map<String, Map<String, Double>> prices = readFromCsv("res/pizzas.csv");

  private final String name;
  private final String size;
  private final double price;

  public Pizza(String name, String size) {
    if (!prices.containsKey(name)) {
      throw new IllegalArgumentException("Некорректное название пиццы: " + name);
    }
    this.name = name;
    Map<String, Double> sizeToPrice = prices.get(name); // стоимость в зависимости от размера
    if (!sizeToPrice.containsKey(size)) {
      throw new IllegalArgumentException("Некорректный размер: " + size);
    }
    this.size = size;
    price = sizeToPrice.get(size);
  }

  private static String readValueFromSet(Scanner scanner, Set<String> values, String title) {
    System.out.println("Выберите " + title + ":");
    for (String name : values) {
      System.out.println("- " + name);
    }
    System.out.print("Введите " + title + ": ");
    String value = scanner.nextLine();
    while (!values.contains(value)) {
      System.out.println("Некорректное " + title + " пиццы: " + value);
      System.out.print("Введите " + title + ": ");
      value = scanner.nextLine();
    }
    return value;
  }

  // фабричный метод, прочитает параметры пиццы в интерактивном режиме
  public static Pizza readInteractive(Scanner scanner) {
    String name = readValueFromSet(scanner, prices.keySet(), "название");
    String size = readValueFromSet(scanner, prices.get(name).keySet(), "размер");
    return new Pizza(name, size);
  }

  private static Map<String, Map<String, Double>> readFromCsv(String filename) {
    // CSV - comma separated values - значения, разделённые запятыми -
    // самый простой формат таблиц.
    Map<String, Map<String, Double>> result = new HashMap<>();
    File pizzasFile = new File(filename);
    try {
      Scanner scanner = new Scanner(pizzasFile);
      while (scanner.hasNextLine()) {
        // line = "Capricciosa,Small,7.5"
        String line = scanner.nextLine();
        // cells = ["Capricciosa", "Small", "7.5"]
        String[] cells = line.split(SEP);
        try {
          // pizza = "Capricciosa"
          String pizza = cells[0];
          // size = "Small"
          String size = cells[1];
          // price = Double.parseDouble("7.5") = 7.5
          double price = Double.parseDouble(cells[2]);
          if (!result.containsKey(pizza)) { // пицца встретилась первый раз
            result.put(pizza, new HashMap<>()); // кладём ей пока пустой словарь "размер-цена"
          }
          // теперь словарь "размер-цена" для пиццы точно есть в нашем словаре
          result.get(pizza).put(size, price);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
          System.out.println("Некорректная строка файла: " + line);
        }
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Не найден файл: " + e);
    }
    return result;
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
    // если названия одинаковые, то по цене
    // (double - double) нельзя превращать в int - потеряется дробная часть
//    return (int) Math.signum(price - o.price); // знак числа (отриц. в -1.0, полож. +1.0)
    return Double.compare(price, o.price);
  }

  // определение метода compareTo() должно приводить к переопределению метода equals()
  // переопределение метода equals() должно приводить к переопределению метода hashCode()
  // эти три метода должны быть консистентными - вести себя одинаково
}