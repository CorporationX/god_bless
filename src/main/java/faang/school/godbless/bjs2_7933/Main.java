package faang.school.godbless.bjs2_7933;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  private static final String STUDENT = "Студент - ";
  private static final String STUDENT_SUBJECTS = "Предметы студента: ";
  private static final String SUBJECT_SCORE = "оценка - ";
  private static final String SEPARATOR = " ";
  private static final String SUBJECT = "Предмет - ";
  private static final String STUDENT_STUDYING_SUBJECT = "Студенты, которые изучают предмет - ";


  private static final Map<Student, Map<Subject, Integer>> studentsWithSubjectsMap = new HashMap<>();
  private static final Map<Subject, List<Student>> subjectsWithStudentsMap = new HashMap<>();

  public static void main(String[] args) {

    Subject math = new Subject(1, "Математика");
    Subject programming = new Subject(2, "Программирование");
    Subject algorithms = new Subject(3, "Алгоритмы");
    Subject oop = new Subject(4, "ООП");
    Subject programmingPatterns = new Subject(5, "Паттерны программирования");
    Subject bio = new Subject(6, "Биология");
    Subject chemistry = new Subject(6, "Химия");

    Student pasha = new Student(1, "Паша");
    Student sasha = new Student(2, "Саша");
    Student masha = new Student(3, "Маша");
    Student nika = new Student(4, "Ника");

    addStudentWithSubject(pasha, new HashMap<>(Map.of(math, 5, programming, 4, algorithms, 4)));
    addStudentWithSubject(sasha, new HashMap<>(Map.of(programming, 5, programmingPatterns, 5, math, 4)));
    addStudentWithSubject(masha, new HashMap<>(Map.of(algorithms, 5, oop, 5, math, 3)));
    addStudentWithSubject(nika, new HashMap<>(Map.of(bio, 5, chemistry, 5)));

    addSubjectForStudent(pasha, oop, 4);
    addSubjectForStudent(sasha, oop, 5);
    addSubjectForStudent(masha, programming, 4);
    addSubjectForStudent(masha, bio, 3);

    deleteStudentWithSubject(nika);
    deleteStudentWithSubject(new Student(8, "Привет"));

    showAllStudentWithSubject();

    addSubjectAndStudent(math, new ArrayList<>(List.of(pasha, sasha, masha)));
    addSubjectAndStudent(programming, new ArrayList<>(List.of(pasha, sasha, masha)));
    addSubjectAndStudent(algorithms, new ArrayList<>(List.of(pasha, masha)));
    addSubjectAndStudent(oop, new ArrayList<>(List.of(pasha, sasha, masha)));
    addSubjectAndStudent(programmingPatterns, new ArrayList<>(List.of(sasha)));
    addSubjectAndStudent(bio, new ArrayList<>(List.of(nika)));
    addSubjectAndStudent(chemistry, new ArrayList<>(List.of(nika)));

    addStudentForSubject(bio, masha);

    deleteStudentFromSubject(bio, masha);

    showAllSubjectWithStudent();

  }

  private static void addStudentWithSubject(Student student, Map<Subject, Integer> subjects) {
    studentsWithSubjectsMap.put(student, subjects);
  }

  private static void addSubjectForStudent(Student student, Subject subject, int score) {
    studentsWithSubjectsMap.computeIfAbsent(student, key -> new HashMap<>()).put(subject, score);
  }

  private static void deleteStudentWithSubject(Student student) {
    studentsWithSubjectsMap.remove(student);
  }

  private static void showAllStudentWithSubject() {
    studentsWithSubjectsMap.forEach((key, value) -> {
      System.out.println(STUDENT + key.name() + SEPARATOR + STUDENT_SUBJECTS);
      value.forEach((subjectKey, subjectValue) -> System.out.println(subjectKey.name() +
          SEPARATOR + SUBJECT_SCORE + subjectValue));
    });
  }

  private static void addSubjectAndStudent(Subject subject, List<Student> students) {
    subjectsWithStudentsMap.put(subject, students);
  }

  private static void addStudentForSubject(Subject subject, Student student) {
    subjectsWithStudentsMap.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
  }

  private static void deleteStudentFromSubject(Subject subject, Student student) {
    if (subjectsWithStudentsMap.containsKey(subject)) {
      studentsWithSubjectsMap.get(subject).remove(student);
    }
  }

  private static void showAllSubjectWithStudent() {
    subjectsWithStudentsMap.forEach((key, value) -> {
      System.out.println(SUBJECT + key.name() + SEPARATOR + STUDENT_STUDYING_SUBJECT);
      value.forEach(student -> System.out.println(STUDENT + student.name()));
    });
  }

}
