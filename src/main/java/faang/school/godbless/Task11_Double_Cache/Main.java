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

    //работает, если есть есть студент, и у него нет оценки и предмета; если предмет есть, то ничего не делает
    public static void addSubjectForStudent(Subject subject, int mark, Student student) {
        marks.computeIfPresent(student, (key, value) -> value).computeIfAbsent(subject, (val1) ->mark);
    }

    public static void removeStudentAndMarks(Student student) {
        marks.remove(student);
    }

    public static void showStudentsAndMarks() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : marks.entrySet()) {
            String name = entry.getKey().getName();
            System.out.print("Student: " + name + " ");
            for (Map.Entry<Subject, Integer> subjectMark : entry.getValue().entrySet()) {
                System.out.print("Subject: " + subjectMark.getKey().getName() + ", mark: "
                        + subjectMark.getValue() + " ");
            }
            System.out.println();
        }
    }

    //methods for 2nd HashMap
    public static void addSubjectAndStudents(Subject subject, List<Student> visitors) {
        attenders.put(subject, visitors);
    }

    public static void addStudentToSubject(Student student, Subject subject) {
        if (attenders.get(subject)==null) throw new IllegalArgumentException("no such student");
        if (attenders.get(subject).contains(student)) System.out.println("the subject already added");
        else attenders.compute(subject, (key, value) -> value).add(student);
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        attenders.computeIfPresent(subject, (key, value) -> value).remove(student);
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
        Student alex = new Student(2, "Alex");
        Student john = new Student(3, "John");
        Student mike = new Student(4, "Mike");
        Subject math = new Subject(1, "Math");
        Subject phys = new Subject(2, "Physics");
        Subject chemistry = new Subject(3, "Chemistry");
        Map<Subject, Integer> alexMarks = new HashMap<>();
        Map<Subject, Integer> ivanMarks = new HashMap<>();
        Map<Subject, Integer> johnMarks = new HashMap<>();
        ivanMarks.put(math, 5);
        alexMarks.put(phys, 4);
        johnMarks.put(chemistry, 5);
        johnMarks.put(math, 4);
        marks.put(ivan, ivanMarks);
        marks.put(alex, alexMarks);
        System.out.println(marks);

        addStudentAndMarks(john, johnMarks);
        System.out.println(marks);
        addSubjectForStudent(chemistry, 4, ivan);
        System.out.println(marks);
        addSubjectForStudent(phys, 3, alex); //ничего не сделает, так как это предмет уже есть
        System.out.println(marks);
        removeStudentAndMarks(alex);
        System.out.println(marks);
        showStudentsAndMarks();
        System.out.println();

        List<Student> mathLovers = new ArrayList<>();
        List<Student> physicsEnjoyers = new ArrayList<>();
        mathLovers.add(ivan);
        mathLovers.add(john);
        physicsEnjoyers.add(ivan);

        attenders.put(math, mathLovers);
        System.out.println(attenders);

        physicsEnjoyers.add(alex);
        addSubjectAndStudents(phys, physicsEnjoyers);
        System.out.println(attenders);

        addStudentToSubject(mike, math);
        System.out.println(attenders);
        removeStudentFromSubject(alex, phys);
        System.out.println(attenders);

        addSubjectAndStudents(phys, physicsEnjoyers);
        showSubjectsAndStudents(attenders);

    }
}
