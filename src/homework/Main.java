package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Book1","author1",132));
    books.add(new Book("Book2","author1",96));
    books.add(new Book("Book3","author1",12));
    books.add(new Book("Book4","author1",152));
    books.add(new Book("Book5","author1",142));
    books.add(new Book("Book6","author1",123));
    System.out.println("До сортировки:  ");
    for (Book b : books){
      System.out.println(b);
    }


  }
}
