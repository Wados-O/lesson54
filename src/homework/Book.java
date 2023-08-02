package homework;

public class Book {

  private String name;
  private String authors;
  private int lists;

  public Book(String name, String authors, int lists) {
    this.name = name;
    this.authors = authors;
    this.lists = lists;
  }

  public String getName() {
    return name;
  }

  public String getAuthors() {
    return authors;
  }

  public int getLists() {
    return lists;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAuthors(String authors) {
    this.authors = authors;
  }

  public void setLists(int lists) {
    this.lists = lists;
  }

  @Override
  public String toString() {
    return "Book{" +
        "name='" + name + '\'' +
        ", authors='" + authors + '\'' +
        ", lists=" + lists +
        '}';
  }
}
