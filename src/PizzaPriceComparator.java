import java.util.Comparator;

public class PizzaPriceComparator implements Comparator<Pizza> {

  @Override
  public int compare(Pizza o1, Pizza o2) {
    return Double.compare(o1.getPrice(), o2.getPrice());
  }
}
