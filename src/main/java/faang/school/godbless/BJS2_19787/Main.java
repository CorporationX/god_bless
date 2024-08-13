package faang.school.godbless.BJS2_19787;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    private static Map<Student, Map<Subject, Integer>> studentsAndTheirSubjects = new HashMap<>();
    private static Map<Subject, List<Student>> subjectsAndTheirStudentsList = new HashMap<>();

    private static void checkNewStudent(Student student) {
        if (studentsAndTheirSubjects.containsKey(student)) {
            throw new IllegalArgumentException("This student already exist");
        }
    }

    private static void addNewStudentAndHisSubjects(Student student, Map<Subject, Integer> subjectsAndGrades) {
        checkNewStudent(student);
        studentsAndTheirSubjects.put(student, subjectsAndGrades);
        for (Subject subject : subjectsAndGrades.keySet()) {
            subjectsAndTheirStudentsList.computeIfAbsent(subject, subjectKey -> new ArrayList<>()).add(student);
        }
    }

    private static void checkExistStudent(Student student) {
        if (!studentsAndTheirSubjects.containsKey(student)) {
            throw new IllegalArgumentException("This student does not exist");
        }
    }

    private static void addNewSubjectForExistStudent(Student student, Subject subject, int grade) {
        studentsAndTheirSubjects.get(student).putIfAbsent(subject, grade);
        addStudentToSubject(subject, student);
    }

    private static void removeStudent(Student student) {
        checkExistStudent(student);
        removeStudentFromList(student);
        studentsAndTheirSubjects.remove(student);
    }

    private static void viewAllStudents() {
        studentsAndTheirSubjects.forEach((student, subjects) -> {
            System.out.println(student.getName());
            subjects.forEach((subject, grade) -> System.out.println("\t" + subject.getName() + ": " + grade));
        });
    }

    private static void checkNewSubject(Subject subject) {
        if (subjectsAndTheirStudentsList.containsKey(subject)) {
            throw new IllegalArgumentException("This subject already exist");
        }
    }

    private static void addNewSubjectAndStudentsList(Subject subject, List<Student> students) {
        checkNewSubject(subject);
        subjectsAndTheirStudentsList.put(subject, students);
    }

    private static void addStudentToSubject(Subject subject, Student student) {
        List<Student> students = subjectsAndTheirStudentsList.computeIfAbsent(subject, subjectKey -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    private static void removeStudentFromList(Student student) {
        Map<Subject, Integer> subjectsAndGrades = studentsAndTheirSubjects.get(student);
        for (Subject subject : subjectsAndGrades.keySet()) {
            subjectsAndTheirStudentsList.computeIfPresent(subject, (subjectKey, students) -> students).remove(student);
        }
    }

    private static void viewAllSubjectsAndStudentLists() {
        subjectsAndTheirStudentsList.forEach((subject, students) -> {
            System.out.println(subject.getName());
            students.forEach(student -> System.out.println("\t" + student));
        });
    }

    public static void main(String[] args) {
        Student studentOne = new Student("John Doe");
        Student studentTwo = new Student("Jane Smith");

        Subject math = new Subject("Mathematics");
        Subject physics = new Subject("Physics");
        Subject chemist = new Subject("Chemistry");
        Subject literature = new Subject("Literature");
        Subject computer = new Subject("Computer Science");

        Map<Subject, Integer> studentOneMap = new HashMap<>(Map.of(
                math, 95,
                physics, 88,
                chemist, 92,
                literature, 85
        ));

        Map<Subject, Integer> studentTwoMap = new HashMap<>(Map.of(
                math, 85,
                physics, 90,
                chemist, 88,
                computer, 92
        ));

        addNewStudentAndHisSubjects(studentOne, studentOneMap);
        addNewStudentAndHisSubjects(studentTwo, studentTwoMap);
        removeStudent(studentOne);
        viewAllStudents();
        System.out.println();
        viewAllSubjectsAndStudentLists();
    }
}
