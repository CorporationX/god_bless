package school.faang.bjs2_68874;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentDatabaseTest {
    private StudentDatabase studentDatabase;
    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
        student1 = new Student("Петя");
        student2 = new Student("Дима");
        subject1 = new Subject("Математика");
        subject2 = new Subject("Физика");
    }

    @Test
    void testAddStudent() {
        Map<Subject, Integer> subjectsWithMarks = new HashMap<>();
        subjectsWithMarks.put(subject1, 5);
        subjectsWithMarks.put(subject2, 3);

        studentDatabase.addStudent(student1, subjectsWithMarks);

        // Проверяем, что студент добавлен в базу данных
        assertTrue(studentDatabase.studentSubjects.containsKey(student1));
        assertEquals(5, studentDatabase.studentSubjects.get(student1).get(subject1));
        assertEquals(3, studentDatabase.studentSubjects.get(student1).get(subject2));

        // Проверяем, что предметы связаны со студентом
        assertTrue(studentDatabase.subjectStudents.get(subject1).contains(student1));
        assertTrue(studentDatabase.subjectStudents.get(subject2).contains(student1));
    }

    @Test
    void testAddSubject() {
        Map<Subject, Integer> subjectsWithMarks = new HashMap<>();
        subjectsWithMarks.put(subject1, 5);
        subjectsWithMarks.put(subject2, 3);
        //добавляем одного студента
        studentDatabase.addStudent(student1, subjectsWithMarks);

        List<Student> students = List.of(student1, student2);
        //добавляем предмет существующему (student1) и несуществующему (student2) студентам
        studentDatabase.addSubject(subject1, students);

        // Проверяем, что предмет связан с существующим студентом (student1)
        assertTrue(studentDatabase.subjectStudents.get(subject1).contains(student1));
        // Проверяем что предмет не связан с несуществующим студентом (student2)
        assertFalse(studentDatabase.subjectStudents.get(subject1).contains(student2));

        // Проверяем, что существующий студент связан с предметом
        assertTrue(studentDatabase.studentSubjects.get(student1).containsKey(subject1));
        //проверяем что в базе студентов нет несуществующего студента (student2)
        assertNull(studentDatabase.studentSubjects.get(student2));
    }

    @Test
    void testRemoveStudent() {
        Map<Subject, Integer> subjectsWithMarks = new HashMap<>();
        subjectsWithMarks.put(subject1, 5);
        studentDatabase.addStudent(student1, subjectsWithMarks);
        studentDatabase.addStudent(student2, subjectsWithMarks);

        studentDatabase.removeStudent(student1);

        // Проверяем, что студент1 удален из базы данных
        assertFalse(studentDatabase.studentSubjects.containsKey(student1));
        assertFalse(studentDatabase.subjectStudents.get(subject1).contains(student1));

        // Проверяем, что студент2 остался на месте
        assertTrue(studentDatabase.studentSubjects.containsKey(student2));
        assertTrue(studentDatabase.subjectStudents.get(subject1).contains(student2));
    }

    @Test
    void testRemoveStudentFromSubject() {
        Map<Subject, Integer> subjectsWithMarks = new HashMap<>();
        subjectsWithMarks.put(subject1, 5);
        subjectsWithMarks.put(subject2, 5);
        studentDatabase.addStudent(student1, subjectsWithMarks);

        studentDatabase.removeStudentFromSubject(student1, subject1);

        // Проверяем, что студент удален из предмета1
        assertFalse(studentDatabase.studentSubjects.get(student1).containsKey(subject1));
        assertFalse(studentDatabase.subjectStudents.get(subject1).contains(student1));

        // Проверяем, что студент остался в предмете1
        assertTrue(studentDatabase.studentSubjects.get(student1).containsKey(subject2));
        assertTrue(studentDatabase.subjectStudents.get(subject2).contains(student1));
    }
}
