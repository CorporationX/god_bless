package double_cache_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final HashMap<Student, Map<Subject, Integer>> studentMarksMap = new HashMap<>();
    private static final HashMap<Subject, List<Student>> subjectsStudentsMap = new HashMap<>();

    public static void main(String[] args) {
        HashMap<String, Subject> subjects = new HashMap<>();
        subjects.put("Maths", new Subject(1L, "Maths"));
        subjects.put("Computer Science", new Subject(2L, "Computer Science"));
        subjects.put("English", new Subject(3L, "English"));
        subjects.put("PE", new Subject(4L, "PE"));

        addStudentAndMarks(new Student(1L, "Vitaly"),
                Map.of(subjects.get("Maths"), 5,
                subjects.get("Computer Science"), 5,
                subjects.get("PE"), 5));
        addStudentAndMarks(new Student(2L, "Egor"),
                Map.of(subjects.get("Maths"), 5,
                        subjects.get("Computer Science"), 4,
                        subjects.get("PE"), 3));
        addSubjectWithMark(new Student(1L, "Vitaly"), new Subject(5L, "History"), 4);
        printInfoAboutAllStudentsMarks();
        removeStudentAndMarks(new Student(2L, "Egor"));
        printInfoAboutAllStudentsMarks();

        addSubjectsAndStudents(subjects.get("Maths"),
                List.of(new Student(2L, "Egor") ,new Student(1L, "Vitaly")));
        addStudentToSubject(new Student(3L, "Sveta"),subjects.get("Maths"));
        printInfoAboutAllSubjects();
        removeStudentFromSubject(new Student(3L, "Sveta"), subjects.get("Maths"));
        printInfoAboutAllSubjects();

    }

    public static void addStudentAndMarks(Student student,
                                          Map<Subject, Integer> marks) {
        studentMarksMap.put(student, marks);
    }

    public static void removeStudentAndMarks(Student student) {
        studentMarksMap.remove(student);
    }

    public static void addSubjectWithMark(Student student, Subject subject, int mark) {
        Map<Subject, Integer> marks = new HashMap<>(Map.copyOf(studentMarksMap.get(student)));
        marks.put(subject, mark);
        studentMarksMap.put(student, marks);
    }

    public static void printInfoAboutAllStudentsMarks() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentMarksMap.entrySet()) {
            Student student = entry.getKey();
            sb.append("Студент %s%n".formatted(student.getName()));
            for (Map.Entry<Subject, Integer> subjectMarkEntry : entry.getValue().entrySet()) {
                sb.append("* Предмет %s: ".formatted(subjectMarkEntry.getKey()))
                        .append("оценка - %d%n".formatted(subjectMarkEntry.getValue()));

            }
        }
        System.out.println(sb);
    }

    public static void addSubjectsAndStudents(Subject subject, List<Student> students) {
        subjectsStudentsMap.put(subject, students);
    }

    public static void addStudentToSubject(Student student, Subject subject) {
        List<Student> students = new ArrayList<>(List.copyOf(subjectsStudentsMap.get(subject)));
        students.add(student);
        subjectsStudentsMap.put(subject, students);
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        subjectsStudentsMap.get(subject).remove(student);
    }

    public static void printInfoAboutAllSubjects() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Subject, List<Student>> entry : subjectsStudentsMap.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();
            sb.append("Предмет %s - студенты: %s%n".formatted(subject.getName(),students));
        }
        System.out.println(sb);
    }
}
