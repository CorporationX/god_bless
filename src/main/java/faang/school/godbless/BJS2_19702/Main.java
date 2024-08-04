package faang.school.godbless.BJS2_19702;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    HashMap<Student, Map<Subject, Integer>> gradesForSubjects = new HashMap<>();
    HashMap<Subject, List<Student>> studentsTakingSubject = new HashMap<>();

    public static void main(String[] args) {

    }

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        gradesForSubjects.put(student, grades);
    }

    public void addSubjectWithGrade(Student student, Subject subject, Integer integer) {
        gradesForSubjects.get(student).put(subject, integer);
    }

    public void removeStudentWithGrades(Student student) {
        gradesForSubjects.remove(student);
    }

    public void printAllStudents() {
        for(var entry : gradesForSubjects.entrySet()) {
            System.out.println(entry.getKey());
            for(var entrySubjects : entry.getValue().entrySet()) {
                System.out.print(entrySubjects.getKey() + " : " + entrySubjects.getValue());
            }
        }
    }

    public void addSubjectsWithStudents(Subject subject, List<Student> studentList) {
        studentsTakingSubject.put(subject, studentList);
    }

    public void addStudentToSub(Subject subject, Student student) {
        studentsTakingSubject.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSub(Subject subject, Student student) {
        studentsTakingSubject.get(subject).remove(student);
    }

    public void printSubjectsAndStudents() {
        for(var entry : studentsTakingSubject.entrySet()) {
            System.out.println(entry.getKey());
            for(var student : entry.getValue()) {
                System.out.println(student);
            }
        }
    }
}
