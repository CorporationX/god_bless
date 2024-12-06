package school.faang.task45240;

import school.faang.task45240.model.Student;
import school.faang.task45240.model.Subject;
import school.faang.task45240.services.StudentDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student("Vasya");
        Student student2 = new Student("Petya");
        Student student3 = new Student("Masha");
        Student student4 = new Student("Sveta");
        Student student5 = new Student("Vova");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Map<Subject, Integer> subjects1 = new HashMap<>();
        subjects1.put(Subject.PHYSICS, 5);
        subjects1.put(Subject.HISTORY, 4);
        subjects1.put(Subject.SOCIOLOGY, 3);

        StudentDatabase university = new StudentDatabase();

        university.addStudentWithGrades(student1, subjects1);
        university.printGradedStudents();

        university.addSubjectForStudent(student4, Subject.HISTORY, 5);
        university.addSubjectForStudent(student4, Subject.MATH, 4);
        university.addSubjectForStudent(student1, Subject.HISTORY, 5);
        university.addSubjectForStudent(student1, Subject.MATH, 4);

        university.printGradedStudents();

        university.removeStudent(student1);
        university.printGradedStudents();

        university.addSubjectWithStudents(Subject.MATH, students);
        university.printStudentSubjects();

        university.addStudentToSubject(student4, Subject.HISTORY);
        university.addStudentToSubject(student5, Subject.PHYSICS);
        university.addStudentToSubject(student5, Subject.MATH);

        university.printStudentSubjects();

        university.removeStudentFromSubject(student4, Subject.HISTORY);
        university.removeStudentFromSubject(student1, Subject.MATH);
        university.removeStudentFromSubject(student5, Subject.MATH);
        university.printStudentSubjects();


    }
}
