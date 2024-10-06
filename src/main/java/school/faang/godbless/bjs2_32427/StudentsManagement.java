package school.faang.godbless.bjs2_32427;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsManagement {

  private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
  private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

  public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
    studentGrades.put(student, grades);
    grades.forEach((key, value) -> subjectStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student));
  }

  public Map<Subject, Integer> getStudentGrades(Student student) {
    return studentGrades.get(student);
  }

  public void addGradeForStudent(Student student, Subject subject, int grade) {
    studentGrades.computeIfAbsent(student, kye -> new HashMap<>()).put(subject, grade);
    List<Student> students = subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>());
    students.stream().filter(stud -> stud.equals(student)).findAny().orElseGet(() -> {
      students.add(student);
      return student;
    });
  }

  public boolean removeStudent(Student student) {
    if (studentGrades.containsKey(student)) {
      Map<Subject, Integer> grades = studentGrades.get(student);
      grades.forEach((key, value) -> subjectStudents.get(key).remove(student));
      return true;
    }
    return false;
  }

  public String getStudentsGradesAsString() {
    return studentGrades.toString();
  }

  public void addNewSubject(Subject subject, List<Student> students) {
    subjectStudents.put(subject, students);
  }

  public List<Student> getStudentsBySubject(Subject subject) {
    return subjectStudents.get(subject);
  }

  public void addStudentToSubject(Student student, Subject subject) {
    subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
  }

  public boolean removeStudentFromSubject(Student student, Subject subject) {
    if (subjectStudents.containsKey(subject)) {
      return subjectStudents.get(subject).remove(student);
    }
    return false;
  }

  public String getSubjectsStudentsAsString() {
    return subjectStudents.toString();
  }
}
