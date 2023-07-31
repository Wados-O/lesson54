package Students;

import java.io.BufferedReader;
import java.io.IOException;

public class Student {
  private String name;
  private int score;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  @Override
  public String toString() {
    return String.format("%s (%d)",name,score);
  }
  public static Student readInteractive(BufferedReader reader)
      throws IOException {
    System.out.println("Введите имя: ");
    String name = reader.readLine();
    System.out.println("Введите накопленные баллы: ");
    int score = 0;
    try {

    score =Integer.parseInt(reader.readLine());
    }catch (NumberFormatException e){
      System.out.println("Некорректный формат ввода: " + e.getMessage());
    }
    return  new Student(name,score);
  }
}
