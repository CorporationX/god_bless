package school.faang.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> SUBJECT_GRADES_OF_STUDENT = new HashMap<>();
    private static final Map<Subject, List<Student>> STUDENTS_OF_SUBJECT = new HashMap<>();

    public static void main(String[] args) {
        Student alex = new Student(1L, "Alex");
        Student ann = new Student(2L, "Ann");
        Student lisa = new Student(3L, "Lisa");
        Subject math = new Subject(1L, "Math");
        Subject english = new Subject(2L, "English");
        Subject history = new Subject(3L, "History");
        Subject chemistry = new Subject(4L, "Chemistry");
        Map<Subject, Integer> alexGrades = new HashMap<>() {{
            put(math, 5);
            put(english, 5);
        }};
        Map<Subject, Integer> annGrades = new HashMap<>() {{
            put(math, 4);
            put(history, 4);
        }};
        Map<Subject, Integer> lisaGrades = new HashMap<>() {{
            put(english, 3);
            put(history, 4);
        }};

        addNewStudent(alex, alexGrades);
        addNewStudent(ann, annGrades);
        addNewStudent(lisa, lisaGrades);
        printAllStudentsWithGrades();
        deleteStudent(lisa);
        printAllStudentsWithGrades();
        addNewSubjectWithStudents(chemistry, List.of(ann, alex));
        printAllSubjectsWithStudents();
        addNewStudent(lisa, lisaGrades);
        printAllStudentsWithGrades();
        addStudentToSubject(lisa, chemistry);
        printAllSubjectsWithStudents();
        removeStudentFromSubject(ann, math);
        removeStudentFromSubject(ann, english);
        printAllSubjectsWithStudents();
    }

    public static void addNewStudent(Student student, Map<Subject, Integer> subjectGrades) {
        if (!SUBJECT_GRADES_OF_STUDENT.containsKey(student)) {
            SUBJECT_GRADES_OF_STUDENT.put(student, subjectGrades);
            for (Subject subject : subjectGrades.keySet()) {
                STUDENTS_OF_SUBJECT.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
            }
        }
    }

    public static void addNewSubjectWithGrade(Student student, Subject subject, Integer grade) {
        if (!STUDENTS_OF_SUBJECT.containsKey(subject)) {
            SUBJECT_GRADES_OF_STUDENT.computeIfPresent(student, (k, v) -> {
                v.put(subject, grade);
                STUDENTS_OF_SUBJECT.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
                return v;
            });
        }
    }

    public static void deleteStudent(Student student) {
        SUBJECT_GRADES_OF_STUDENT.remove(student);
        STUDENTS_OF_SUBJECT.values().forEach(students -> students.remove(student));
    }

    public static void printAllStudentsWithGrades() {
        System.out.println(SUBJECT_GRADES_OF_STUDENT);
    }

    public static void addNewSubjectWithStudents(Subject subject, List<Student> students) {
        if (!STUDENTS_OF_SUBJECT.containsKey(subject)) {
            for (Student student : students) {
                addNewSubjectWithGrade(student, subject, null);
            }
        }
    }

    public static void addStudentToSubject(Student student, Subject subject) {
        SUBJECT_GRADES_OF_STUDENT.computeIfPresent(student, (k, v) -> {
            v.put(subject, 0);
            STUDENTS_OF_SUBJECT.computeIfPresent(subject, (z, x) -> {
                x.add(student);
                return x;
            });
            return v;
        });
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        SUBJECT_GRADES_OF_STUDENT.computeIfPresent(student, (k, v) -> {
            v.remove(subject);
            STUDENTS_OF_SUBJECT.computeIfPresent(subject, (z, x) -> {
                x.remove(student);
                return x;
            });
            return v;
        });
    }

    public static void printAllSubjectsWithStudents() {
        System.out.println(STUDENTS_OF_SUBJECT);
    }
}
