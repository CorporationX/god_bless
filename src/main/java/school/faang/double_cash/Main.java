package school.faang.double_cash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> studentsMap = new HashMap<>();
    private static Map<Subject, List<Student>> subjectsMap = new HashMap<>();
    private List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        Student firstStudent = new Student(1, "Gadhi");
        Student secondStudent = new Student(2, "Andrey");
        Student thirdStudent = new Student(3, "Vanya");

        Subject firstSubject = new Subject(1, "Math");
        Subject secondSubject = new Subject(2, "Geografic");
        Subject thirdSubject = new Subject(3, "english");

        Map<Subject, Integer> firstMap = new HashMap<>();
        firstMap.put(firstSubject, 3);
        Map<Subject, Integer> secondMap = new HashMap<>();
        secondMap.put(secondSubject, 4);
        Map<Subject, Integer> thirdMap = new HashMap<>();
        thirdMap.put(thirdSubject, 5);


        main.addStudent(firstStudent, firstMap);
        main.addStudent(secondStudent, secondMap);
        main.addStudent(thirdStudent, thirdMap);

        main.addSubjectForStudent(firstStudent, firstSubject, 6);

        main.removeStudent(thirdStudent);

        main.printAll();

        main.addSubject(firstSubject, firstStudent);
        main.addSubject(secondSubject, secondStudent);
        main.addSubject(thirdSubject, thirdStudent);

        main.addStudentForSubject(secondStudent, secondSubject);

        main.removeStudent(firstSubject, firstStudent);

        main.printAllSubjects();
    }

    public void addStudent(Student student, Map<Subject, Integer> subjectAssessment) {
        studentsMap.put(student, subjectAssessment);
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentsMap.get(student).put(subject, grade);
    }

    public void removeStudent(Student student) {
        studentsMap.remove(student);
    }

    public void printAll() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

    public void addSubject(Subject subject, Student student) {
        for (Student student1 : students) {
            if (!student.equals(student1)) {
                students.add(student);
            }
        }

        subjectsMap.put(subject, students);
    }

    public void addStudentForSubject(Student student, Subject subject) {
        subjectsMap.get(subject).add(student);
    }

    public void removeStudent(Subject subject, Student student) {
        subjectsMap.get(subject).remove(student);
    }

    public void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : subjectsMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
