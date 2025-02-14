package school.faang.BJS2_57045;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final StudentDatabase db = new StudentDatabase();

        final Student student1 = new Student("Ivan");
        final Student student2 = new Student("Petya");
        final Student student3 = new Student("Mike");
        final Subject subject1 = new Subject("Math");
        final Subject subject2 = new Subject("English");

        Map<Subject, Integer> gradle1 = new HashMap<>();
        gradle1.put(subject1, 5);
        gradle1.put(subject2, 3);

        Map<Subject, Integer> gradle2 = new HashMap<>();
        gradle2.put(subject2, 4);
        gradle2.put(subject1, 2);

        Map<Subject, Integer> gradle3 = new HashMap<>();
        gradle3.put(subject1, 1);
        gradle3.put(subject2, 1);

        db.addStudent(student1, gradle1);
        db.addStudent(student2, gradle2);
        db.addStudent(student3, gradle3);

        db.printStudentsWithGrade();

        db.removeStudent(student1);
        db.printStudentsWithGrade();

        Subject subject3 = new Subject("Biology");
        db.addSubjectToStudent(subject3, student3, 4);
        db.printStudentsWithGrade();

        List<Student> students = new ArrayList<>();
        students.add(student2);
        students.add(student3);

        Subject subject4 = new Subject("Physics");
        db.addSubjectFromStudent(subject4, students);
        db.printSubjectsWithStudents();

        Student s4 = new Student("Valeria");
        db.addStudentFromSubject(s4, subject4, 4);
        db.printStudentsWithGrade();

        db.removeStudentFromSubject(student3, subject2);
        db.printSubjectsWithStudents();

        db.printStudentsWithGrade();
    }
}
