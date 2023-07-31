import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Pizza> pizzas = new ArrayList<>();
    pizzas.add(new Pizza("A","S",3));
    pizzas.add(new Pizza("B","M",5));
    pizzas.add(new Pizza("A","SX",7));

    System.out.println("До сортировки:");
    for (Pizza p : pizzas){
      System.out.println(p);
    }
    Collections.sort(pizzas);
    System.out.println("После сортировки: ");
    for (Pizza p : pizzas){
      System.out.println(p);
    }
  }
}