package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  private static List<Student> students = new ArrayList<>();
  public static void main(String[] args) {
    students.add(new Student("name", "faculty2", "year2"));
    students.add(new Student("name1", "faculty1", "year1"));
    students.add(new Student("name2", "faculty2", "year2"));
    addStudent(new Student("name3", "faculty3", "year3"));
    Map<String, List<Student>> res = gropingStudentsByFacultyAndYear();
    List<Student> studentsByFacultyAndYear = findByFacultyAndYear("faculty2", "year2");
    deleteStudent("name3", "faculty3", "year3");

  }

  public static Map<String, List<Student>> gropingStudentsByFacultyAndYear() {
    HashMap<String, List<Student>> result = new HashMap<>();
    for (Student student : students) {
      result.computeIfAbsent(student.getFaculty() + "_" + student.getYear(), k -> new ArrayList<>())
        .add(student);
    }
    return result;
  }
  public static void addStudent(Student student) {
    students.add(student);
  }
  public static void deleteStudent(String name, String faculty, String year) {
    students.remove(new Student(name, faculty, year));
  }
  public static List<Student> findByFacultyAndYear(String faculty, String year) {
    return students.stream().filter(s -> s.getFaculty().equals(faculty) && s.getYear().equals(year)).collect(Collectors.toList());
  }
}
