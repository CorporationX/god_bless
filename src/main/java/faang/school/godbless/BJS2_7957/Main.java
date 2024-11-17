package faang.school.godbless.BJS2_7957;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  static Map<Student, Map<Subject, Integer>> students;
  static Map<Subject, List<Student>> subjects;

  public static void main(String[] args) {

  }

  public static void addStudent(Student student, Map<Subject, Integer> subject) {
    students.put(student, subject);
  }

  public static void addSubjectByStudent(Student student, Subject newSubject, int grade) {
    students.computeIfAbsent(student, s -> new HashMap<>()).put(newSubject, grade);
  }

  public static void deleteSudent(Student student) {
    students.remove(student);
  }

  public static void printAllStudentsAndSubjects() {
    for (Map.Entry<Student, Map<Subject, Integer>> entry : students.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
  }

  public static void addSubject(Subject subject, List<Student> studs) {
    subjects.put(subject, studs);
  }

  public static void addStudentBySubject(Subject subject, Student student) {
    subjects.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
  }

  public static void deleteStudentBySubject(Subject subject, Student student) {
    if (subjects.containsKey(subject)) {
      subjects.put(subject, subjects.get(subject).stream().filter(s -> !s.equals(student)).toList());
    } else {
      System.out.println("Предмет не найден");
    }
  }

  public static void printAllSubjectctsAndStudents() {
    for (Map.Entry<Subject, List<Student>> entry : subjects.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
  }
}
