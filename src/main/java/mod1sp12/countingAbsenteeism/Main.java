package mod1sp12.countingAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();
    private static Map<LearningStage, List<Student>> learningStages = new HashMap<>();

    public static Map<LearningStage, List<Student>> getLearningStageToStudentsMap(List<Student> students) {
        Map<LearningStage, List<Student>> learningStages = new HashMap<>();
        for (Student student : students) {
            learningStages.computeIfAbsent(new LearningStage(student.getFaculty(), student.getYear()), key -> new ArrayList<>()).add(student);
        }
        return learningStages;
    }

    public static void addStudent(Student student) {
        STUDENTS.add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        STUDENTS.remove(new Student(name, faculty, year));
    }

    public static List<Student> searchStudentByLearningStage(String faculty, int year) {
        return learningStages.get(new LearningStage(faculty, year));
    }

    public static void printAllStudentsByLearningStage() {
        for (Map.Entry<LearningStage, List<Student>> entry : learningStages.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        STUDENTS.addAll(List.of(
                new Student("John", "Computer science", 4),
                new Student("Max", "Physics", 1),
                new Student("Denis", "Mathematics", 3),
                new Student("Andrew", "Computer science", 4),
                new Student("Lion", "Computer science", 2),
                new Student("Albert", "Computer science", 4)
        ));
        learningStages = getLearningStageToStudentsMap(STUDENTS);

        for (Student student : STUDENTS) {
            System.out.println(student);
        }
        printAllStudentsByLearningStage();
        System.out.println();

        removeStudent("John", "Computer science", 4);
        removeStudent("Max", "Physics", 1);
        removeStudent("Lion", "Computer science", 2);
        for (Student student : STUDENTS) {
            System.out.println(student);
        }
        printAllStudentsByLearningStage();

        List<Student> studentList = searchStudentByLearningStage("Computer science", 4);
        System.out.println();
        System.out.println(studentList);
    }
}