package school.faang.doublecache;

import school.faang.doublecache.classes.Student;
import school.faang.doublecache.classes.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Student, Map<Subject, Integer>> students = new HashMap<>();
    public static Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void addStudentAndSubjects(Student student, Map<Subject, Integer> subjects) {
        students.put(student, subjects);
        for(Subject subject : subjects.keySet()) {
            addStudentForSubject(student, subject);
        }
    }

    public static void addSubjectForStudent(Student student, Subject subject, Integer rating) {
        students.get(student).put(subject, rating);
    }

    public static void deleteStudentAndSubject(Student student) {
        students.remove(student);
    }

    public static void displayAllStudentAndRatingOfSubjects() {
        for(Map.Entry<Student, Map<Subject, Integer>> mapEntry : students.entrySet()) {
            System.out.println("Студент " + mapEntry.getKey().getName());
            System.out.println("Предметы: ");
            for(Map.Entry<Subject, Integer> subjectMap : mapEntry.getValue().entrySet()) {
                System.out.printf("%s оценка %s\n", subjectMap.getKey().getName(), subjectMap.getValue());
            }
        }
    }

    public static void addSubjectAndStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
    }

    public static void addStudentForSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void deleteStudentFromSubject(Student student, Subject subject) {
        List<Student> studentList = new ArrayList<>(subjectStudents.get(subject));
        studentList.remove(student);
        subjectStudents.put(subject, studentList);
    }

    public static void displayAllSubjectAndStudents() {
        for(Map.Entry<Subject, List<Student>> mapEntry : subjectStudents.entrySet()) {
            System.out.println("Предмет " + mapEntry.getKey().getName());
            System.out.println("Студенты: ");
            for(Student student : mapEntry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        Student Ivan = new Student(1, "Ivan");
        Student Alex = new Student(2, "Alex");
        Student Ura = new Student(3, "Ura");
        Subject Math = new Subject(1, "Math");
        Subject Geo = new Subject(2, "Geo");
        Subject Physics = new Subject(3, "Physics");
        Map<Subject, Integer> ivanSubjects = new HashMap<>();
        Map<Subject, Integer> alexSubjects = new HashMap<>();
        Map<Subject, Integer> uraSubjects = new HashMap<>();

        ivanSubjects.put(Math, 5);
        ivanSubjects.put(Geo, 4);
        alexSubjects.put(Geo, 5);
        alexSubjects.put(Physics, 3);
        uraSubjects.put(Physics, 2);
        uraSubjects.put(Math, 4);

        addStudentAndSubjects(Ivan, ivanSubjects);
        addStudentAndSubjects(Alex, alexSubjects);
        addStudentAndSubjects(Ura, uraSubjects);
        addSubjectForStudent(Alex, Math, 3);
        deleteStudentAndSubject(Ivan);
        displayAllStudentAndRatingOfSubjects();

        addSubjectAndStudents(Physics, List.of(Ivan, Alex));
        deleteStudentFromSubject(Alex, Physics);
        displayAllSubjectAndStudents();
    }
}