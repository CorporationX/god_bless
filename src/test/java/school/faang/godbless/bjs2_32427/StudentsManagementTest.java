package school.faang.godbless.bjs2_32427;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentsManagementTest {

  private StudentsManagement management;

  @BeforeEach
  public void init() {
    management = new StudentsManagement();
  }

  @Test
  void testAddStudentWithGrades() {
    Student student = new Student(1, "Luke");
    Subject math = new Subject(1, "Math");
    Subject physics = new Subject(2, "Physics");
    Map<Subject, Integer> grades = new HashMap<>();
    grades.put(math, 5);
    grades.put(physics, 3);
    management.addStudentWithGrades(student, grades);

    Map<Subject, Integer> actual = management.getStudentGrades(student);

    assertEquals(2, actual.size());
  }

  @Test
  void testAddGradeForStudent() {
    Student student = new Student(1, "Luke");
    Subject math = new Subject(1, "Math");
    management.addGradeForStudent(student, math, 5);

    Map<Subject, Integer> actual = management.getStudentGrades(student);

    assertEquals(1, actual.size());
  }

  @Test
  void testRemoveExistingStudent() {
    Student student = new Student(1, "Luke");
    Subject math = new Subject(1, "Math");
    Subject physics = new Subject(2, "Physics");
    Map<Subject, Integer> grades = new HashMap<>();
    grades.put(math, 5);
    grades.put(physics, 3);
    management.addStudentWithGrades(student, grades);

    assertTrue(management.removeStudent(student));
  }

  @Test
  void testRemoveNonExistingStudent() {
    Student student = new Student(1, "Luke");

    assertFalse(management.removeStudent(student));
  }

  @Test
  void testAddNewSubject() {
    List<Student> students = List.of(new Student(1, "Luke"));
    Subject math = new Subject(1, "Math");

    management.addNewSubject(math, students);
    List<Student> actual = management.getStudentsBySubject(math);

    assertEquals(1, actual.size());
  }

  @Test
  void testAddStudentToSubject() {
    Student student = new Student(1, "Luke");
    Subject math = new Subject(1, "Math");

    management.addStudentToSubject(student, math);
    List<Student> actual = management.getStudentsBySubject(math);

    assertEquals(1, actual.size());
  }

  @Test
  void testRemoveStudentFromSubject() {
    Student student = new Student(1, "Luke");
    Subject math = new Subject(1, "Math");
    management.addStudentToSubject(student, math);

    assertTrue(management.removeStudentFromSubject(student, math));
  }
}