package school.faang.BJS232383;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();
    static Map<Subject, List<Student>> subjectMap = new HashMap<>();

    static void addStudentAndSubject(Student student, Subject subject, int assessments) {
        studentMap.computeIfAbsent(student, sub -> new HashMap<>()).put(subject, assessments);
        subjectMap.computeIfAbsent(subject, sub -> new ArrayList<>()).add(student);
    }

    static void deleteStudent(Student student) {
        studentMap.remove(student);
    }

    static void showAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> mapEntry : studentMap.entrySet()) {
            System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
        }
    }

    static void addNewSubjectWithStudents(Subject subject, List<Student> students) {
        subjectMap.put(subject, students);
    }

    static void deleteStudentFromSubject(Student student, Subject subject) {
        subjectMap.get(subject).remove(student);
        if (subjectMap.get(subject).isEmpty()) {
            subjectMap.remove(subject);
        }
    }

    static void showAllSubjects() {
        for (Map.Entry<Subject, List<Student>> mapEntry : subjectMap.entrySet()) {
            System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
        }
    }

    public static void main(String[] args) {
        Student alex = new Student(1, "Alex");
        Student slava = new Student(2, "Slava");
        Student richard = new Student(3, "Richard");
        Student penelopa = new Student(4, "Penelopa");

        Subject math = new Subject(101, "Mathematics");
        Subject chemistry = new Subject(102, "Chemistry");
        Subject cs = new Subject(103, "Computer Science");
        Subject english = new Subject(104, "English");

        addStudentAndSubject(alex, math, 4);
        addStudentAndSubject(alex, chemistry, 5);
        addStudentAndSubject(alex, english, 3);
        addStudentAndSubject(slava, cs, 5);
        addStudentAndSubject(slava, math, 5);
        addStudentAndSubject(richard, english, 4);
        addStudentAndSubject(richard, chemistry, 3);
        addStudentAndSubject(penelopa, english, 5);

        showAllStudents();

        addNewSubjectWithStudents(new Subject(106, "History"), List.of(slava, penelopa, richard));
        showAllSubjects();
        deleteStudent(slava);
        showAllStudents();
        deleteStudentFromSubject(alex, math);
        showAllStudents();
    }
}
