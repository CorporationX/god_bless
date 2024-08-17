package faang.school.godbless.Maps.BJS2_19970;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> studentGradeMap = new HashMap<>();
    private static Map<Subject, List<Student>> subjectListMap = new HashMap<>();
    public static void main(String[] args) {
        Student studentMax = new Student("Max");
        Student studentTom = new Student("Tom");
        Student studentEli = new Student("Eli");
        Subject math = new Subject("Math");
        Subject chemistry = new Subject("Chemistry");
        Subject ecomomic = new Subject("Economic");
        Subject history = new Subject("History");
        Subject art = new Subject("Art");

        addSubjectForStudent(studentMax, math, 5);
        addSubjectForStudent(studentMax, chemistry, 3);
        addSubjectForStudent(studentMax, ecomomic, 4);

        Map<Subject, Integer> subjectWithGrades = new HashMap<>();
        subjectWithGrades.put(history, 3);
        subjectWithGrades.put(art, 5);
        addSubjectForStudent(studentMax, subjectWithGrades);
        addSubjectForStudent(studentTom, subjectWithGrades);
        addSubjectForStudent(studentTom, chemistry, 5);

        printAllstudents();
        List<Student> list = new ArrayList<>();

        list.add(studentEli);
        list.add(studentMax);

        addStudentForSubject(math, studentTom);
        addStudentForSubject(math, list);
        addStudentForSubject(art, list);
        printAllSubjects();
    }

    public static void addSubjectForStudent(Student student, Subject subject, int grade){
        studentGradeMap.put(student, student.addSubject(subject, grade));
    }
    public static void addSubjectForStudent(Student student, Map<Subject, Integer> grades){
        studentGradeMap.put(student, student.addSubject(grades));
    }
    public static void removeStudent(Student student){
        studentGradeMap.remove(student);
    }
    public static void printAllstudents(){
        for(Map.Entry<Student, Map<Subject, Integer>> entry : studentGradeMap.entrySet()){
            System.out.println("=======");
            System.out.println(entry.getKey().getName());
            entry.getKey().printGrades();
            System.out.println("=======");
        }
    }
    public static void addStudentForSubject(Subject subject, Student student){
        subjectListMap.put(subject, subject.addStudent(student));
    }
    public static void addStudentForSubject(Subject subject, List<Student> list){
        subjectListMap.put(subject, subject.addStudent(list));
    }
    public static void removeSubject(Subject subject){
        subjectListMap.remove(subject);
    }
    public static void printAllSubjects(){
        for (Map.Entry<Subject, List<Student>> entry : subjectListMap.entrySet()){
            System.out.println("=======");
            System.out.println(entry.getKey().getName());
            entry.getKey().printStudents();
            System.out.println("=======");
        }
    }
}
