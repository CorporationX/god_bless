package faang.school.godbless.task_16_double_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> studentGradeMap = new HashMap<>();
    private static final Map<Subject, List<Student>> subjectStudentsMap = new HashMap<>();

    public static void main(String[] args) {
        // Создание студентов
        int studentCount = 0;
        Student studentSerg = new Student(++studentCount, "Serg");
        Student studentKate = new Student(++studentCount, "Kate");
        Student studentMary = new Student(++studentCount, "Mary");

        // Создание учебных дисциплин
        int subjectCount = 0;
        Subject subjectGeogrphy = new Subject(++subjectCount, "Geography");
        Subject subjectMath = new Subject(++subjectCount, "Math");
        Subject subjectEnglish = new Subject(++subjectCount, "English");

        // Добавление студентов, дисциплин и студенческих оценок по ним в Map'у
        addToUserSubjectWithGrade(studentSerg, subjectGeogrphy, 4);
        addToUserSubjectWithGrade(studentSerg, subjectMath, 5);
        addToUserSubjectWithGrade(studentSerg, subjectEnglish, 3);
        addToUserSubjectWithGrade(studentKate, subjectGeogrphy, 4);
        addToUserSubjectWithGrade(studentKate, subjectMath, 5);
        addToUserSubjectWithGrade(studentKate, subjectEnglish, 5);
        addToUserSubjectWithGrade(studentMary, subjectGeogrphy, 4);
        addToUserSubjectWithGrade(studentMary, subjectMath, 4);
        addToUserSubjectWithGrade(studentMary, subjectEnglish, 4);

        // Вывод все студентов, с их предметами и оценками
        System.out.println("Вывод успеваемости студентов");
        showStudentGrade();

        // Удаление студента
        System.out.println("\nСтудент \"Serg\" удалён\n");
        deleteStudent(studentSerg);
        showStudentGrade();

        // Добавление дисциплин и студентов их изучающих в Map'y
        List<Student> students = new ArrayList<>(List.of(studentSerg, studentKate, studentMary));
        addSubjectWithStudents(subjectEnglish, students);
        addSubjectWithStudents(subjectMath, students);
        addSubjectWithStudents(subjectGeogrphy, new ArrayList<>(List.of(studentSerg, studentKate)));

        // Добавление студента к существующему предмету.
        addStudentToSubject(subjectGeogrphy, studentMary);

        // Добавление студента к существующему предмету.
        deleteStudentFromSubject(subjectGeogrphy, studentSerg);

        // Вывод учебных дициплин и студентов их изучающих
        System.out.println("\nВывод учебных дисциплин и студентов");
        showSubjectWithStudents();

    }

    private static void showSubjectWithStudents() {
        for (var entry : subjectStudentsMap.entrySet()) {
            System.out.println(entry.getKey().name());
            for (Student student : entry.getValue()) {
                System.out.println("\t" + student.name());
            }
        }
    }

    /**
     * Удаление студента из списка изучающих учебую дисциплину.
     *
     * @param subject
     * @param student
     */
    private static void deleteStudentFromSubject(Subject subject, Student student) {
        subjectStudentsMap.get(subject).remove(student);
    }

    /**
     * Добавление студента в список изучающих дисциплину
     *
     * @param subject
     * @param student
     */
    private static void addStudentToSubject(Subject subject, Student student) {
        List<Student> students = subjectStudentsMap.get(subject);
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    /**
     * Добавление предмета и списка студентов изучающих его.
     *
     * @param subject
     * @param students
     */
    private static void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudentsMap.put(subject, students);
    }

    /**
     * Удаляет студента из Map
     *
     * @param studentSerg
     */
    private static void deleteStudent(Student studentSerg) {
        studentGradeMap.remove(studentSerg);
    }

    /**
     * Выводит информацию о студентах, их дисциплинах и успеваемости.
     */
    private static void showStudentGrade() {
        for (Student student : studentGradeMap.keySet()) {
            System.out.println(student.name());
            for (var e : studentGradeMap.get(student).entrySet()) {
                System.out.printf("\tsubject: %s, grade: %d.\n", e.getKey().name(), e.getValue());
            }
        }
    }

    /**
     * Добавление студена, его предмета и оценки по нему в Map'у
     *
     * @param student
     * @param subject
     * @param grade
     */
    private static void addToUserSubjectWithGrade(Student student, Subject subject, int grade) {
        if (!studentGradeMap.containsKey(student)) {
            studentGradeMap.put(student, new HashMap<>());
        }
        studentGradeMap.get(student).put(subject, grade);
    }
}
