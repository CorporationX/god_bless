package school.faang.doublecache;

import school.faang.doublecache.classes.Student;
import school.faang.doublecache.classes.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();
    public static Map<Subject, List<Student>> subjectMap = new HashMap<>();

    public static void addNewStudentAndSubjects(Student student, Map<Subject, Integer> subjectMap) {
        studentMap.put(student, subjectMap);
    }

    public static void addNewSubjectForStudent(Student student, Subject subject, Integer rating) {
        studentMap.get(student).put(subject, rating);
    }

    public static void deleteStudentAndSubject(Student student) {
        studentMap.remove(student);
    }

    public static void displayAllStudentAndRatingOfSubjects() {
        for(Map.Entry<Student, Map<Subject, Integer>> mapEntry : studentMap.entrySet()) {
            System.out.println("Студент " + mapEntry.getKey().getName());
            System.out.println("Предметы: ");
            for(Map.Entry<Subject, Integer> subjectMap : mapEntry.getValue().entrySet()) {
                System.out.printf("%s оценка %s\n", subjectMap.getKey().getName(), subjectMap.getValue());
            }
        }
    }

    public static void addNewSubjectAndStudents(Subject subject, List<Student> students) {
        subjectMap.put(subject, students);
    }

    public static void addNewStudentForSubject(Student student, Subject subject) {
        subjectMap.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void deleteStudentFromSubject(Student student, Subject subject) {
        List<Student> studentList = subjectMap.get(subject).stream()
                .filter(student1 -> !Objects.equals(student1, student))
                .collect(Collectors.toList());
        subjectMap.put(subject, studentList);
    }

    public static void displayAllSubjectAndStudents() {
        for(Map.Entry<Subject, List<Student>> mapEntry : subjectMap.entrySet()) {
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

        addNewStudentAndSubjects(Ivan, ivanSubjects);
        addNewStudentAndSubjects(Alex, alexSubjects);
        addNewStudentAndSubjects(Ura, uraSubjects);
        addNewSubjectForStudent(Alex, Math, 3);
        deleteStudentAndSubject(Ivan);
        displayAllStudentAndRatingOfSubjects();

        addNewSubjectAndStudents(Physics, List.of(Ivan, Alex));
        addNewStudentForSubject(Ura, Math);
        deleteStudentFromSubject(Alex, Physics);
        displayAllSubjectAndStudents();
    }

}