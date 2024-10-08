package school.faang;

import school.faang.university.Student;
import school.faang.university.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();
    private static Map<Subject, List<Student>> subjectMap = new HashMap<>();

    public static void main(String[] args) {
        Student firstStudent = new Student(12, "John");
        Student secondStudent = new Student(208, "Mark");
        Student thirdStudent = new Student(35, "Ada");

        Subject chemistry = new Subject(2, "Chemistry");
        Subject pe = new Subject(15, "PE");
        Subject maths = new Subject(26, "Maths");

        addNewStudent(firstStudent, new HashMap<>(Map.of(chemistry, 8, pe, 12, maths, 3)));
        addNewStudent(secondStudent, new HashMap<>(Map.of(pe, 10, chemistry, 7)));
        addNewStudent(thirdStudent, new HashMap<>(Map.of(maths, 12)));

        addNewSubjectToStudent(thirdStudent, pe, 6);
        addNewSubjectToStudent(firstStudent, chemistry, 7);

        deleteStudent(secondStudent);

        printAllStudSubj();

        addNewSubject(
                new Subject(12, "Physics"),
                List.of(firstStudent, thirdStudent)
        );
        addStudentToASubject(chemistry, thirdStudent);

        detachStudFromSubj(chemistry, firstStudent);

        printAllSubjects();
    }

    public static void addNewStudent(
            Student student,
            Map<Subject, Integer> grade
    ) {
        if (!studentMap.containsKey(student)) {
            studentMap.put(student, grade);
        }
        for (Map.Entry<Subject, Integer> entry : grade.entrySet()) {
            Subject keySubject = entry.getKey();
            if (subjectMap.containsKey(keySubject)) {
                if (subjectMap.get(keySubject) != null) {
                    subjectMap.get(keySubject).add(student);
                } else {
                    List<Student> students = new ArrayList<>();
                    students.add(student);
                    subjectMap.put(keySubject, students);
                }
            }
        }
    }

    public static void addNewSubjectToStudent(
            Student student,
            Subject subject,
            Integer grade
    ) {
        if (studentMap.containsKey(student)) {
            if (!studentMap.get(student).containsKey(subject)) {
                studentMap.get(student).put(subject, grade);
                if (
                        subjectMap.containsKey(subject)
                        && subjectMap.get(subject) != null
                ) {
                    subjectMap.get(subject).add(student);
                } else {
                    List<Student> students = new ArrayList<>();
                    students.add(student);
                    subjectMap.put(subject, students);
                }
            }
        }
    }

    public static void deleteStudent(Student student) {
        if (studentMap.containsKey(student)) {
            studentMap.remove(student);

        }
    }

    public static void printAllStudSubj() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentMap.entrySet()) {
            System.out.print("Student: " + entry.getKey());
            System.out.println(" subjects: " + entry.getValue());
        }
    }

    public static void addNewSubject(Subject subject, List<Student> students) {
        if (!subjectMap.containsKey(subject)) {
            subjectMap.put(subject, students);
            for (Student student : students) {
                if (studentMap.containsKey(student)) {
                    studentMap.get(student).put(subject, null);
                } else {
                    studentMap.put(student, new HashMap<>(Map.of(subject, null)));
                }
            }
        }
    }

    public static void addStudentToASubject(Subject subject, Student student) {
        if (subjectMap.containsKey(subject)) {
            if (subjectMap.get(subject) == null) {
                List<Student> students = new ArrayList<>();
                students.add(student);
                subjectMap.put(subject, students);
            } else {
                subjectMap.get(subject).add(student);
            }
            if(!subjectMap.get(student).contains(subject)){
                studentMap.put(student, new HashMap<>(Map.of(subject, null)));
            }
        }
    }

    public static void detachStudFromSubj(Subject subject, Student student) {
        if (subjectMap.containsKey(subject)) {
            List<Student> students = subjectMap.get(subject);
            if (students.contains(student) && students != null) {
                if (students.size() == 1) {
                    subjectMap.put(subject, null);
                } else {
                    subjectMap.get(subject).remove(student);
                }
                studentMap.get(student).remove(subject);
            }
        }

    }

    public static void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : subjectMap.entrySet()) {
            System.out.print("Student: " + entry.getKey());
            System.out.println(" grade:" + entry.getValue());
        }
    }

}
