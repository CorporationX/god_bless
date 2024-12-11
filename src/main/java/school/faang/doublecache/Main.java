package school.faang.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Max");
        Student student2 = new Student("Misha");
        Student student3 = new Student("Tima");
        Student student4 = new Student("Aibo");
        Student student5 = new Student("Dima");

        Subject subject1 = new Subject("math");
        Subject subject2 = new Subject("history");
        Subject subject3 = new Subject("english");

        Map<Subject, Integer> a1Grades = new HashMap<>();
        a1Grades.put(subject1, 5);
        a1Grades.put(subject2, 4);

        Map<Subject, Integer> a2Grades = new HashMap<>();
        a2Grades.put(subject1, 4);

        Map<Subject, Integer> a3Grades = new HashMap<>();
        a3Grades.put(subject2, 3);
        a3Grades.put(subject3, 4);

        Map<Subject, Integer> a4Grades = new HashMap<>();
        a4Grades.put(subject3, 3);

        Map<Subject, Integer> a5Grades = new HashMap<>();
        a5Grades.put(subject1, 3);
        a5Grades.put(subject2, 4);
        a5Grades.put(subject3, 2);

        Map<Student, Map<Subject, Integer>> students = new HashMap<>();
        Map<Subject, List<Student>> subjects = new HashMap<>();
        StudentDatabase sd = new StudentDatabase(students, subjects);
        sd.addStudentWithGrades(student1, a1Grades);
        sd.addStudentWithGrades(student2, a2Grades);
        sd.addStudentWithGrades(student3, a3Grades);
        sd.addStudentWithGrades(student4, a4Grades);
        sd.addStudentWithGrades(student5, a5Grades);

        System.out.println("\nВывод");
        sd.printAllStudentsWithGrades();
        sd.printAllSubjectsStudents();

        System.out.println("\nУдаление студента " + student3);
        sd.removeStudent(student3);
        sd.printAllStudentsWithGrades();
        sd.printAllSubjectsStudents();

        System.out.println("\nДобавление предмета и оценкой у студента");
        sd.addSubjectForStudent(student2, subject3, 5);
        sd.printAllSubjectsStudents();

        System.out.println("\nДобавление предмета и студентов к нему");
        Subject subject4 = new Subject("Physics");
        sd.addSubjectWithStudents(subject4, new ArrayList<>());
        sd.addStudentForSubject(subject4, student1);
        sd.addStudentForSubject(subject4, student5);
        sd.printAllSubjectsStudents();

        System.out.println("\nУдаление предмета у студента");
        sd.removeStudentFromSubject(student1, subject4);
        sd.printAllStudentsWithGrades();
        sd.printAllSubjectsStudents();

    }
}
