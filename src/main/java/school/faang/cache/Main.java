package school.faang.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
   private static final Map<Student, Map<Subject, Integer>> students = new HashMap<>();
   private static final Map<Subject, List<Student>> subjects = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student(1, "Jack");
        Student student2 = new Student(2, "Jane");
        Student student3 = new Student(3, "Bob");
        Subject math = new Subject(1, "Math");
        Subject science = new Subject(2, "Science");
        Subject management = new Subject(3, "Management");
        Subject it = new Subject(4, "IT");

        Map<Subject, Integer> student1Grades = new HashMap<>();
        student1Grades.put(management, 3);
        student1Grades.put(math, 4);

        Map<Subject, Integer> student2Grades = new HashMap<>();
        student2Grades.put(science, 5);
        student2Grades.put(it, 4);

        StudentService service = new StudentService(students, subjects);

        service.addStudent(student1, student1Grades);
        service.addStudent(student2, student2Grades);

        service.addSubjectAndGrade(student1, science, 3);

        service.printAllStudents();
        System.out.println();

        service.removeStudent(student2);
        service.printAllStudents();


        List<Student> students = new ArrayList<>();
        students.add(student1);
        service.addSubject(it, students);

        service.addStudentToSubject(it, student3, 3);

        service.removeStudentFromSubject(math, student1);

        service.printAllStudents();
        service.printAllSubjects();
    }
}
