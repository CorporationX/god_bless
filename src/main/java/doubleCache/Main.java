package doubleCache;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_GRADES = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_STUDENTS = new HashMap<>();

    public static void main(String[] args) {

    }

    /**
     *  добавление нового студента и его предметов с оценками
     * @param student
     * @param subject
     * @param grade
     */
    public static void addStudent(Student student, Subject subject, int grade) {}

    /**
     * добавление нового предмета для существующего студента с оценкой
     * @param subject
     */
    public static void addSubject(Subject subject) {}

    /**
     * удаление студента и его предметов с оценками
     * @param student
     */
    public static void removeStudent(Student student) {}

    /**
     * вывод списка всех студентов и их оценок по предметам
     */
    public static void printAllStudents() {}

    /**
     * добавление нового предмета и списка студентов, изучающих его
     * @param subject
     * @param students
     */
    public static void addSubject(Subject subject, List<Student> students) {}

    /**
     * добавление студента к существующему предмету
     * @param student
     * @param subject
     */
    public static void addStudentIntoSubject(Student student, Subject subject) {}

    /**
     * удаление студента из предмета
     * @param student
     * @param subject
     */
    public static void removeStudentFromSubject(Student student, Subject subject) {}

    /**
     * вывод списка всех предметов и студентов, изучающих их
     */
    public static void printAllSubjects() {}



}

