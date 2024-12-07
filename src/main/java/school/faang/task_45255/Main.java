package school.faang.task_45255;

import school.faang.task_45255.entity.Student;
import school.faang.task_45255.entity.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Subject math = new Subject("Math");
        Subject science = new Subject("Science");
        Subject history = new Subject("History");


        Map<Subject, Integer> subjectMap = new HashMap<>();


        subjectMap.put(math, 5);
        subjectMap.put(science, 4);
        subjectMap.put(history, 4);
        StudentDatabase studentDatabase = new StudentDatabase();
        Student student1 = new Student("John Doe");
        studentDatabase.addStudent(student1, subjectMap);
        subjectMap.clear();
        subjectMap.put(science, 5);
        subjectMap.put(history, 5);
        Student student2 = new Student("Jane Smith");
        studentDatabase.addStudent(student2, subjectMap);
        subjectMap.clear();
        subjectMap.put(science, 5);
        Student student3 = new Student("Alice Brown");
        studentDatabase.addStudent(student3, subjectMap);
        System.out.println("\n=== All Students ===");
        studentDatabase.printStudents();
        System.out.println("\n==================    ");

        studentDatabase.addSubjectForStudent(student2, math, 4);
        studentDatabase.addSubjectForStudent(student3, math, 3);

        System.out.println("\n=== All Students ===");
        studentDatabase.printStudents();
        System.out.println("\n==================    ");
        List<Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentDatabase.addSubject(math, studentList);
        studentList.clear();
        studentList.add(student1);
        studentList.add(student3);
        studentDatabase.addSubject(science, studentList);
        studentList.clear();
        studentList.add(student3);
        studentList.add(student2);
        studentDatabase.addSubject(history, studentList);
        System.out.println("\n=== All Subjects and Students ===");
        studentDatabase.printSubjects();
        System.out.println("\n==================    ");

        studentDatabase.addStudentInSubject(science, student2);
        studentDatabase.addStudentInSubject(history, student1);

        System.out.println("\n=== All Subjects and Students ===");
        studentDatabase.printSubjects();
        System.out.println("\n==================    ");

        studentDatabase.removeStudent(student2);
        System.out.println("\n=== All Students after remove ===");
        studentDatabase.printStudents();
        studentDatabase.removeStudentFromSubject(history, student2);
        System.out.println("\n=== All Subjects after remove ===");
        studentDatabase.printSubjects();
    }
}

