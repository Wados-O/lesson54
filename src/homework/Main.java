package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  /**
   * Создайте класс Book (книга),
   * в конструктор которого передавайте автора, название книги и количество страниц.
   *
   * Реализуйте интерфейс для сравнения книг: они должны сортироваться по авторам,
   * а если авторы совпадают - по названиям (и там, и там - по алфавиту, "в словарном порядке"),
   * а если и авторы совпадают - по количеству страниц (по возрастанию).
   * @param args
   */

  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();
    books.add(new Book("author1","Book1",132));
    books.add(new Book("author1","Book2",96));
    books.add(new Book("author3","Book3",12));
    books.add(new Book("author2","Book4",152));
    books.add(new Book("author2","Book5",142));
    books.add(new Book("author3","Book6",123));
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
