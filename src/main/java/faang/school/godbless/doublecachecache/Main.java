package faang.school.godbless.doublecachecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_GRADES = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Test add");
        Student petr = new Student("Petr");
        Subject math = new Subject("math");
        Student john = new Student("John");
        Map<Subject, Integer> petrMap = new HashMap<>();
        petrMap.put(math, 5);
        addStudent(petr, petrMap);
        addStudent(john, Map.of(math, 5));

        printStudentGrades();
        System.out.println("----");
        printAllSubjects();

        System.out.println("---------------------");
        System.out.println();

        System.out.println("add subject english to user");
        Subject english = new Subject("English");

        addSubjectToStudent(english, 4, petr);

        printStudentGrades();
        System.out.println("----");
        printAllSubjects();
        System.out.println("---------------------");
        System.out.println();

        System.out.println("Remove john");
        removeStudent(john);

        printStudentGrades();
        System.out.println("----");
        printAllSubjects();
        System.out.println("---------------------");
        System.out.println();

        System.out.println("add new Subject");
        Subject phys = new Subject("Physical");
        Student student1 = new Student("one");
        Student student2 = new Student("two");
        List<Student> physicList = new ArrayList<>();
        physicList.add(student1);
        physicList.add(student2);

        addSubject(phys, physicList);

        printStudentGrades();
        System.out.println("----");
        printAllSubjects();
        System.out.println("---------------------");
        System.out.println();

        System.out.println("test addStudentToSubject");
        Student student3 = new Student("three");
        addStudentTOSubject(phys, student3);

        printStudentGrades();
        System.out.println("----");
        printAllSubjects();
        System.out.println("---------------------");
        System.out.println();

        System.out.println("TEST remove student 3 from subject");
        removeStudentFromSubject(phys, student3);

        printStudentGrades();
        System.out.println("----");
        printAllSubjects();
        System.out.println("---------------------");
        System.out.println();

    }

    public static void addStudent(Student student, Map<Subject, Integer> grades) {
        STUDENT_GRADES.put(student, grades);
        for (Subject subject : grades.keySet()) {
            SUBJECT_STUDENTS.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
        }
    }

    public static void addSubjectToStudent(Subject subject, Integer grade, Student student) {
        if (!STUDENT_GRADES.containsKey(student)) {
            throw new IllegalArgumentException("There is no such student");
        }
        STUDENT_GRADES.get(student).put(subject, grade);
        SUBJECT_STUDENTS.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Student student) {
        for (Subject subject : STUDENT_GRADES.get(student).keySet()) {
            SUBJECT_STUDENTS.get(subject).remove(student);
        }
        STUDENT_GRADES.remove(student);
    }

    public static void printStudentGrades() {
        for (Student student : STUDENT_GRADES.keySet()) {
            System.out.println("Student: " + student);
            System.out.println("Subjects and grade: ");
            for (Map.Entry<Subject, Integer> entry : STUDENT_GRADES.get(student).entrySet()) {
                System.out.println(entry.getKey().getName() + " " + entry.getValue());
            }
        }
    }

    public static void addSubject(Subject subject, List<Student> students) {
        SUBJECT_STUDENTS.put(subject, students);
        for (Student student : students) {
            STUDENT_GRADES.computeIfAbsent(student, key -> new HashMap<>()).put(subject, null);
        }
    }

    public static void addStudentTOSubject(Subject subject, Student student) {
        if (!SUBJECT_STUDENTS.containsKey(subject)) {
            throw new IllegalArgumentException("There is no such subject");
        }
        SUBJECT_STUDENTS.get(subject).add(student);
        STUDENT_GRADES.computeIfAbsent(student, key -> new HashMap<>()).put(subject, null);
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        SUBJECT_STUDENTS.get(subject).remove(student);
        STUDENT_GRADES.get(student).remove(subject);
    }

    public static void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : SUBJECT_STUDENTS.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("Students on subject: ");
            entry.getValue().forEach(student -> System.out.println(student.getName()));
        }
    }
}
