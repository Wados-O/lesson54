package Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsDateBase {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Student> students = new ArrayList<>();

    String command = readMenuCommand(reader);
    while (!command.equalsIgnoreCase("выход")) {
      switch (command.toLowerCase()) {
        case "добавить":
          addStudentInteractive(students);

          break;
        case "сохранить":
          saveListStudents(students);

          break;
        case "вывести":

          break;
        default:
          System.out.println(" Неизвестная команда " + command);
          break;
      }


      command = readMenuCommand(reader);
    }

  }

  private static void printMenu() {
    System.out.println("- 'Добавить' студента");
    System.out.println("- 'Сохранить' список студентов в файл");
    System.out.println("- 'Вывод' списка студентов на экран");
    System.out.println("- 'Выход' из программы");

  }
  private static String readMenuCommand(BufferedReader reader) throws IOException {
    printMenu();
    return reader.readLine();
  }
  private static void addStudentInteractive(List<Student> students){
    Student student = new Student();
    students.add(student);
    System.out.println("Добавляем студента" +student);
  }
  private static void saveListStudents(List<Student> students){
    System.out.println("Сохраняем список" + students);
  }
  private static void printStudentsList(List<Student> students){
    System.out.println("Выводим список на экран");
    for (Student s : students){
      System.out.println(s);
    }
  }
}
