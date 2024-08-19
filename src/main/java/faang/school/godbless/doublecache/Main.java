package faang.school.godbless.doublecache;

import java.util.*;

public class Main {
    private final static Map<Student, Map<Subject, Integer>> students = new HashMap<>();
    private final static Map<Subject, List<Student>> subjects = new HashMap<>();

    // добавление нового студента, его предметов с оценками
    public static void addStudent(Student student, Map<Subject, Integer> studentSubjectsAndRates) {
        students.computeIfAbsent(student, studentKey -> studentSubjectsAndRates);

        if (studentSubjectsAndRates != null) {
            for (Subject subject : studentSubjectsAndRates.keySet()) {
                if (!students.get(student).containsKey(subject)) {
                    students.get(student).put(subject, studentSubjectsAndRates.get(subject));
                }
                if (!subjects.containsKey(subject)) {
                    subjects.put(subject, new LinkedList<>());
                }
                if (!subjects.get(subject).contains(student)) {
                    subjects.get(subject).add(student);
                }
            }
        } else {
            System.out.println("Где зачётку потерял, негодник!!! :)");
        }
    }

    // добавление нового предмета для существующего студента
    public static void addSubjectForStudent(Student student, Subject subject) {
        addStudentAndSubject(student, subject);
    }

    // удаление студента и его предметов с оценками
    public static void removeStudent(Student student) {
        students.remove(student);
    }

    // вывод списка всех студентов и их оценок по предметам
    public static void printStudents() {
        for (Student student : students.keySet()) {
            System.out.println("student: " + student.getName() + ":");

            for (Subject subject : students.get(student).keySet()) {
                System.out.println("  subject: " + subject.getName()
                        + ", rate: " + students.get(student).get(subject)
                );
            }
        }
    }

    // добавление нового предмета и списка студентов, изучающих его
    public static void addSubject(Subject subject, List<Student> studentsList) {
        subjects.computeIfAbsent(subject, subjectKey -> new LinkedList<>()).addAll(studentsList);

        if (!subjects.containsKey(subject)) {
            subjects.put(subject, studentsList);
        } else {
            for (Student student : studentsList) {
                if (!subjects.get(subject).contains(student)) {
                    subjects.get(subject).add(student);
                }
            }
        }

        // добавить предмет студентам
        for (Student student : studentsList) {
            if (!students.containsKey(student)) {
                students.put(student, new HashMap<>());
                students.get(student).put(subject, null);
            }
        }
    }

    public static void addStudentAndSubject(Student student, Subject subject) {
        if (!students.containsKey(student)) {
            students.put(student, new HashMap<>());
        }
        if (!students.get(student).containsKey(subject)) {
            students.get(student).put(subject, null);
        }
        if (!subjects.containsKey(subject)) {
            subjects.put(subject, new LinkedList<>());
        }
        if (!subjects.get(subject).contains(student)) {
            subjects.get(subject).add(student);
        }
    }

    // добавление студента к существующему предмету
    public static void addStudentToSubject(Subject subject, Student student) {
        addStudentAndSubject(student, subject);
    }

    // удаление студента из предмета
    public static void removeStudentFromSubject(Subject subject, Student student) {
        if (subjects.containsKey(subject)) {
            subjects.get(subject).remove(student);
        }
    }

    // вывод списка всех предметов и студентов, изучающих их
    public static void printSubjects() {
        for (Subject subject : subjects.keySet()) {
            System.out.println("subject: " + subject);
            System.out.println(
                    subjects.get(subject).stream()
                            .map(value -> "  studentId: " + value.getId()
                                    + "; studentName: " + value.getName() + "\r\n")
                            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                            .toString()
            );
        }
    }


    public static void main(String[] args) {

        Map<Subject, Integer> studentRates = new HashMap<>();
        studentRates.put(new Subject(0, "subject0"), 3);
        studentRates.put(new Subject(1, "subject1"), 4);
        studentRates.put(new Subject(2, "subject2"), 5);

        addStudent(new Student(0, "student0"), studentRates);

        printStudents();

        System.out.println();

        printSubjects();

        System.out.println();

        studentRates = new HashMap<>();
        studentRates.put(new Subject(0, "subject0"), 3);
        studentRates.put(new Subject(1, "subject1"), 4);
        studentRates.put(new Subject(2, "subject2"), 5);
        studentRates.put(new Subject(4, "subject4"), 5); //
        studentRates.put(new Subject(6, "subject6"), 5); //

        addStudent(new Student(0, "student0"), studentRates);

        System.out.println();

        printStudents();

        System.out.println();

        printSubjects();

        System.out.println();

        studentRates = new HashMap<>();

        studentRates.put(new Subject(3, "subject3"), 3);
        studentRates.put(new Subject(1, "subject1"), 4);
        studentRates.put(new Subject(2, "subject2"), 5);
        studentRates.put(new Subject(0, "subject0"), 4);

        addStudent(new Student(1, "student1"), studentRates);

        System.out.println();

        printStudents();

        List<Student> studentList = new LinkedList<>();
        studentList.add(new Student(2, "student2"));
        studentList.add(new Student(3, "student3"));
        addSubject(new Subject(0, "subject0"), studentList);
        printSubjects();

    }
}
