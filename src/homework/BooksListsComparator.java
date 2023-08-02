package homework;

import java.util.Comparator;

public class BooksListsComparator implements Comparator<Book> {

  @Override
  public int compare(Book o1, Book o2) {
    return Integer.compare(o1.getLists(), o2.getLists());

  }
}
