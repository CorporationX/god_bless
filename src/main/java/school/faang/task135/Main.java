package school.faang.task135;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> students_Grade = new HashMap<>();
    private static final Map<Subject, List<Student>> subjectStudentsGroupList = new HashMap<>();

    public void addNewStudent(Student student, HashMap<Subject, Integer> studentsGrade) {
        students_Grade.put(student, studentsGrade);
        for (Subject sub : studentsGrade.keySet()) {
            subjectStudentsGroupList.computeIfAbsent(sub, K -> new ArrayList<>()).add(student);
        }
    }

    public void addNewSubjectAndGradeToStudent(Student student, Subject subject, int grade) {
        students_Grade.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectStudentsGroupList.computeIfAbsent(subject, K -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        for (Subject subject : students_Grade.get(student).keySet()) {
            subjectStudentsGroupList.get(subject).remove(student);
        }
        students_Grade.remove(student);
    }

    public void printAllInfoAboutStudent() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : students_Grade.entrySet()) {
            for (Map.Entry<Subject, Integer> secondEntry : entry.getValue().entrySet()) {
                System.out.println(entry.getKey().getName() + " " + secondEntry.getKey().getName() + " " + secondEntry.getValue());
            }
            System.out.println("=========================================================");
        }
    }

    public void addNewSubjectAndStudents(Subject subject, ArrayList<Student> students) {
        subjectStudentsGroupList.put(subject, students);
        for (Student student : students) {
            students_Grade.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
        }
    }

    public void addNewStudentToSubject(Subject subject, Student student) {
        subjectStudentsGroupList.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        students_Grade.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        subjectStudentsGroupList.get(subject).remove(student);
        students_Grade.get(student).remove(subject);
    }

    public void printAllSubjectAndStudent() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudentsGroupList.entrySet()) {
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
