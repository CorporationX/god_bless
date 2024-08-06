package faang.school.godbless.BJS_19771;

import java.util.*;

public class Main {

    private static Map<Student, Map<Subject, Integer>> gradesBySubjects = new HashMap<>();
    private static Map<Subject, List<Student>> studentsBySubject = new HashMap<>();

    public static void main(String[] args) {
        Student mark = new Student(1, "Mark");
        Student max = new Student(1, "Max");
        Subject math = new Subject(5, "Math");
        Subject history = new Subject(5, "History");
        Subject biology = new Subject(5, "Biology");
        Subject algorithms = new Subject(4, "Algorithms");

        Map<Subject, Integer> markGrades = new HashMap<>(){{
            put(math, 5);
            put(history, 5);
            put(biology, 5);
        }};
        Map<Subject, Integer> maxGrades = new HashMap<>(){{
            put(math, 3);
            put(history, 4);
        }};

        addNewStudentWithGrade(mark, markGrades);
        addNewStudentWithGrade(max, maxGrades);
        addSubjectToStudent(max, algorithms, 5);
        removeStudent(mark);
        printAllStudentsAndGrades();

        List<Student> students = new ArrayList<>();
        students.add(mark);
        students.add(max);
        Subject chemistry = new Subject(5, "Chemistry");
        Student oliwia = new Student(3, "Oliwia");
        addSubjectWithStudents(chemistry, students);
        addStudentToSubject(chemistry, oliwia);
        deleteStudentFromSubject(chemistry, mark);
        printSubjectsAndStudents();
    }
    public static void addNewStudentWithGrade(Student student, Map<Subject, Integer> subjectsAndGrades){
        subjectsAndGrades.forEach((subject, grade) ->
                gradesBySubjects.computeIfAbsent(student, (k) -> new HashMap<>()).put(subject, grade));
    }

    public static void addSubjectToStudent(Student student, Subject newSubject, Integer newGrade){
        gradesBySubjects.computeIfAbsent(student, (x) -> new HashMap<>()).put(newSubject, newGrade);
    }

    public static void removeStudent(Student student){
        gradesBySubjects.remove(student);
        studentsBySubject.forEach((subject, listStudents) -> listStudents.removeIf(st -> st.equals(student)));
    }

    public static void printAllStudentsAndGrades(){
        gradesBySubjects.forEach((student, subjectsWithGrades) -> System.out.println(student + ": " + subjectsWithGrades));
    }

    public static void addSubjectWithStudents(Subject subject, List<Student> students){
        studentsBySubject.computeIfAbsent(subject, x -> new ArrayList<>()).addAll(students);
    }

    public static void addStudentToSubject(Subject subject, Student student){
        studentsBySubject.computeIfAbsent(subject, x -> new ArrayList<>()).add(student);
    }

    public static void deleteStudentFromSubject(Subject subject, Student student){
        studentsBySubject.get(subject).removeIf(student::equals);
    }

    public static void printSubjectsAndStudents(){
        studentsBySubject.forEach((subject, students) ->
                System.out.println(String.format("Subject: %s, students: %s", subject, students)));
    }
}
