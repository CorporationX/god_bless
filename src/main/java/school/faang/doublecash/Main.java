package school.faang.doublecash;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentService studentService;
        SubjectService subjectService;

        StudentDatabase database = new StudentDatabase();
        studentService = new StudentService(database);
        subjectService = new SubjectService(database);

        Student student1;
        Student student2;

        student1 = new Student("Петя");
        student2 = new Student("Иван");

        Subject math = new Subject("Математика");
        Subject history = new Subject("История");

        Map<Subject, Integer> student1Subjects = new HashMap<>();
        student1Subjects.put(math, 5);
        studentService.addStudent(student1, student1Subjects);

        Map<Subject, Integer> student2Subjects = new HashMap<>();
        student2Subjects.put(history, 4);
        studentService.addStudent(student2, student2Subjects);

        List<Student> allStudents = Arrays.asList(student1, student2);
        subjectService.addSubject(history, allStudents, 3);

        studentService.printStudents();
        subjectService.printAllSubjectsAndStudents();
    }
}