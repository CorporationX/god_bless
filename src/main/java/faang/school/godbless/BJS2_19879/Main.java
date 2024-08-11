package faang.school.godbless.BJS2_19879;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Иван");
        Student student2 = new Student(2, "Максим");

        Subject math = new Subject(1, "Математика");
        Subject english = new Subject(2, "Английский язык");

        Student.addStudentWithGrades(student1, Map.of(math, 90, english, 85));
        Student.addStudentWithGrades(student2, Map.of(math, 78));

        Subject.addSubjectWithStudents(math, List.of(student1, student2));
        Subject.addSubjectWithStudents(english, List.of(student1));

        printAllStudentsAndGrades();
        printAllSubjectsAndStudents();
    }

    public static void printAllStudentsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : Student.studentGradesMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }

    public static void printAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : Subject.subjectStudentsMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }
}