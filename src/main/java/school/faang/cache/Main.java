package school.faang.cache;

import java.util.*;

public class Main {
    static Map<Student, Map<Subject, Integer>> mapStudents = new HashMap<>();
    static Map<Subject, List<Student>> mapSubjects = new HashMap<>();

    public static void main(String[] args) {

        Subject math = new Subject(1, "Mathematics");
        Subject eng = new Subject(2, "English");
        Subject liter = new Subject(3, "Literature");

        Student firstStud = new Student(1, "Alex");
        Student secondStud = new Student(2, "Maria");


        Map<Subject, Integer> subjectsFirstStud = new HashMap<>();
        subjectsFirstStud.put(math, 9);
        subjectsFirstStud.put(eng, 10);
        subjectsFirstStud.put(liter, 8);

        Map<Subject, Integer> subjectsSecondStud = new HashMap<>();
        subjectsSecondStud.put(math, 5);
        subjectsSecondStud.put(eng, 10);
        subjectsSecondStud.put(liter, 10);

        addStudentToMap(firstStud, subjectsFirstStud);
        addStudentToMap(secondStud, subjectsSecondStud);
        addStudentToMap(secondStud, subjectsSecondStud);
        addNewSubject(firstStud, new Subject(4, "Chemical"), 5);
        removeStudent(firstStud);
        printAllStudents();

        List<Student> listStudents = new ArrayList<>();
        listStudents.add(firstStud);
        listStudents.add(secondStud);

        addSubjectToMap(new Subject(5, "Economics"), listStudents);
        addNewStudent(new Subject(5, "Economics"), new Student(3, "Anton"));
        removeStudentFromSubjectMap(new Subject(5, "Economics"), firstStud);
        printAllSubjects();
    }

    static void addStudentToMap(Student student, Map<Subject, Integer> subjects) {
        mapStudents.put(student, subjects);
    }

    static void addNewSubject(Student student, Subject subject, Integer points) {
        mapStudents.computeIfAbsent(student, x -> new HashMap<Subject, Integer>()).put(subject, points);
    }

    static void removeStudent(Student student) {
        mapStudents.remove(student);
    }

    static void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : mapStudents.entrySet()) {
            System.out.println("\n" + entry.getKey() + "\n");
            for (Map.Entry<Subject, Integer> subject : entry.getValue().entrySet()) {
                System.out.println(subject.getKey() + " - " + subject.getValue() + " points");
            }
        }
    }

    static void addSubjectToMap(Subject newSubject, List<Student> listStuds) {
        mapSubjects.put(newSubject, listStuds);
    }

    static void addNewStudent(Subject subject, Student newStudent) {
        if (mapSubjects.get(subject) != null && mapSubjects.get(subject).contains(newStudent)) {
            mapSubjects.get(subject).add(newStudent);
        }
    }


    static void removeStudentFromSubjectMap(Subject subject, Student removeStudent) {
        if (mapSubjects.get(subject) != null && mapSubjects.get(subject).contains(removeStudent)) {
            mapSubjects.get(subject).remove(removeStudent);
        }
    }

    static void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : mapSubjects.entrySet()) {
            System.out.println("\n" + entry.getKey() + "\n");
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
        }
    }
}
