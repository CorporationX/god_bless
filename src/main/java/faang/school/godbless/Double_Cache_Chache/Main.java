package faang.school.godbless.Double_Cache_Chache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Student, Map<Subject,Integer>> marksOfStudentMap = new HashMap<>();
    public static Map<Subject, List<Student>> studentsThatStudySubject = new HashMap<>();
    public static void addNewStudent(Student student) {
        Map<Subject,Integer> marksOfSubjects = new HashMap<>();
        marksOfStudentMap.put(student,marksOfSubjects);
    }
    public static void addSubjectToStudent(Student student,Subject subject,int mark) {
        marksOfStudentMap.get(student).put(subject,mark);
    }
    public static void removeStudent(Student student) {
        marksOfStudentMap.remove(student);
    }
    public static void printAllStudentsInfo() {
        for (Map.Entry<Student,Map<Subject,Integer>> entry : marksOfStudentMap.entrySet()) {
            System.out.println("Студент: " + entry.getKey().getName());
            for (Map.Entry<Subject,Integer> entry2 : entry.getValue().entrySet()) {
                System.out.println("Предмет: " + entry2.getKey().getName() + " - оценка - " + entry2.getValue());
            }
        }
    }
    public static void addNewSubject(Subject subject) {
        List<Student> list = new ArrayList<>();
        studentsThatStudySubject.put(subject,list);
    }
    public static void addStudentToSubject(Student student,Subject subject) {
        studentsThatStudySubject.get(subject).add(student);
    }
    public static void removeStudentFromSubject(Student student,Subject subject) {
        studentsThatStudySubject.get(subject).remove(student);
    }
    public static void printAllSubjectStudents() {
        for (Map.Entry<Subject,List<Student>> entry : studentsThatStudySubject.entrySet()) {
            System.out.println("Предмет: " + entry.getKey().getName());
            for (Student student : entry.getValue()) {
                System.out.println("Студент: " + student.getName());
            }
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Student student3 = new Student(3, "Charlie");
        Student student4 = new Student(4, "David");
        Student student5 = new Student(5, "Eva");
        Student student6 = new Student(6, "Frank");
        Student student7 = new Student(7, "Grace");
        Student student8 = new Student(8, "Henry");
        Student student9 = new Student(9, "Ivy");
        Student student10 = new Student(10, "Jack");
        addNewStudent(student1);
        addNewStudent(student2);
        addNewStudent(student3);
        addNewStudent(student4);
        addNewStudent(student5);
        addNewStudent(student6);
        addNewStudent(student7);
        addNewStudent(student8);
        addNewStudent(student9);
        addNewStudent(student10);
        Subject subject1 = new Subject(101, "Mathematics");
        Subject subject2 = new Subject(102, "Physics");
        Subject subject3 = new Subject(103, "Chemistry");
        Subject subject4 = new Subject(104, "Biology");
        Subject subject5 = new Subject(105, "Computer Science");
        addNewSubject(subject1);
        addNewSubject(subject2);
        addNewSubject(subject3);
        addNewSubject(subject4);
        addNewSubject(subject5);
        addSubjectToStudent(student1,subject1,5);
        addSubjectToStudent(student2,subject1,4);
        addSubjectToStudent(student3,subject2,3);
        addSubjectToStudent(student4,subject2,2);
        addSubjectToStudent(student5,subject3,5);
        addSubjectToStudent(student6,subject4,5);
        addSubjectToStudent(student7,subject4,3);
        addSubjectToStudent(student8,subject5,4);
        addSubjectToStudent(student9,subject5,2);
        addSubjectToStudent(student10,subject2,2);
        addSubjectToStudent(student1,subject2,4);
        addStudentToSubject(student1,subject1);
        addStudentToSubject(student2,subject1);
        addStudentToSubject(student3,subject2);
        addStudentToSubject(student4,subject2);
        addStudentToSubject(student5,subject3);
        addStudentToSubject(student6,subject4);
        addStudentToSubject(student7,subject4);
        addStudentToSubject(student8,subject5);
        addStudentToSubject(student9,subject5);
        addStudentToSubject(student10,subject2);
        addStudentToSubject(student1,subject2);
        printAllStudentsInfo();
        printAllSubjectStudents();
        removeStudent(student1);
        removeStudentFromSubject(student1,subject1);
        removeStudentFromSubject(student1,subject2);
    }
}
