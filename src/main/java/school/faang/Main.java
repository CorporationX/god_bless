package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> subjectsAndGradesMap = new HashMap<>();
    private static Map<Subject, List<Student>> studentSubjectMap = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student(1, "Sergey");
        Student student2 = new Student(2, "Dmitry");
        Subject physics = new Subject(1, "physics");
        Subject math = new Subject(1, "math");
        addStudent(student1, physics, 5, subjectsAndGradesMap, studentSubjectMap);
        addStudent(student2, math, 4, subjectsAndGradesMap, studentSubjectMap);
    }

    public static void addStudent(Student student, Subject subject, int grade,
                                  Map<Student, Map<Subject, Integer>> subjectsAndGradesMap,
                                  Map<Subject, List<Student>> studentSubjectMap) {
        subjectsAndGradesMap.putIfAbsent(student, Map.of(subject, grade));
        studentSubjectMap.putIfAbsent(subject, new ArrayList<>());
        List<Student> studentList = studentSubjectMap.get(subject);
        if (!studentList.contains(student)) {
            studentList.add(student);
        }
    }

    public static void addSubjectsAndGrades(Student student, Subject subject, int grade,
                                            Map<Student, Map<Subject, Integer>> subjectsAndGradesMap) {
        if (subjectsAndGradesMap.containsKey(student)) {
            Map<Subject, Integer> gradesMap = subjectsAndGradesMap.get(student);
            if (gradesMap == null){
                gradesMap = new HashMap<>();
                subjectsAndGradesMap.put(student,gradesMap);
            }
            gradesMap.put(subject, grade);
        } else {
            System.out.println("user not found");
        }
    }

    public static void removeStudent(Student student, Map<Student, Map<Subject, Integer>> subjectsAndGradesMap,
                                     Map<Subject, List<Student>> studentSubjectMap){
        subjectsAndGradesMap.remove(student);
        studentSubjectMap.;

    }

}
