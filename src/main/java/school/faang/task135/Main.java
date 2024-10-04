package school.faang.task135;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENTS_GRADE = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_STUDENT_GROUP_LIST = new HashMap<>();

    public void addNewStudent(Student student, HashMap<Subject, Integer> subject) {
        STUDENTS_GRADE.put(student, subject);
        for (Subject sub : subject.keySet()) {
            SUBJECT_STUDENT_GROUP_LIST.computeIfAbsent(sub, K -> new ArrayList<>()).add(student);
        }
    }

    public void addNewSubjectAndGradeToStudent(Student student, Subject subject, int grade) {
        STUDENTS_GRADE.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        SUBJECT_STUDENT_GROUP_LIST.computeIfAbsent(subject, K -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        for (Subject subject : STUDENTS_GRADE.get(student).keySet()) {
            SUBJECT_STUDENT_GROUP_LIST.get(subject).remove(student);
        }
        STUDENTS_GRADE.remove(student);
    }

    public void printAllInfoAboutStudent() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENTS_GRADE.entrySet()) {
            for (Map.Entry<Subject, Integer> secondEntry : entry.getValue().entrySet()) {
                System.out.println(entry.getKey().getName() + " " + secondEntry.getKey().getName() + " " + secondEntry.getValue());
            }
            System.out.println("=========================================================");
        }
    }

    public void addNewSubjectAndStudents(Subject subject, ArrayList<Student> students) {
        SUBJECT_STUDENT_GROUP_LIST.put(subject, students);
        for (Student student : students) {
            STUDENTS_GRADE.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
        }
    }

    public void addNewStudentToSubject(Subject subject, Student student) {
        SUBJECT_STUDENT_GROUP_LIST.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        STUDENTS_GRADE.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        SUBJECT_STUDENT_GROUP_LIST.get(subject).remove(student);
        STUDENTS_GRADE.get(student).remove(subject);
    }

    public void printAllSubjectAndStudent() {
        for (Map.Entry<Subject, List<Student>> entry : SUBJECT_STUDENT_GROUP_LIST.entrySet()) {
            for (Student student : entry.getValue()) {
                System.out.println(entry.getKey().getName() + " " + student.getName());
            }
            System.out.println("=========================================================");
        }
    }

    public static void main(String[] args) {
        Student firstStudent = new Student(0, "Ilya");
        Student secondStudent = new Student(1, "Ivan");
        Student thirdStudent = new Student(2, "Pavel");
        Student fourthStudent = new Student(3, "Roma");
        Student fifthStudent = new Student(4, "Stepan");
        Student sixthStudent = new Student(5, "Semen");

        Subject firstSubject = new Subject(0, "Alchemy");
        Subject secondSubject = new Subject(1, "Physics");
        Subject thirdSubject = new Subject(2, "Biology");

        Main main = new Main();
        HashMap<Subject, Integer> testMap = new HashMap<>();
        testMap.put(firstSubject, 5);
        main.addNewStudent(fifthStudent, testMap);
        main.printAllInfoAboutStudent();
        main.printAllSubjectAndStudent();
        System.out.println();

        main.addNewSubjectAndGradeToStudent(fifthStudent, secondSubject, 5);
        main.printAllInfoAboutStudent();
        main.printAllSubjectAndStudent();
        System.out.println();

        HashMap<Subject, Integer> secondTestMap = new HashMap<>();
        secondTestMap.put(firstSubject, 1);
        secondTestMap.put(secondSubject, 1);
        main.addNewStudent(firstStudent, secondTestMap);
        main.printAllInfoAboutStudent();
        main.printAllSubjectAndStudent();
        System.out.println();

        ArrayList<Student> students = new ArrayList<>();
        Stream.of(secondStudent, thirdStudent, fourthStudent)
                .forEach(students::add);
        main.addNewSubjectAndStudents(thirdSubject, students);
        main.printAllInfoAboutStudent();
        main.printAllSubjectAndStudent();
        System.out.println();

        main.addNewStudentToSubject(firstSubject, sixthStudent);
        main.printAllInfoAboutStudent();
        main.printAllSubjectAndStudent();
        System.out.println();

        main.removeStudentFromSubject(fourthStudent, thirdSubject);
        main.printAllInfoAboutStudent();
        main.printAllSubjectAndStudent();
        System.out.println();

        main.removeStudent(fifthStudent);
        main.printAllInfoAboutStudent();
        main.printAllSubjectAndStudent();

    }

}
