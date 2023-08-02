package homework;

public class Book {
  private String authors;
  private String name;

  private int lists;

  public Book( String authors,String name, int lists) {

    this.authors = authors;
    this.name = name;
    this.lists = lists;
  }

  public String getAuthors() {
    return authors;
  }

  public void setAuthors(String authors) {
    this.authors = authors;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLists() {
    return lists;
  }

  public void setLists(int lists) {
    this.lists = lists;
  }

  @Override
  public String toString() {
    return "Book : " +
        " authors - " + authors + '\'' +
        ", name - " + name + '\'' +
        ", lists - " + lists +
        '|';
  }
}
