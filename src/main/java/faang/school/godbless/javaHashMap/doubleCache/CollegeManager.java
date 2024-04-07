package faang.school.godbless.javaHashMap.doubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

        grades.forEach((subject, score) -> addStudentToSubjectListeners(student, subject));
    }

    public void addSubjectWithStudents(Subject subject, List<Student> subjectListeners) {
        subjectMap.computeIfAbsent(subject, value -> new ArrayList<>()).addAll(subjectListeners);
    }

    public void removeStudent(int id) {
        var studentToBeRemoved = getStudentById(id);

        if (studentToBeRemoved.isEmpty()) {
            System.out.println("No such student in system storage!");

            return;
        }

        Map<Subject, Integer> removedStudentGrades = studentMap.remove(studentToBeRemoved.get());

        removedStudentGrades.forEach(((subject, integer) -> {
            List<Student> subjectListeners = subjectMap.get(subject);

            subjectListeners.remove(studentToBeRemoved.get());
        }));
    }

    public void addStudentToSubjectListeners(Student student, Subject subject) {
        subjectMap.computeIfAbsent(subject, subjectListeners -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubjectListeners(int studentId, int subjectId) {
        var studentToBeRemoved = getStudentById(studentId);

        if (studentToBeRemoved.isEmpty()) {
            System.out.println("No such student in system storage!");

            return;
        }

        var subject = getSubjectById(subjectId);

        if (subject.isEmpty()) {
            System.out.println("No such subject in system storage!");

            return;
        }


        List<Student> subjectListeners = subjectMap.get(subject.get());

        if (subjectListeners == null) {
            System.out.println("No such subject in storage!");
            return;
        }

        subjectListeners.remove(studentToBeRemoved.get());
    }

    public void printStudentsInfo() {
        System.out.println("Students info:");
        studentMap.forEach((student, grades) -> {
            System.out.println("Student " + student.name() + " and his(her) grades:");

            grades.forEach(((subject, score) -> {
                System.out.println(subject.name() + " - " + score + ";");
            }));
            System.out.println();
        });
    }

    public void printSubjectsInfo() {
        System.out.println("Subjects info:");
        subjectMap.forEach((subject, subjectListeners) -> {
            System.out.println("Subject " + subject.name() + " and students assigned to it:");

            subjectListeners.forEach(student -> System.out.println(student.name() + ";"));
            System.out.println();
        });
    }

    public Optional<Student> getStudentById(int id) {
        for (Student student : studentMap.keySet()) {
            if (student.id() == id) {
                return Optional.of(student);
            }
        }

        return Optional.empty();
    }

    public Optional<Subject> getSubjectById(int id) {
        for (Subject subject : subjectMap.keySet()) {
            if (subject.id() == id) {
                return Optional.of(subject);
            }
        }

        return Optional.empty();
    }
}
