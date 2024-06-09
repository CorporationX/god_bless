package faang.school.godbless.Task11_Double_Cache;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void addStudentAndMarks(Map<Student, Map<Subject, Integer>> marks, Student student,
                                          Map<Subject, Integer> subjectMarks) {
        marks.put(student, subjectMarks);
    }

    public static void addSubjectForStudent(Subject subject, int mark, Student student,
                                            Map<Student, Map<Subject,Integer>> marks) {
        marks.compute(student, (key, value)-> value).put(subject, mark);
    }

    public static void removeStudentAndMarks(Student student, Map<Student,
            Map<Subject, Integer>> marks) {
        marks.remove(student);
    }

    public static void showStudentsAndMarks (Map<Student, Map<Subject, Integer>> marks) {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : marks.entrySet()) {
            String name = entry.getKey().getName();
            System.out.println("Student: " + name);
            for (Map.Entry<Subject, Integer> subjectMark : entry.getValue().entrySet()) {
                System.out.println("Subject: " + subjectMark.getKey().getName() + ", mark: "
                + subjectMark.getValue());
            }
        }
    }

    public static void main(String[] args) {

    Map<Student, Map<Subject, Integer>> marks = new HashMap<>();
    Map<Subject, List<Student>> attenders = new HashMap<>();

    Student ivan = new Student(1,"Ivan");
    Map<Subject, Integer> ivanMarks = new HashMap<>();
    Subject math = new Subject(1, "Math");
    ivanMarks.put(math, 5);
    Student alex = new Student(2,"Alex");
    Map<Subject, Integer> alexMarks = new HashMap<>();
    Subject phys = new Subject(2, "Subject");
    alexMarks.put(phys, 4);

    marks.put(ivan, ivanMarks);
    marks.put(alex, alexMarks);
    System.out.println(marks);

    Student john = new Student(3,"John");
    Subject chemistry = new Subject(3,"Chemistry");
    Map<Subject, Integer> johnMarks = new HashMap<>();
    johnMarks.put(chemistry, 5);
    johnMarks.put(math, 4);
    addStudentAndMarks(marks, john, johnMarks);
    System.out.println(marks);
    addSubjectForStudent(chemistry, 4, ivan, marks);
    System.out.println(marks);
    removeStudentAndMarks(alex, marks);
    System.out.println(marks);
    showStudentsAndMarks(marks);




    }

}
