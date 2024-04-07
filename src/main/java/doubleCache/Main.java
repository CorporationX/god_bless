package doubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> STUDENTS_RATING = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECTS = new HashMap<>();

    public static void main(String[] args) {
        Map<Subject, Integer> map = new HashMap<>();
        Subject subject1 = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "Programming");
        Subject subject3 = new Subject(3, "System Analysis");
        Subject subject4 = new Subject(4, "System design");
        Subject subject5 = new Subject(5, "Economy");
        Subject subject6 = new Subject(6, "IoT");
        Subject subject7 = new Subject(7, "Geography");
        map.put(subject1, 3);
        map.put(subject2, 4);
        map.put(subject3, 3);
        map.put(subject4, 4);


        Student student1 = new Student(1, "Nick");
        Map<Subject, Integer> subjects = Map.of(subject1, 5, subject2, 5, subject3, 4, subject4, 5);
        addStudent(student1, subjects);
        Student student2 = new Student(2, "Paul");
        subjects = Map.of(subject1, 5, subject3, 4, subject4, 5, subject5, 3);
        addStudent(student2, subjects);
        Student student3 = new Student(3, "Anya");
        subjects = Map.of(subject2, 5, subject4, 5, subject5, 5);
        addStudent(student3, subjects);
        Student student4 = new Student(4, "Vadim");
        addStudent(student4, map);
        Student student5 = new Student(5, "TEST");


        printAllStudentsWithSubjectsAndGrades();

//        Добавляем предмет и оценку
        System.out.println("\n\n============After add subject and grade===========\n\n");
        addSubjectWithGrade(student4, subject5, 4);
        printAllStudentsWithSubjectsAndGrades();


//        Удаляем студента
        System.out.println("\n\n============After remove student===========\n\n");
        removeStudent(student1);
        printAllStudentsWithSubjectsAndGrades();

//        Добавляем список студентов к предмету
        System.out.println("\n\n============After add subject and student lis===========\n\n");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        addSubjectAndStudentList(subject7, students);
        printAllSubjectsAndStudentList();

//        Добавляем одного студента к предмету
        System.out.println("\n\n============After add student to subject===========\n\n");
        addSubjectAndStudentList(subject6, students);
        addStudentToSubject(subject6, student5);
        addStudentToSubject(subject7, student5);
        printAllSubjectsAndStudentList();
        System.out.println("\n\n============NEXT===========\n\n");

//        Удаляем студента от предмета
        System.out.println("\n\n============After delete student from subject===========\n\n");
        deleteStudentFromSubject(subject6, student5);
        deleteStudentFromSubject(subject7, student5);
        printAllSubjectsAndStudentList();
    }

    public static void addStudent(Student student, Map<Subject, Integer> subjects) {
        STUDENTS_RATING.put(student, subjects);
    }

    public static void addSubjectWithGrade(Student student, Subject subject, Integer grade) {
        STUDENTS_RATING.get(student).put(subject, grade);
    }

    public static void removeStudent(Student student) {
        STUDENTS_RATING.remove(student);
    }

    public static void printAllStudentsWithSubjectsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENTS_RATING.entrySet()) {
            System.out.println("Student name: " + entry.getKey().getName());
            System.out.println("===================================");
            for (Map.Entry<Subject, Integer> entrySubject : entry.getValue().entrySet()) {
                System.out.println("\nSubject name: " + entrySubject.getKey().getName() +
                        "\nGrade: " + entrySubject.getValue());
            }
            System.out.println("\n===================================");
        }
    }

    public static void addSubjectAndStudentList(Subject subject, List<Student> students) {
        SUBJECTS.put(subject, students);
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        if(!SUBJECTS.get(subject).contains(student)) {
            SUBJECTS.get(subject).add(student);
        }
    }

    public static void deleteStudentFromSubject(Subject subject, Student student) {
        SUBJECTS.get(subject).remove(student);
    }

    public static void printAllSubjectsAndStudentList() {
        for (Map.Entry<Subject, List<Student>> entry : SUBJECTS.entrySet()) {
            System.out.println("Subject name: " + entry.getKey().getName());
            System.out.println("===================================");
            for (Student student : entry.getValue()) {
                System.out.println("\nStudent ID: " + student.getId() +
                        "\nStudent name: " + student.getName());
            }
            System.out.println("\n===================================");
        }
    }
}
