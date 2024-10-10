package school.faang.cash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  private static final Map<Student, Map<Subject, Integer>> STUDENT_MARKS = new HashMap<>();
  private static final Map<Subject, List<Student>> SUBJECT_STUDENTS = new HashMap<>();

  public static void main(String[] args) {

    Subject math = new Subject("M001", "Mathematics");
    Subject phys = new Subject("P001", "Physics");
    Subject culture = new Subject("C001", "Culture");

    Student ivanov = new Student("001", "Ivan Ivanov");
    Map<Subject, Integer> ivanovMarks = new HashMap<>();
    ivanovMarks.put(math, 5);
    ivanovMarks.put(phys, 3);
    addStudentWithMarks(ivanov, ivanovMarks);

    Student petrov = new Student("002", "Petr Petrov");
    Map<Subject, Integer> petrovMarks = new HashMap<>();
    petrovMarks.put(math, 5);
    petrovMarks.put(phys, 3);
    petrovMarks.put(culture, 4);
    addStudentWithMarks(petrov, petrovMarks);

    Student semenov = new Student("003", "Semen Semenov");
    Map<Subject, Integer> semenovMarks = new HashMap<>();
    semenovMarks.put(math, 5);
    semenovMarks.put(phys, 3);
    semenovMarks.put(culture, 4);
    addStudentWithMarks(semenov, semenovMarks);
    printStudentsWithMarks();

    System.out.println("IVANOV CULTURE MARK 5 ADDED");
    addStudentMark(ivanov, culture, 5);
    printStudentsWithMarks();

    System.out.println("REMOVE SEMENOV");
    removeStudentWithMarks(semenov);
    printStudentsWithMarks();

    System.out.println("ADD 2 STUDENTS TO MATH");
    List<Student> studentsMath = new ArrayList<>();
    studentsMath.add(ivanov);
    studentsMath.add(petrov);
    addSubjectWithStudents(math, studentsMath);
    printSubjectWithStudents();

    System.out.println("ADD 2 STUDENTS TO PHYS");
    List<Student> studentsPhys = new ArrayList<>();
    studentsPhys.add(ivanov);
    studentsPhys.add(petrov);
    addSubjectWithStudents(phys, studentsPhys);
    printSubjectWithStudents();

    System.out.println("ADD SEMENOV TO MATH");
    addStudentToSubject(math, semenov);
    printSubjectWithStudents();

    System.out.println("REMOVE IVANOV FROM PHYS");
    removeStudentFromSubject(phys, ivanov);
    printSubjectWithStudents();

  }

  private static void addStudentWithMarks(Student student, Map<Subject, Integer> marks) {
    STUDENT_MARKS.put(student, marks);
  }

  private static void addStudentMark(Student student, Subject subject, Integer mark) {
    Map<Subject, Integer> studentMarks = STUDENT_MARKS.get(student);
    studentMarks.put(subject, mark);
  }

  private static void removeStudentWithMarks(Student student) {
    STUDENT_MARKS.remove(student);
  }

  private static void printStudentsWithMarks() {
    System.out.println("--- PRINTING STUDENTS' MARKS ---");
    for (var studentEntry : STUDENT_MARKS.entrySet()) {
      System.out.println(studentEntry.getKey());
      for (var subjectEntry : studentEntry.getValue().entrySet()) {
        System.out.println(subjectEntry.getKey() + " : " + subjectEntry.getValue());
      }
    }
    System.out.println();
  }

  private static void addSubjectWithStudents(Subject subject, List<Student> students) {
    SUBJECT_STUDENTS.put(subject, students);
  }

  private static void addStudentToSubject(Subject subject, Student student) {
    SUBJECT_STUDENTS.get(subject).add(student);
  }

  private static void removeStudentFromSubject(Subject subject, Student student) {
    SUBJECT_STUDENTS.get(subject).remove(student);
  }

  private static void printSubjectWithStudents() {
    System.out.println("***PRINTING STUDENTS GROUPED BY SUBJECT***");
    for (var subjectEntry : SUBJECT_STUDENTS.entrySet()) {
      System.out.println(subjectEntry.getKey());
      for (var entry : subjectEntry.getValue()) {
        System.out.println(entry);
      }
    }
    System.out.println();
  }
}
