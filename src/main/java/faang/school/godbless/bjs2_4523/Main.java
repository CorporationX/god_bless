package faang.school.godbless.bjs2_4523;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class Main {

    private static final Map<Student, Map<Subject, Integer>> studentSubjMap = new HashMap<>();
    private static final Map<Subject, List<Student>> subjectListMap = new HashMap<>();

    public static void main(String[] args) {
        Student vasya = new Student(1, "Vasya");
        Student dima = new Student(2, "Dima");

        Subject math = new Subject(1, "Math");
        Subject history = new Subject(2, "History");
        Subject english = new Subject(3, "English");
        Subject physic = new Subject(4, "Physic");
        Subject chemistry = new Subject(5, "Chemistry");

        Map<Subject, Integer> vasyaSubj = new HashMap<>();
        vasyaSubj.put(math, 7);
        vasyaSubj.put(history, 8);
        vasyaSubj.put(english, 10);

        Map<Subject, Integer> dimaSubj = new HashMap<>();
        dimaSubj.put(math, 5);
        dimaSubj.put(physic, 9);
        dimaSubj.put(english, 9);

        //add Student and his subjects
        addStudentAndHisSubjects(vasya, vasyaSubj);
        addStudentAndHisSubjects(dima, dimaSubj);

        //Print all students
        printAllStudentsWithGrades();

        //add New subj for student Dima
        addSubjectForStudent(dima, chemistry, 6);

        //Print all students
        printAllStudentsWithGrades();

        //remove Vasya
        removeStudentWithSubjects(vasya);
        printAllStudentsWithGrades();

        //Part2
        //Add new subject in Map2 and Students list
        List<Student> students = new ArrayList<>();
        students.add(vasya);
        students.add(dima);
        addSubjectWithStudents(math, students);

        printListSubjectsWithStudents();

        //Add Student to subject
        Student katya = new Student(3, "Katya");
        addStudentToSubject(english, katya);
        printListSubjectsWithStudents();

        //Remove Vasya from math
        removeStudentFromSubject(math, vasya);
        printListSubjectsWithStudents();
    }


    public static void addStudentAndHisSubjects(Student student, Map<Subject, Integer> subjectsMap) {
        studentSubjMap.put(student, subjectsMap);
    }

    public static void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        log.info("Add new subject for {}", student.getName());
        studentSubjMap.computeIfAbsent(student, key -> new HashMap<>()).put(subject, grade);
    }

    public static void removeStudentWithSubjects(Student student) {
        if (studentSubjMap.remove(student) != null) {
            log.info("Student {} was removed from cache", student.getName());
        }
    }

    public static void printAllStudentsWithGrades() {
        log.info("Print all students with grades");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjMap.entrySet()) {
            System.out.println(entry.getKey().getName());
            entry.getValue().entrySet().forEach(System.out::println);
        }
    }

    public static void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectListMap.put(subject, students);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        log.info("Add student {} to {}", student.getName(), subject.name());
        subjectListMap.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        if(Objects.requireNonNull(subjectListMap.computeIfPresent(subject, (key, value) -> value))
                .remove(student)) {
            log.info("Student {} was removed from subject {}", student.getName(), subject.name());
        }
    }

    public static void printListSubjectsWithStudents() {
        log.info("Print all subjects with students");
        for (Map.Entry<Subject, List<Student>> entry : subjectListMap.entrySet()) {
            System.out.println(entry.getKey().name());
            entry.getValue().forEach(System.out::println);
        }
    }

}
