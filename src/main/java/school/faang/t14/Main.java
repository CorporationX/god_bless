package school.faang.t14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /* MAP - список предметов и оценок студента по каждому предмету*/
    public static final HashMap<Student, Map<Subject, Integer>> STUDENTS = new HashMap<>();
    /* MAP - список студентов, изучающих данный предмет*/
    public static final HashMap<Subject, List<Student>> SUBJECTS_OF_STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        Student studentOne = new Student(1, "Vasya");
        Student studentTwo = new Student(2, "Pasha");
        Student studentTree = new Student(3, "Dasha");

        Subject biology = new Subject(1, "biology");
        Subject math = new Subject(2, "math");
        Subject tech = new Subject(3, "tech");
        Subject physics = new Subject(4, "physics");

        main.addStudent(studentOne, Map.of(math, 3, tech, 4));
        main.addStudent(studentTwo, Map.of(math, 5, biology, 5));
        main.addStudent(studentTree, Map.of(math, 4, biology, 4));
        main.addSubject(physics, List.of(studentOne, studentTwo));
        System.out.println("____________________________________");
        main.printAllSubjectsAndStudents();
        main.removeStudentFromSubject(studentTree, math);
        System.out.println("____________________________________");
        main.printAllSubjectsAndStudents();
        System.out.println("____________________________________");
        main.printAllStudentsAndGrades();
    }

    public void addStudent(Student student, Map<Subject, Integer> grades) {
        STUDENTS.put(student, new HashMap<>(grades));
        for (Subject subject : grades.keySet()) {
            addStudentToSubject(student, subject);
        }
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        STUDENTS.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        addStudentToSubject(student, subject);
    }

    public void addSubject(Subject subject, List<Student> students) {
        SUBJECTS_OF_STUDENTS.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            addSubjectToStudent(student, subject, 4);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        SUBJECTS_OF_STUDENTS.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = SUBJECTS_OF_STUDENTS.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> studentSubjects = STUDENTS.get(student);
        if (studentSubjects != null) {
            studentSubjects.remove(subject);
        }
    }

    public void printAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : SUBJECTS_OF_STUDENTS.entrySet()) {
            System.out.println(entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("  " + student);
            }
        }

    }

    public void printAllStudentsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENTS.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<Subject, Integer> gradeEntry : entry.getValue().entrySet()) {
                System.out.println("  " + gradeEntry.getKey() + ": " + gradeEntry.getValue());
            }
        }
    }
}