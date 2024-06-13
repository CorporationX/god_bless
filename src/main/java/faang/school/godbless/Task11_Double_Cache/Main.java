package faang.school.godbless.Task11_Double_Cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {

    static final Map<Student, Map<Subject, Integer>> marks = new HashMap<>();
    static final Map<Subject, List<Student>> attenders = new HashMap<>();

    //methods for 1st HashMap
    public static void addStudentAndMarks( Student student,
                                          Map<Subject, Integer> subjectMarks) {
        marks.put(student, subjectMarks);
    }

    public static void addSubjectForStudent(Subject subject, int mark, Student student) {
        marks.compute(student, (key, value) -> value).put(subject, mark);
    }

    public static void removeStudentAndMarks(Student student) {
        marks.remove(student);
    }

    public static void showStudentsAndMarks(Map<Student, Map<Subject, Integer>> marks) {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : marks.entrySet()) {
            String name = entry.getKey().getName();
            System.out.println("Student: " + name);
            for (Map.Entry<Subject, Integer> subjectMark : entry.getValue().entrySet()) {
                System.out.println("Subject: " + subjectMark.getKey().getName() + ", mark: "
                        + subjectMark.getValue());
            }
        }
    }

    //methods for 2nd HashMap
    public static void addSubjectAndStudents(Subject subject, List<Student> visitors,
                                             Map<Subject, List<Student>> attenders) {
        attenders.put(subject, visitors);
    }

    public static void addStudentToSubject(Student student, Subject subject,
                                           Map<Subject, List<Student>> attenders) {
        attenders.compute(subject, (key, value) -> value).add(student);
    }

    public static void removeStudentFromSubject(Student student, Subject subject,
                                                Map<Subject, List<Student>> attenders) {
        attenders.compute(subject, (key, value) -> value).remove(student);
        if (attenders.get(subject).isEmpty()) {
            attenders.remove(subject);
        }
    }

    public static void showSubjectsAndStudents(Map<Subject, List<Student>> attenders) {
        for (Map.Entry<Subject, List<Student>> entry : attenders.entrySet()) {
            System.out.print(entry.getKey().getName() + ": ");
            for (Student student : entry.getValue()) {
                System.out.print(student.getName() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Student ivan = new Student(1, "Ivan");
        Map<Subject, Integer> ivanMarks = new HashMap<>();
        Subject math = new Subject(1, "Math");
        ivanMarks.put(math, 5);
        Student alex = new Student(2, "Alex");
        Map<Subject, Integer> alexMarks = new HashMap<>();
        Subject phys = new Subject(2, "Physics");
        alexMarks.put(phys, 4);

        marks.put(ivan, ivanMarks);
        marks.put(alex, alexMarks);
        System.out.println(marks);

        Student john = new Student(3, "John");
        Subject chemistry = new Subject(3, "Chemistry");
        Map<Subject, Integer> johnMarks = new HashMap<>();
        johnMarks.put(chemistry, 5);
        johnMarks.put(math, 4);
        addStudentAndMarks(john, johnMarks);
        System.out.println(marks);
        addSubjectForStudent(chemistry, 4, ivan);
        System.out.println(marks);
        removeStudentAndMarks(alex);
        System.out.println(marks);
        showStudentsAndMarks(marks);
        System.out.println();

        List<Student> mathLovers = new ArrayList<>();
        mathLovers.add(ivan);
        mathLovers.add(john);
        attenders.put(math, mathLovers);
        System.out.println(attenders);
        List<Student> physicsEnjoyers = new ArrayList<>();
        physicsEnjoyers.add(alex);
        addSubjectAndStudents(phys, physicsEnjoyers, attenders);
        System.out.println(attenders);
        Student mike = new Student(4, "Mike");
        addStudentToSubject(mike, math, attenders);
        System.out.println(attenders);
        removeStudentFromSubject(alex, phys, attenders);
        System.out.println(attenders);
        physicsEnjoyers.add(ivan);
        addSubjectAndStudents(phys, physicsEnjoyers, attenders);
        showSubjectsAndStudents(attenders);

    }

}
