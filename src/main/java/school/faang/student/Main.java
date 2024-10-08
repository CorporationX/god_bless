package school.faang.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  private static final List<Student> STUDENTS = new ArrayList<>();

  public static void main(String[] args) {
    addStudent("Petrov", "math", 2019);
    addStudent("Ivanov", "phyl", 2022);
    addStudent("Sidorov", "math", 2019);
    addStudent("Semenov", "phys", 2021);
    addStudent("Rublev", "phys", 2021);
    addStudent("Babin", "phyl", 2022);
    addStudent("Filatov", "math", 2019);

    printByCourse(studentsByCourse(STUDENTS));
    System.out.println("---------------");
    removeStudent("Filatov", "math", 2019);
    removeStudent("Semenov", "phys", 2021);
    printByCourse(studentsByCourse(STUDENTS));

    System.out.println(findStudents("math", 2019));
    System.out.println(findStudents("phys", 2021));

  }

  private static Map<Course, List<Student>> studentsByCourse(List<Student> students) {
    Map<Course, List<Student>> groups = new HashMap<>();
    for (Student student : students) {
      Course course = new Course(student.getFaculty(), student.getYear());
      List<Student> studentList = groups.computeIfAbsent(course, k -> new ArrayList<>());
      studentList.add(student);
    }
    return groups;
  }

  private static void addStudent(String name, String faculty, int year) {
    STUDENTS.add(new Student(name, faculty, year));
  }

  private static void removeStudent(String name, String faculty, int year) {
    STUDENTS.remove(new Student(name, faculty, year));
  }

  private static List<Student> findStudents(String faculty, int year) {
    return studentsByCourse(STUDENTS).get(new Course(faculty, year));
  }

  private static void printByCourse(Map<Course, List<Student>> groups) {
    for (Map.Entry<Course, List<Student>> entry : groups.entrySet()) {
      List<Student> students = entry.getValue();
      for (Student student : students) {
        System.out.println(student);
      }
    }
  }

}
