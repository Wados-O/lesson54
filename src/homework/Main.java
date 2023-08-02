package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Book1","author1",132));
    books.add(new Book("Book2","author1",96));
    books.add(new Book("Book3","author3",12));
    books.add(new Book("Book4","author2",152));
    books.add(new Book("Book5","author2",142));
    books.add(new Book("Book6","author3",123));
    System.out.println("До сортировки:  ");
    for (Book b : books){
      System.out.println(b);
    }
    books.sort(new BooksListsComparator());
    System.out.println("После сортировки по количеству страниц!!! ");
    for (Book b : books){
      System.out.println(b);
    }

  }
}
