package faang.school.godbless.BJS2_8156;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  static List<Student> students = new ArrayList<>();

  public static void main(String[] args) {
    students.add(new Student("1", "1", 1));
    students.add(new Student("2", "2", 2));
    students.add(new Student("3", "3", 3));

    System.out.println(students);
    addStudent(new Student("4", "2", 2));
    System.out.println(students);
    System.out.println(getMapStudents(students));
    deleteStudent("1", "1", 1);
    System.out.println(students);
    System.out.println(getStudentsByFacultyAndYear("2", 2));
    printStudentsByFacultyAndYear();
  }

  public static Map<String, List<Student>> getMapStudents(List<Student> students) {
    Map<String, List<Student>> result = new HashMap<>();
    for (Student student : students) {
      result.computeIfAbsent(student.getFaculty() + " - " + student.getYear(), s -> new ArrayList<>()).add(student);
    }
    return result;
  }

  public static void addStudent(Student student) {
    students.add(student);
  }

  public static void deleteStudent(String name, String faculty, int year) {
    students.remove(new Student(name, faculty, year));
  }

  public static List<Student> getStudentsByFacultyAndYear(String faculty, int year) {
    return students.stream().filter(s -> s.getFaculty().equals(faculty) && s.getYear() == year).toList();
  }

  public static void printStudentsByFacultyAndYear() {
    for (Map.Entry<String, List<Student>> entry : getMapStudents(students).entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}
