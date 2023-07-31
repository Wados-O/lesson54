package Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentsDateBase {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Student> students = new ArrayList<>();

    String command = readMenuCommand(reader);
    while (!command.equalsIgnoreCase("выход")) {
      switch (command.toLowerCase()) {
        case "добавить":
          addStudentInteractive(reader,students);

          break;
        case "сохранить":
          saveListStudents(students);

          break;

        case "вывести":
          printStudentsList(reader,students);
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
  private static void addStudentInteractive(BufferedReader reader,List<Student> students)
      throws IOException {
    Student student = Student.readInteractive(reader);
    students.add(student);
    System.out.println("Добавляем студента" +student);
  }
  private static void saveListStudents(List<Student> students){
    System.out.println("Сохраняем список" + students);
  }
  private static void printStudentsList(BufferedReader reader,List<Student> students)throws IOException{
    System.out.println("Выводим список на экран");
    List<Student> toPrint = new ArrayList<>(students);
    System.out.println("Выберите режим сортировки");
    System.out.println("1.По алфавиту");
    System.out.println("2.По убыванию среднего балла");
    String mode = reader.readLine();
    switch (mode){
      case "1":
        toPrint.sort(new StudentNameComparator());
        break;
      case "2":
        toPrint.sort(new StudentScoreComparator());
        Collections.reverse(toPrint);
        break;
      default:
        System.out.println("Неизвестный режим сортировки: " + mode);
        break;
    }
    for (Student s : toPrint){
      System.out.println(s);
    }
  }
}
