package homework;

import java.util.Comparator;
import java.util.Objects;

public class AuthorsBookComparator implements Comparator<Book>{

  @Override
  public int compare(Book o1, Book o2) {
    if (Objects.equals(o1.getAuthors(), o2.getAuthors())){
      return o1.getName().compareTo(o2.getName());
    }
    return o1.getAuthors().compareTo(o2.getAuthors());
  }
}
