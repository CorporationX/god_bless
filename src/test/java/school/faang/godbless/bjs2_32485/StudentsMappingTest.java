package school.faang.godbless.bjs2_32485;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentsMappingTest {

  private StudentsMapping studentsMapping;

  @BeforeEach
  public void init() {
    Student student1 = new Student("Petya", "IT", 2);
    Student student2 = new Student("Vanya", "Economics", 4);
    Student student3 = new Student("Ira", "IT", 1);
    studentsMapping = new StudentsMapping(List.of(student1, student2, student3));
  }

  @Test
  void testAddStudent() {
    studentsMapping.addStudent(new Student("Dasha", "Math", 3));
    assertTrue(studentsMapping.getFilteredStudents("Math", 3).isPresent());
  }

  @Test
  void testRemoveStudent() {
    studentsMapping.removeStudent("Petya", "IT", 2);
    assertTrue(studentsMapping.getFilteredStudents("IT", 2).get().isEmpty());
  }
}