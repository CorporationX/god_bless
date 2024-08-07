package faang.school.godbless.doubleCache;

import java.util.*;

public class Main {
    private static HashMap<Student, HashMap<Subject, Integer>> students = new HashMap<>();
    private static HashMap<Subject, List<Student>> subjects = new HashMap<>();

    public static void addStudent(Student student, HashMap<Subject, Integer> subjectsOtThisStudent) {
        students.put(student, subjectsOtThisStudent);
        for (Subject subject : subjectsOtThisStudent.keySet()) {
            if (subjects.containsKey(subject)) {
                subjects.get(subject).add(student);
            } else {
                subjects.put(subject, new LinkedList<>(List.of(student)));
            }
        }
    }

    public static void addSubjectToStudent(Student student, Subject subject, Integer grade) {
        if (students.containsKey(student)) {
            students.get(student).put(subject, grade);
            if (subjects.containsKey(subject)) {
                subjects.get(subject).add(student);
            } else {
                subjects.put(subject, new LinkedList<>(List.of(student)));
            }
        } else {
            System.out.println("There is no student with id " + student.getId() + "and name " + student.getName());
        }
    }

    public static void deleteStudent(Student student) {
        Map<Subject, Integer> subjectsOtThisStudent = students.get(student);
        for (Subject subject : subjectsOtThisStudent.keySet()) {
            if (subjects.containsKey(subject)) {
                subjects.get(subject).remove(student);
            }
        }
        students.remove(student);
    }

    public static void printStudents() {
        for (Map.Entry<Student, HashMap<Subject, Integer>> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<Subject, Integer> subjectEntry : entry.getValue().entrySet()) {
                System.out.println(subjectEntry.getKey() + " - " + subjectEntry.getValue());
            }
        }
    }

    public static void addSubject(Subject subject, List<Student> studentsOfThisSubject) {
        subjects.put(subject, studentsOfThisSubject);
        for (Student student : studentsOfThisSubject) {
            if (students.containsKey(student)) {
                students.get(student).put(subject, 0);
            } else {
                students.put(student, new HashMap<>(Map.of(subject, 0)));
            }
        }
    }

    public static void addStudentToSubject(Student student, Subject subject, Integer grade) {
        if (subjects.containsKey(subject)) {
            subjects.get(subject).add(student);
            if (students.containsKey(student)) {
                students.get(student).put(subject, grade);
            } else {
                students.put(student, new HashMap<>(Map.of(subject, grade)));
            }
        } else {
            System.out.println("There is no subject with id " + subject.getId() + "and name " + subject.getName());
        }
    }

    public static void deleteSubjectFromStudent(Student student, Subject subject) {
        if (subjects.containsKey(subject)) {
            subjects.get(subject).remove(student);
            if (students.containsKey(student)) {
                students.get(student).remove(subject);
            } else {
                System.out.println("There is no student with id " + student.getId() + "and name " + student.getName());
            }
        } else {
            System.out.println("There is no subject with id " + subject.getId() + "and name " + subject.getName());
        }
    }

    public static void printSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : subjects.entrySet()) {
            System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue().toArray()));
        }
    }

    public static void main(String[] args) {
        addStudent(new Student(1, "Mary"), new HashMap<>(Map.of(new Subject(1, "Mathematics"), 5,
                new Subject(2, "Physics"), 4, new Subject(3, "Programming Languages"), 5,
                new Subject(4, "History"), 3, new Subject(5, "English"), 4)));

        addSubjectToStudent(new Student(1, "Mary"), new Subject(6, "Engineering"), 5);

        addStudentToSubject(new Student(2, "Tom"), new Subject(6, "Engineering"), 5);

        deleteStudent(new Student(2, "Tom"));

        deleteSubjectFromStudent(new Student(1, "Mary"), new Subject(4, "History"));

        addSubject(new Subject(7, "Number Theory"), List.of(new Student(1, "Mary"),
                new Student(3, "Kate"), new Student(4, "Ben")));

        printStudents();
        printSubjects();
    }
}
