package school.faang.double_cache;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(String name, String subject, int grade) {
        Student student = new Student(name);
        Subject subject1 = new Subject(subject);
        if (studentSubjects.isEmpty() || !studentSubjects.containsKey(student)) {
            Map<Subject, Integer> map = new HashMap<>();
            map.put(subject1, grade);
            studentSubjects.put(student, map);
        } else {
            studentSubjects.get(student).put(subject1, grade);
        }
        if (subjectStudents.isEmpty() || !subjectStudents.containsKey(subject1)) {
            List<Student> list = new ArrayList<>();
            list.add(student);
            subjectStudents.put(subject1, list);
        } else if (!subjectStudents.get(subject1).contains(student)) {
            subjectStudents.get(subject1).add(student);
        }
    }

    public void addSubject(Student student, String subject, int grade) {
        Subject subject1 = new Subject(subject);
        studentSubjects.get(student).put(subject1, grade);
        if (!subjectStudents.get(subject1).contains(student)) {
            subjectStudents.get(subject1).add(student);
        }
    }

    public void dellStudent(Student student) {
        for (Subject subject : studentSubjects.get(student).keySet().toArray(new Subject[0])) {
            subjectStudents.get(subject).remove(student);
        }
        studentSubjects.remove(student);
    }

    public void printAllStudentSubject() {
        for (Student student : studentSubjects.keySet().toArray(new Student[0])) {
            System.out.println("Student: " + student.getName() + " " + studentSubjects.get(student));
        }
    }

    public void pullSubjectStudent(String subject, List<Student> studentList) {

    }

    public void addStudentSubject(Student student, Subject subject) {

    }

    public void dellSubjectStudent(Subject subject, Student student) {

    }

    public void printAllSubjectStudent() {

    }
}
