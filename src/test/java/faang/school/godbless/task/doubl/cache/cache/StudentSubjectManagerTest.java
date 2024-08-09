package faang.school.godbless.task.doubl.cache.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentSubjectManagerTest {
    private Subject subject1 = new Subject(1, "Mathematics");
    private Subject subject2 = new Subject(2, "Physics");
    private Subject subject3 = new Subject(3, "Chemistry");
    private Subject subject4 = new Subject(4, "Biology");
    private Subject subject5 = new Subject(5, "History");
    private Subject subject6 = new Subject(6, "Geography");
    private Subject subject7 = new Subject(7, "Literature");
    private Subject subject8 = new Subject(8, "Art");
    private Subject subject9 = new Subject(9, "Music");
    private Subject subject10 = new Subject(10, "Physical Education");

    private Student student1 = new Student(1, "Mike");
    private Student student2 = new Student(2, "Bob");
    private Student student3 = new Student(3, "Nolan");

    private StudentSubjectManager studentSubjectManager;
    Map<Subject, Integer> subjectIntegerMap1;
    Map<Subject, Integer> subjectIntegerMap2;
    List<Student> studentsList;

    @BeforeEach
    void setUp() {
        studentSubjectManager = new StudentSubjectManager(new HashMap<>(), new HashMap<>());
        subjectIntegerMap1 = new HashMap<>(Map.of(
                subject1, 5,
                subject2, 3,
                subject3, 4,
                subject4, 5
        ));
        subjectIntegerMap2 = new HashMap<>(Map.of(
                subject5, 5,
                subject6, 3,
                subject7, 4,
                subject8, 5
        ));
        studentsList = new ArrayList<>(List.of(student1, student2));
    }

    @Test
    @DisplayName("Add new student and courses grades")
    void testAddNewStudentAndCoursesGrades() {
        System.out.println("Add new student and courses grades");
        studentSubjectManager.addNewStudentAndCoursesGrades(student1, subjectIntegerMap1);
        studentSubjectManager.printAllStudentsAndGraduateOfSubjects();
    }

    @Test
    @DisplayName("Add subject and grade into existing student")
    void testAddSubjectAndGradeIntoExistingStudent() {
        System.out.println("Add subject and grade into existing student");
        studentSubjectManager.addNewStudentAndCoursesGrades(student1, subjectIntegerMap1);
        studentSubjectManager.addSubjectAndGradeIntoExistingStudent(student1, subject10, 5);
        studentSubjectManager.printAllStudentsAndGraduateOfSubjects();
    }

    @Test
    @DisplayName("Delete student and subjects with graduate")
    void testDeleteStudentAndSubjectsWithGraduate() {
        System.out.println("Delete student and subjects with graduate");
        studentSubjectManager.addNewStudentAndCoursesGrades(student1, subjectIntegerMap1);
        studentSubjectManager.deleteStudentAndSubjectsWithGraduate(student1);
        studentSubjectManager.printAllStudentsAndGraduateOfSubjects();
    }

    @Test
    @DisplayName("Print all students and graduate of subjects")
    void testPrintAllStudentsAndGraduateOfSubjects() {
        System.out.println("Print all students and graduate of subjects");
        studentSubjectManager.addNewStudentAndCoursesGrades(student1, subjectIntegerMap1);
        studentSubjectManager.addNewStudentAndCoursesGrades(student2, subjectIntegerMap2);
        studentSubjectManager.printAllStudentsAndGraduateOfSubjects();
    }

    @Test
    @DisplayName("Add new subject and students list")
    void testAddNewSubjectAndStudentsList() {
        System.out.println("Add new subject and students list");
        studentSubjectManager.addNewSubjectAndStudentsList(subject1, studentsList);
        studentSubjectManager.printAllSubjectsAndStudents();
    }

    @Test
    @DisplayName("Add student into existing subject")
    void testAddStudentIntoExistingSubject() {
        System.out.println("Add student into existing subject");
        studentSubjectManager.addNewSubjectAndStudentsList(subject1, studentsList);
        studentSubjectManager.addStudentIntoExistingSubject(subject1, student3);
        studentSubjectManager.printAllSubjectsAndStudents();
    }

    @Test
    @DisplayName("Delete student in subject and students list")
    void testDeleteStudentInSubjectAndStudentsList() {
        System.out.println("Delete student in subject and students list");
        studentSubjectManager.addNewSubjectAndStudentsList(subject1, studentsList);
        studentSubjectManager.deleteStudentInSubjectAndStudentsList(subject1, student1);
        studentSubjectManager.printAllSubjectsAndStudents();
    }

    @Test
    @DisplayName("Print all subjects and students")
    void testPrintAllSubjectsAndStudents() {
        System.out.println("Print all subjects and students");
        studentSubjectManager.addNewSubjectAndStudentsList(subject1, studentsList);
        studentSubjectManager.addNewSubjectAndStudentsList(subject6, List.of(student1, student2, student3));
        studentSubjectManager.printAllSubjectsAndStudents();
    }
}
