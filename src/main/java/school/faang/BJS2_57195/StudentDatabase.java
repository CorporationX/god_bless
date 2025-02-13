package school.faang.BJS2_57195;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private static Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private static Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);
    }

    public static void addSubjectForStudent(Student student, Subject subject, int grade) {
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).put(subject, grade);
        } else {
            System.out.println("No such student");
        }
    }

    public static void removeStudent(Student student) {
        studentSubjects.remove(student);
    }

    public static void printAllSubjectsWithStudents() {
        studentSubjects.forEach((student, subjects) -> {
            System.out.println(student);
            studentSubjects.get(student).forEach((subject, grade) -> System.out.println(subject + " " + grade));
        });
    }


    public static void addSubjectsWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
    }

    public static void addStudentToSubject(Student student, Subject subject) {
        if (subjectStudents.containsKey(subject)) {
            subjectStudents.get(subject).add(student);
        } else {
            System.out.println("Subject not found");
        }
    }

    public static void removeStudentFromSubject(Student student, Subject subject){
        subjectStudents.get(subject).remove(student);
    }

    public static void printAllStudentsInSubjects(){
        subjectStudents.forEach((sub, stu) -> {
            System.out.println(sub);
            stu.forEach(s -> System.out.println(s));
        });
    }

}
