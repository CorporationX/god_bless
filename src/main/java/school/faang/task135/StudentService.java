package school.faang.task135;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private static final Map<Student, Map<Subject, Integer>> students_Grade = new HashMap<>();
    private static final Map<Subject, List<Student>> subjectStudentsGroupList = new HashMap<>();

    public static void addNewStudent(Student student, HashMap<Subject, Integer> studentGrade) {
        students_Grade.put(student, studentGrade);
        for (Subject sub : studentGrade.keySet()) {
            subjectStudentsGroupList.computeIfAbsent(sub, K -> new ArrayList<>()).add(student);
        }
    }

    public static void addNewSubjectAndGradeToStudent(Student student, Subject subject, int grade) {
        students_Grade.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudentsGroupList.computeIfAbsent(subject, K -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Student student) {
        for (Subject subject : students_Grade.get(student).keySet()) {
            subjectStudentsGroupList.get(subject).remove(student);
        }
        students_Grade.remove(student);
    }

    public static void printAllInfoAboutStudent() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : students_Grade.entrySet()) {
            for (Map.Entry<Subject, Integer> secondEntry : entry.getValue().entrySet()) {
                System.out.println(entry.getKey().getName() + " "
                        + secondEntry.getKey().getName() + " "
                        + secondEntry.getValue());
            }
            System.out.println("=========================================================");
        }
    }

    public static void addNewSubjectAndStudents(Subject subject, ArrayList<Student> students) {
        subjectStudentsGroupList.put(subject, students);
        for (Student student : students) {
            students_Grade.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
        }
    }

    public static void addNewStudentToSubject(Subject subject, Student student) {
        subjectStudentsGroupList.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        students_Grade.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        subjectStudentsGroupList.get(subject).remove(student);
        students_Grade.get(student).remove(subject);
    }

    public static void printAllSubjectAndStudent() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudentsGroupList.entrySet()) {
            for (Student student : entry.getValue()) {
                System.out.println(entry.getKey().getName() + " " + student.getName());
            }
            System.out.println("=========================================================");
        }
    }

}
