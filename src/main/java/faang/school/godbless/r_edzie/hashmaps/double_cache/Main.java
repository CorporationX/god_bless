package faang.school.godbless.r_edzie.hashmaps.double_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENTS_DIARY = new HashMap<>();
    private static final Map<Subject, List<Student>> GROUPED_BY_SUBJECT = new HashMap<>();


    public static void main(String[] args) {
        Student jon = new Student(1, "Jon");
        Student joe = new Student(2, "Joe");
        Student oleg = new Student(3, "Oleg");
        Student natasha = new Student(4, "Natasha");

        Subject math = new Subject(1, "Math");
        Subject programming = new Subject(2, "Programming");
        Subject bootcamp = new Subject(3, "Bootcamp");

        Grade gradeOfJonForMath = new Grade(jon, math, 5);
        Grade gradeOfJonForProgramming = new Grade(jon, programming, 4);

        Grade gradeOfOlegForMath = new Grade(oleg, math, 3);
        Grade gradeOfOlegForProgramming = new Grade(oleg, programming, 2);

        addStudentInfo(gradeOfJonForMath);
        addStudentInfo(gradeOfJonForProgramming);

        addStudentInfo(gradeOfOlegForMath);
        addStudentInfo(gradeOfOlegForProgramming);

        removeStudent(oleg);

        removeStudentFromSubject(gradeOfJonForMath);

        printAllStudentsDiary();
        System.out.println();
        printAllGroupedBySubject();
    }

    public static void addStudentInfo(Grade grade) {
        Student student = grade.getStudent();
        Subject subject = grade.getSubject();
        int mark = grade.getMark();

        STUDENTS_DIARY.computeIfAbsent((student), k -> new HashMap<>()).put(subject, mark);
        GROUPED_BY_SUBJECT.computeIfAbsent((subject), k -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Student student) {
        STUDENTS_DIARY.remove(student);
        GROUPED_BY_SUBJECT.forEach((subject, students) -> students.remove(student));
    }

    public static void removeStudentFromSubject(Grade grade) {
        Student foundStudent = grade.getStudent();
        Subject foundSubject = grade.getSubject();
        Map<Subject, Integer> diary = STUDENTS_DIARY.get(foundStudent);

        diary.remove(foundSubject);

        GROUPED_BY_SUBJECT.forEach((subject, students) -> {
            if (subject.equals(foundSubject)) {
                students.remove(foundStudent);
            }
        });
    }

    public static void printAllStudentsDiary() {
        STUDENTS_DIARY.forEach((student, subjectIntegerMap) -> {
            System.out.println(student.getName());
            subjectIntegerMap.forEach((subject, mark) -> System.out.println(subject.getName() + " : " + mark));
            System.out.println();
        });
    }

    public static void printAllGroupedBySubject() {
        GROUPED_BY_SUBJECT.forEach((subject, students) -> {
            System.out.print(subject.getName() + " ");
            students.forEach(student -> System.out.print(student.getName() + " "));
            System.out.println();
        });
    }
}
