package faang.school.godbless.javaHashMap.doubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollegeManager {
    private final Map<Student, Map<Subject, Integer>> studentMap; // Список студентов и их оценки по предметам
    private final Map<Subject, List<Student>> subjectMap; // Список предметов и студенты их изучающие

    public CollegeManager() {
        studentMap = new HashMap<>();
        subjectMap = new HashMap<>();

        Subject math = new Subject(0, "Math");
        Subject english = new Subject(1, "English");
        Subject history = new Subject(2, "History");

        Student oleg = new Student(0, "Oleg");
        Student vasya = new Student(1, "Vasya");
        Student yarik = new Student(2, "Yarik");
        Student alex = new Student(3, "Alex");
        Student ruslan = new Student(4, "Ruslan");
        Student danil = new Student(5, "Danil");
        Student elisey = new Student(6, "Elisey");


        //Заполнение списка студентов и их оценок
        Map<Subject, Integer> olegGrades = new HashMap<>();
        olegGrades.put(english, 4);
        addStudentWithGrades(oleg, olegGrades);

        Map<Subject, Integer> vasyaGrades = new HashMap<>();
        vasyaGrades.put(english, 5);
        vasyaGrades.put(history, 4);
        addStudentWithGrades(vasya, vasyaGrades);

        Map<Subject, Integer> yarikGrades = new HashMap<>();
        yarikGrades.put(math, 4);
        addStudentWithGrades(yarik, yarikGrades);

        Map<Subject, Integer> alexGrades = new HashMap<>();
        alexGrades.put(history, 5);
        addStudentWithGrades(alex, alexGrades);

        Map<Subject, Integer> ruslanGrades = new HashMap<>();
        ruslanGrades.put(math, 3);
        addStudentWithGrades(ruslan, ruslanGrades);

        Map<Subject, Integer> danilGrades = new HashMap<>();
        danilGrades.put(math, 5);
        addStudentWithGrades(danil, danilGrades);

        Map<Subject, Integer> eliseyGrades = new HashMap<>();
        eliseyGrades.put(history, 5);
        addStudentWithGrades(elisey, eliseyGrades);
    }

    //Also is able to add new grades to existing student
    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentMap.computeIfAbsent(student, subjectMap -> new HashMap<>()).putAll(grades);

        grades.forEach((subject, score) -> {
            addStudentToSubjectListeners(student, subject);
        });
    }

    public void addSubjectWithStudents(Subject subject, List<Student> subjectListeners) {
        subjectMap.computeIfAbsent(subject, value -> new ArrayList<>()).addAll(subjectListeners);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> removedStudentGrades = studentMap.remove(student);

        removedStudentGrades.forEach(((subject, integer) -> {
            List<Student> subjectListeners = subjectMap.get(subject);

            subjectListeners.remove(student);
        }));
    }

    public void addStudentToSubjectListeners(Student student, Subject subject) {
        subjectMap.computeIfAbsent(subject, subjectListeners -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubjectListeners(Student student, Subject subject) {
        List<Student> subjectListeners = subjectMap.get(subject);

        if (subjectListeners == null) {
            System.out.println("No such subject in storage!");
            return;
        }

        subjectListeners.remove(student);
    }

    public void printStudentsInfo() {
        System.out.println("Students info:");
        studentMap.forEach((student, grades) -> {
            System.out.println("Student " + student.getName() + " and his(her) grades:");

            grades.forEach(((subject, score) -> {
                System.out.println(subject.getName() + " - " + score + ";");
            }));
            System.out.println();
        });
    }

    public void printSubjectsInfo() {
        System.out.println("Subjects info:");
        subjectMap.forEach((subject, subjectListeners) -> {
            System.out.println("Subject " + subject.getName() + " and students assigned to it:");

            subjectListeners.forEach(student -> System.out.println(student.getName() + ";"));
            System.out.println();
        });
    }
}
