package doubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> STUDENTS_SUBJECT_GRADES = new HashMap<>();
    private static final Map<Subject, List<Student>> STUDENTS_BY_SUBJECT = new HashMap<>();

    public static void main(String[] args) {
        Map<Subject, Integer> map = new HashMap<>();
        Subject subject1 = new Subject("Math");
        Subject subject2 = new Subject("Programming");
        Subject subject3 = new Subject("System Analysis");
        Subject subject4 = new Subject("System design");
        Subject subject5 = new Subject("Economy");
        Subject subject6 = new Subject("IoT");
        map.put(subject1, 3);
        map.put(subject2, 4);
        map.put(subject3, 3);
        map.put(subject4, 4);


        Student student1 = new Student("Nick");
        Map<Subject, Integer> subjects = Map.of(subject1, 5, subject2, 5, subject3, 4, subject4, 5);
        addStudentWithSubjects(student1, subjects);
        Student student2 = new Student("Paul");
        subjects = Map.of(subject1, 5, subject3, 4, subject4, 5, subject5, 3);
        addStudentWithSubjects(student2, subjects);
        Student student3 = new Student("Anya");
        subjects = Map.of(subject2, 5, subject4, 5, subject5, 5);
        addStudentWithSubjects(student3, subjects);
        Student student4 = new Student("Vadim");
        addStudentWithSubjects(student4, map);
        Student student5 = new Student("TEST");
        addSubjectWithGrade(student5, subject6, 5);
        Student student6 = new Student("TEST2");
        addSubjectWithGrade(student5, subject4, 5);

        printAllStudentsWithSubjectsAndGrades();
        printAllSubjectsAndStudentList();

        System.out.println("\n===Check removeStudent===");
        removeStudent(student5);
        printAllStudentsWithSubjectsAndGrades();
        printAllSubjectsAndStudentList();


        System.out.println("\n===Check addSubjectAndStudentList===");
        List<Student> students = new ArrayList<>();
        students.add(student5);
        students.add(student6);
        addSubjectAndStudentList(subject6, students);
        printAllStudentsWithSubjectsAndGrades();
        printAllSubjectsAndStudentList();

        System.out.println("\n===Check addStudentToSubject===");
        addStudentToSubject(subject1, student6);
        printAllStudentsWithSubjectsAndGrades();
        printAllSubjectsAndStudentList();

        System.out.println("\n===Check removeStudentFromSubject===");
        removeStudentFromSubject(subject1, student6);
        printAllStudentsWithSubjectsAndGrades();
        printAllSubjectsAndStudentList();


    }

    public static void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        checkStudent(student);
        STUDENTS_SUBJECT_GRADES.put(student, subjects);
        subjects.entrySet().forEach(entry -> {
            checkAndAddToStudentsBySubjectMap(student, entry.getKey());
        });

    }

    public static void addSubjectWithGrade(Student student, Subject subject, Integer grade) {
        checkStudent(student);
        checkSubject(subject);
        if (!STUDENTS_SUBJECT_GRADES.containsKey(student)) {
            STUDENTS_SUBJECT_GRADES.put(student, new HashMap<>());
        }
        STUDENTS_SUBJECT_GRADES.get(student).put(subject, grade);
        checkAndAddToStudentsBySubjectMap(student, subject);

    }

    public static void removeStudent(Student student) {
        checkStudent(student);
        STUDENTS_SUBJECT_GRADES.get(student).forEach((subject, integer) -> STUDENTS_BY_SUBJECT.get(subject).removeIf(stud -> stud.equals(student)));
        STUDENTS_SUBJECT_GRADES.remove(student);
    }

    public static void printAllStudentsWithSubjectsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENTS_SUBJECT_GRADES.entrySet()) {
            System.out.println("Student name: " + entry.getKey().getName());
            System.out.println("===================================");
            for (Map.Entry<Subject, Integer> entrySubject : entry.getValue().entrySet()) {
                System.out.println("\nSubject name: " + entrySubject.getKey().getName() +
                        "\nGrade: " + entrySubject.getValue());
            }
            System.out.println("\n===================================");
        }
    }

    public static void addSubjectAndStudentList(Subject subject, List<Student> students) {
        checkSubject(subject);
        STUDENTS_BY_SUBJECT.put(subject, students);
        students.forEach(student -> {
            checkAndAddSubjectToStudentSubjectGrades(student, subject);
        });
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        checkSubject(subject);
        checkStudent(student);
        checkAndAddToStudentsBySubjectMap(student, subject);
        checkAndAddSubjectToStudentSubjectGrades(student, subject);
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        checkStudent(student);
        checkSubject(subject);
        STUDENTS_BY_SUBJECT.get(subject).removeIf(stud -> stud.equals(student));
        STUDENTS_SUBJECT_GRADES.get(student).remove(subject);
    }

    public static void printAllSubjectsAndStudentList() {
        for (Map.Entry<Subject, List<Student>> entry : STUDENTS_BY_SUBJECT.entrySet()) {
            System.out.println("Subject name: " + entry.getKey().getName());
            System.out.println("===================================");
            for (Student student : entry.getValue()) {
                System.out.println("\nStudent ID: " + student.getId() +
                        "\nStudent name: " + student.getName());
            }
            System.out.println("\n===================================");
        }
    }

    public static void checkStudent(Student student) {
        if (student == null) throw new NullPointerException("Student should not be null");
    }

    public static void checkSubject(Subject subject) {
        if (subject == null) throw new NullPointerException("Subject should not be null");
    }

    public static void checkAndAddToStudentsBySubjectMap(Student student, Subject subject) {
        if (!STUDENTS_BY_SUBJECT.containsKey(subject)) {
            STUDENTS_BY_SUBJECT.put(subject, new ArrayList<>());
        }
        if (!STUDENTS_BY_SUBJECT.get(subject).contains(student)) {
            STUDENTS_BY_SUBJECT.get(subject).add(student);
        }
    }

    public static void checkAndAddSubjectToStudentSubjectGrades(Student student, Subject subject) {
        if (!STUDENTS_SUBJECT_GRADES.containsKey(student)) {
            STUDENTS_SUBJECT_GRADES.put(student, new HashMap<>());
        }
        if (!STUDENTS_SUBJECT_GRADES.get(student).containsKey(subject)) {
            STUDENTS_SUBJECT_GRADES.get(student).put(subject, 0);
        }
    }
}
