package school.faang.doublecash;

import java.util.*;

public class StudentDatabase {

    Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public Map<Student, Map<Subject, Integer>> getStudentSubjects() {
        return studentSubjects;
    }

    public Map<Subject, List<Student>> getSubjectStudents() {
        return subjectStudents;
    }
}