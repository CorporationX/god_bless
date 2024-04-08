package twocash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> studentsSubjectGrades = new HashMap<>();
    private static Map<Subject, List<Student>> studentsBySubject = new HashMap<>();

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

        addStudentAndHisSubjects(vasya, vasyaSubj);
        addStudentAndHisSubjects(dima, dimaSubj);

        printAllStudentAndTheirSubjects();
        System.out.println();

        addStudentAndSubject(dima, chemistry, 6);

        printAllStudentAndTheirSubjects();
        System.out.println();

        removeStudentAndHisSubject(vasya);
        printAllStudentAndTheirSubjects();
        System.out.println();

        //Part2
        System.out.println("Part2");
        List<Student> students = new ArrayList<>();
        students.add(vasya);
        students.add(dima);
        addSubjectAndListOfStudents(math, students);
        printSubjectsAndTheirStudents();
        System.out.println();

        Student katya = new Student(3, "Katya");
        addStudentToSubject(math, katya);
        printSubjectsAndTheirStudents();
        System.out.println();

        removeStudentFromSubject(math, vasya);
        printSubjectsAndTheirStudents();
    }

    private static void addStudentAndHisSubjects(Student student, Map<Subject, Integer> map) {
        studentsSubjectGrades.put(student, map);
        for (Subject subject : map.keySet()) {
            if (studentsBySubject.containsKey(subject)) {
                addStudentToSubject(subject, student);
            } else {
                List<Student> studentInList = (new ArrayList<>());
                studentInList.add(student);
                addSubjectAndListOfStudents(subject, studentInList);
            }
        }
    }

    private static void addStudentAndSubject(Student student, Subject subject, Integer grade) {
        studentsSubjectGrades.get(student).put(subject, grade);
        if (studentsBySubject.containsKey(subject)) {
            addStudentToSubject(subject, student);
        } else {
            List<Student> studentInList = (new ArrayList<>());
            studentInList.add(student);
            addSubjectAndListOfStudents(subject, studentInList);
        }
    }

    private static void removeStudentAndHisSubject(Student student) {
        studentsSubjectGrades.remove(student);
    }

    private static void printAllStudentAndTheirSubjects() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsSubjectGrades.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().forEach(System.out::println);
        }
    }

    private static void addSubjectAndListOfStudents(Subject subject, List<Student> students) {
        studentsBySubject.put(subject, students);
        for (Student student : students) {
            if (studentsSubjectGrades.containsKey(student)) {
                studentsSubjectGrades.get(student).put(subject, 0);
            } else {
                Map<Subject, Integer> subjectAndGrade = new HashMap<>();
                subjectAndGrade.put(subject, 0);
                studentsSubjectGrades.put(student, subjectAndGrade);
            }
        }
    }

    private static void addStudentToSubject(Subject subject, Student student) {
        studentsBySubject.get(subject).add(student);
        if(studentsSubjectGrades.containsKey(student)){
            studentsSubjectGrades.get(student).put(subject, 0);
        }else{
            Map<Subject, Integer> subjectAndGrade = new HashMap<>();
            subjectAndGrade.put(subject, 0);
            studentsSubjectGrades.put(student, subjectAndGrade);
        }
    }

    private static void removeStudentFromSubject(Subject subject, Student student) {
        studentsBySubject.get(subject).remove(student);
    }

    private static void printSubjectsAndTheirStudents() {
        for (Map.Entry<Subject, List<Student>> entry : studentsBySubject.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
