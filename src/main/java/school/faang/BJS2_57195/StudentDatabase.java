package school.faang.BJS2_57195;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private static Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private static Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public static void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public static void removeStudent(Student student) {
        studentSubjects.remove(student);
        subjectStudents.forEach((subject, students) -> {
            if (students.contains(student)) {
                students.remove(student);
            }
        });
    }

    public static void printAllSubjectsWithStudents() {
        studentSubjects.forEach((student, subjects) -> {
            System.out.println(student);
            studentSubjects.get(student).forEach((subject, grade) -> System.out.println(subject + " " + grade));
        });
    }


    public static void addSubjectsWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        students.forEach(student -> {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).putIfAbsent(subject, 0);
        });
    }

    public static void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, 0);

    }

    public static boolean removeStudentFromSubject(Student student, Subject subject) {

        int a = studentSubjects.size();
        int b = subjectStudents.get(subject).size();
        subjectStudents.get(subject).remove(student);
        studentSubjects.get(student).remove(subject);
        return a - 1 == studentSubjects.size() && b - 1 == subjectStudents.get(subject).size();
    }

    public static void printAllStudentsInSubjects() {
        subjectStudents.forEach((sub, stu) -> {
            System.out.println(sub);
            stu.forEach(s -> System.out.println(s));
        });
    }

}