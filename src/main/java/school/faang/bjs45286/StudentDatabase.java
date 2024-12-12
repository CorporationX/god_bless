package school.faang.bjs45286;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentMarks = new HashMap<>();
    private final Map<Subject, List<Student>> studentsSubjects =  new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> marks) {
        studentMarks.put(student, marks);
        for (var subjectMarkPair : marks.entrySet()) {
               studentsSubjects.computeIfAbsent(subjectMarkPair.getKey(), k -> new ArrayList<>()).add(student);
        }
    }

    public void addStudentsSubject(Student student, Subject subject, int mark) {
        if (studentMarks.containsKey(student)) {
            studentMarks.get(student).put(subject, mark);
            studentsSubjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        } else {
            throw new IllegalArgumentException("This method accepts only existing users!");
        }
    }

    public void deleteUser(Student student) {
        var studiedSubjects = studentMarks.remove(student).keySet();
        for (var subject : studiedSubjects) {
            studentsSubjects.get(subject).remove(student);
        }
    }

    public void printStudentMarks() {
        for (var student : studentMarks.entrySet()) {
            System.out.println(student.getKey().getName() + ":");
            for (var subjectMarkPair : student.getValue().entrySet()) {
                System.out.println("\t" + subjectMarkPair.getKey() + ": " + subjectMarkPair.getValue());
            }
        }
    }

    public void addNewSubject(Subject subject, List<Student> students) {
        studentsSubjects.put(subject, students);
    }

    public void linkStudentToSubject(Subject subject, Student student) {
        if (studentsSubjects.containsKey(subject)) {
            studentsSubjects.get(subject).add(student);
        } else {
            throw new IllegalArgumentException("Method accepts existing subjects!");
        }
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        studentsSubjects.get(subject).remove(student);
        studentMarks.get(student).remove(subject);
    }

    public void printSubjects() {
        for (var subject : studentsSubjects.entrySet()) {
            System.out.println(subject.getKey() + ":");
            for (var student : subject.getValue()) {
                System.out.println(student);
            }
        }
    }
}
