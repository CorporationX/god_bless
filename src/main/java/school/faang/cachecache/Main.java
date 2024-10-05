package school.faang.cachecache;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();

    private static Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void main(String[] args) {
        Student studentAlex = new Student(1, "Alex");
        Student studentJohn = new Student(2, "John");
        Subject subject1 = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "Programming");

        addStudentWithSubjects(studentAlex, Map.of(subject1, 85, subject2, 90));
        addStudentWithSubjects(studentJohn, Map.of(subject1, 75));

        addSubjectToStudent(studentAlex, subject1, 88);

        printAllStudentsWithScores();

        addSubjectWithStudents(subject1, List.of(studentAlex, studentJohn));
        addStudentToSubject(studentJohn, subject2);

        printAllSubjectsWithStudents();

        removeStudent(studentAlex);

        removeStudentFromSubject(studentJohn, subject1);

        printAllStudentsWithScores();
        printAllSubjectsWithStudents();
    }

    public static void addStudentWithSubjects(Student student, Map<Subject, Integer> subjectsAndScores) {
        studentSubjects.put(student, new HashMap<>(subjectsAndScores));
        for (Map.Entry<Subject, Integer> entry : subjectsAndScores.entrySet()) {
            subjectStudents.putIfAbsent(entry.getKey(), new ArrayList<>());
            subjectStudents.get(entry.getKey()).add(student);
        }
    }

    public static void addSubjectToStudent(Student student, Subject subject, int score) {
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).put(subject, score);
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public static void removeStudent(Student student) {
        if (studentSubjects.containsKey(student)) {
            Map<Subject, Integer> subjects = studentSubjects.get(student);
            for (Subject subject : subjects.keySet()) {
                if (subjectStudents.containsKey(subject)) {
                    subjectStudents.get(subject).remove(student);
                }
            }
            studentSubjects.remove(student);
        }
    }

    public static void printAllStudentsWithScores() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.println("Студент: " + entry.getKey().getName());
            for (Map.Entry<Subject, Integer> subjectEntry : entry.getValue().entrySet()) {
                System.out.println("    Предмет: " + subjectEntry.getKey().getName() + ", Оценка: " + subjectEntry.getValue());
            }
        }
    }

    public static void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);  // null как начальная оценка
        }
    }

    public static void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, null);  // null как начальная оценка
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        if (subjectStudents.containsKey(subject)) {
            subjectStudents.get(subject).remove(student);
        }
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).remove(subject);
        }
    }

    public static void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Предмет: " + entry.getKey().getName());
            for (Student student : entry.getValue()) {
                System.out.println("    Студент: " + student.getName());
            }
        }
    }
}
