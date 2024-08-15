package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private static final Map<Student, Map<Subject, Integer>> STUDENT_MAP_MAP = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_LIST_MAP = new HashMap<>();
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("God Bless!");

        Student firstStudent = new Student(1, "Karl");
        Student secondStudent = new Student(2, "Oleg");
        Student thirdStudent = new Student(3, "Maria");

        Subject firstSubject = new Subject(1, "Math");
        Subject secondSubject = new Subject(2, "History");
        Subject thirdSubject = new Subject(3, "Litra");
        Subject fourthSubject = new Subject(4, "Fizra");
        Subject fifthSubject = new Subject(5, "Geometric");

        addStudentSubjects(firstStudent, addListGrade(addGrade(firstSubject, 4)));
        addStudentSubjects(firstStudent, addListGrade(addGrade(secondSubject, 3)));
        addStudentSubjects(firstStudent, addListGrade(addGrade(thirdSubject, 4)));
        addStudentSubjects(firstStudent, addListGrade(addGrade(fourthSubject, 5)));
        addStudentSubjects(firstStudent, addListGrade(addGrade(fifthSubject, 3)));

        addStudentSubjects(secondStudent, addListGrade(addGrade(firstSubject, 3)));
        addStudentSubjects(secondStudent, addListGrade(addGrade(secondSubject, 2)));
        addStudentSubjects(secondStudent, addListGrade(addGrade(thirdSubject, 2)));
        addStudentSubjects(secondStudent, addListGrade(addGrade(fourthSubject, 4)));
        addStudentSubjects(secondStudent, addListGrade(addGrade(fifthSubject, 5)));

        addStudentSubjects(thirdStudent, addListGrade(addGrade(firstSubject, 5)));
        addStudentSubjects(thirdStudent, addListGrade(addGrade(secondSubject, 4)));
        addStudentSubjects(thirdStudent, addListGrade(addGrade(thirdSubject, 4)));
        addStudentSubjects(thirdStudent, addListGrade(addGrade(fourthSubject, 5)));
        addStudentSubjects(thirdStudent, addListGrade(addGrade(fifthSubject, 5)));

//        getAllStudents();
//
//        removeStudent(firstStudent);
//
//        getAllStudents();

        addStudent(firstStudent);
        addStudent(secondStudent);
        addStudent(thirdStudent);

        addSubjectListStudent(firstSubject, STUDENTS);
        addSubjectListStudent(secondSubject, STUDENTS);
        addSubjectListStudent(thirdSubject, STUDENTS);
        addSubjectListStudent(fourthSubject, STUDENTS);
        addSubjectListStudent(fifthSubject, STUDENTS);



        removeStudentSubjectList(secondStudent, secondSubject);

        getAllSubjectsStudents();

    }

    public static Map<Subject, Integer> addGrade(Subject subject, int grade) {
        Map<Subject, Integer> subjectGrade = new HashMap<>();
        subjectGrade.put(subject, grade);
        return subjectGrade;
    }

    public static List<Map<Subject, Integer>> addListGrade(Map<Subject, Integer> subjectGrade) {
        List<Map<Subject, Integer>> listGrade = new ArrayList<>();
        listGrade.add(subjectGrade);
        return listGrade;
    }

    public static void addStudentSubjects(Student student, List<Map<Subject, Integer>> subjectInteger) {
        for (Map<Subject, Integer> subject : subjectInteger) {
            if (STUDENT_MAP_MAP.containsKey(student)) {
                for (Map.Entry<Subject, Integer> pair : subject.entrySet()) {
                    STUDENT_MAP_MAP.get(student).put(pair.getKey(), pair.getValue());
                }
            } else {
                STUDENT_MAP_MAP.put(student, subject);
            }
        }
    }

    public static void removeStudent(Student student) {
        STUDENT_MAP_MAP.remove(student);
    }

    public static void getAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> pair : STUDENT_MAP_MAP.entrySet()) {
            System.out.println(pair.getKey());
            for (Map.Entry<Subject, Integer> pairSubj : pair.getValue().entrySet()) {
                System.out.println("\t" + pairSubj.getKey() + pairSubj.getValue().toString());
            }
            System.out.println();
        }
    }

    public static void addStudent(Student student) {
        STUDENTS.add(student);
    }

    public static void addSubjectListStudent(Subject subject, List<Student> students) {
        SUBJECT_LIST_MAP.put(subject, students);
    }

    public static void addStudentInSubject(Student student, Subject subject) {
        if (SUBJECT_LIST_MAP.containsKey(subject)) {
            SUBJECT_LIST_MAP.get(subject).add(student);
        }
    }

    public static void removeStudentSubjectList(Student student, Subject subject) {
        if (SUBJECT_LIST_MAP.containsKey(subject)) {
            SUBJECT_LIST_MAP.get(subject).remove(student);
        }
    }

    public static void getAllSubjectsStudents() {
        for (Map.Entry<Subject, List<Student>> pair : SUBJECT_LIST_MAP.entrySet()) {
            System.out.println(pair.getKey());
            for (Student student : pair.getValue()) {
                System.out.println(student);
            }
            System.out.println();
        }
    }

}
