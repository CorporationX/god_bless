package school.faang.HashMap5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseService {
    public static void addStudentMark(Student student, Subject subject, int mark,
                                  Map<Student, Map<Subject, Integer>> studentMarks){
        studentMarks.computeIfAbsent(student, k -> new HashMap<Subject, Integer>()).put(subject, mark);
    }

    public static void deleteStudent(Student student, Map<Student, Map<Subject, Integer>> studentMarks){
        studentMarks.remove(student);
    }

    public static void printStudentsMarks(Map<Student, Map<Subject, Integer>> studentMarks){
        for (Map.Entry<Student, Map<Subject, Integer>> entry: studentMarks.entrySet()){
            System.out.println("Student: " + entry.getKey().getName());
            entry.getValue().forEach(((subject, integer)
                    -> System.out.println(subject.getName() + " - " + integer)));
            System.out.println();
        }
        System.out.println();
    }

    public static void addListToSubject(Subject subject, List<Student> list,
                                           Map<Subject, List<Student>> studentsOfSubject){
        studentsOfSubject.put(subject, list);
    }

    public static void addStudentToSubject(Subject subject, Student student,
                                           Map<Subject, List<Student>> studentsOfSubject){
        studentsOfSubject.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public static void deleteFromSubject(Student student, Subject subject, Map<Subject,
            List<Student>> studentsOfSubject){
        studentsOfSubject.get(subject).remove(student);
    }

    public static void printStudentsOfSubject(Map<Subject, List<Student>> studentsOfSubject){
        for (Map.Entry<Subject, List<Student>> entry: studentsOfSubject.entrySet()){
            System.out.println("Subject: " + entry.getKey().getName());
            System.out.println("Students:");
            entry.getValue().forEach(student -> System.out.println(student.getName()));
        }
        System.out.println();
    }
}
