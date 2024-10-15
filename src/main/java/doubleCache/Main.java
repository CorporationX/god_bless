package doubleCache;

import java.util.*;

public class Main {
    private static Map<Student, Grade> gradesByStudent = new HashMap<>();
    private static Map<Subject, List<Student>> studentsBySubject = new HashMap<>();

    public static void main(String[] args) {
        addStudentWithSubjects(new Student(1, "Fragger"), new Subject(1, "Math"), 2);
        addStudentWithSubjects(new Student(2, "Antony"), new Subject(2, "Economics"), 4);
        addStudentWithSubjects(new Student(3, "Chopper"), new Subject(3, "CS"), 5);
        addStudentWithSubjects(new Student(3, "Chopper"), new Subject(4, "Literature"), 3);

        List<Student> students = new ArrayList<>();

        for (Map.Entry<Student, Grade> entry : gradesByStudent.entrySet()) {
            students.add(entry.getKey());
        }

        addSubjectWithStudents(new Subject(1, "Math"), students);

        removeStudentWithSubjects(new Student(2, "Antony"));

        printAllStudents();
        printAllSubjectsWithStudents();
    }

    public static void addStudentWithSubjects(Student student, Subject subject, int grade) {
        gradesByStudent.putIfAbsent(student, new Grade());
        gradesByStudent.get(student).addGrade(subject, grade);
    }

    public static void removeStudentWithSubjects(Student student) {
        gradesByStudent.remove(student);
    }

    public static void printAllStudents() {
        for (Map.Entry<Student, Grade> entry : gradesByStudent.entrySet()) {
            for (Map.Entry<Subject, Integer> innerEntry : entry.getValue().getAllGrades().entrySet()) {
                System.out.println(entry.getKey().getName() + ": " + innerEntry.getKey().getName() + ", grade: " + innerEntry.getValue());
            }
        }
    }

    public static void addSubjectWithStudents(Subject subject, List<Student> newStudents) {
        studentsBySubject.putIfAbsent(subject, new ArrayList<>());
        for (Student student : newStudents) {
            studentsBySubject.get(subject).add(student);
        }
    }

    public static void removeStudentFromSubjectGroup(Subject subject, Student student) {
        studentsBySubject.get(subject).remove(student);
    }

    public static void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : studentsBySubject.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }
}
