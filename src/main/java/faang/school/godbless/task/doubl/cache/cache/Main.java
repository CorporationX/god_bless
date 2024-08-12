package faang.school.godbless.task.doubl.cache.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Subject subject1 = new Subject(1L, "Mathematics");
        Subject subject2 = new Subject(2L, "Physics");
        Subject subject3 = new Subject(3L, "Chemistry");
        Subject subject4 = new Subject(4L, "Biology");
        Subject subject5 = new Subject(5L, "History");
        Subject subject6 = new Subject(6L, "Geography");
        Subject subject7 = new Subject(7L, "Literature");
        Subject subject8 = new Subject(8L, "Art");
        Subject subject9 = new Subject(9L, "Music");
        Subject subject10 = new Subject(10L, "Physical Education");

        Student student1 = new Student(1L, "Mike");
        Student student2 = new Student(2L, "Bob");
        Student student3 = new Student(3L, "Nolan");

        StudentSubjectManager studentSubjectManager = new StudentSubjectManager(new HashMap<>(), new HashMap<>());
        Map<Subject, Integer> subjectIntegerMap1 = new HashMap<>(Map.of(
                subject1, 5,
                subject2, 3,
                subject3, 4,
                subject4, 5
        ));
        Map<Subject, Integer> subjectIntegerMap2 = new HashMap<>(Map.of(
                subject5, 5,
                subject6, 3,
                subject7, 4,
                subject8, 5
        ));
        List<Student> studentsList = new ArrayList<>(List.of(student1, student2));

        System.out.println("\nAdd new student and courses grades");
        studentSubjectManager.addNewStudentAndCoursesGrades(student1, subjectIntegerMap1);
        studentSubjectManager.printAllStudentsAndGraduateOfSubjects();

        System.out.println("\nAdd subject and grade into existing student");
        studentSubjectManager.addNewStudentAndCoursesGrades(student1, subjectIntegerMap1);
        studentSubjectManager.addSubjectAndGradeIntoExistingStudent(student1, subject10, 5);
        studentSubjectManager.printAllStudentsAndGraduateOfSubjects();

        System.out.println("\nDelete student and subjects with graduate");
        studentSubjectManager.addNewStudentAndCoursesGrades(student1, subjectIntegerMap1);
        studentSubjectManager.deleteStudentAndSubjectsWithGraduate(student1);
        studentSubjectManager.printAllStudentsAndGraduateOfSubjects();

        System.out.println("\nPrint all students and graduate of subjects");
        studentSubjectManager.addNewStudentAndCoursesGrades(student1, subjectIntegerMap1);
        studentSubjectManager.addNewStudentAndCoursesGrades(student2, subjectIntegerMap2);
        studentSubjectManager.printAllStudentsAndGraduateOfSubjects();

        System.out.println("\nAdd new subject and students list");
        studentSubjectManager.addNewSubjectAndStudentsList(subject1, studentsList);
        studentSubjectManager.printAllSubjectsAndStudents();

        System.out.println("\nAdd student into existing subject");
        studentSubjectManager.addNewSubjectAndStudentsList(subject1, studentsList);
        studentSubjectManager.addStudentIntoExistingSubject(subject1, student3);
        studentSubjectManager.printAllSubjectsAndStudents();

        System.out.println("\nDelete student in subject and students list");
        studentSubjectManager.addNewSubjectAndStudentsList(subject1, studentsList);
        studentSubjectManager.deleteStudentInSubjectAndStudentsList(subject1, student1);
        studentSubjectManager.printAllSubjectsAndStudents();

        System.out.println("\nPrint all subjects and students");
        studentSubjectManager.addNewSubjectAndStudentsList(subject1, studentsList);
        studentSubjectManager.addNewSubjectAndStudentsList(subject6, List.of(student1, student2, student3));
        studentSubjectManager.printAllSubjectsAndStudents();
    }
}
