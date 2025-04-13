package school.faang.doubleHash;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubject = new HashMap<>();

    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubject(Student student, Map<Subject, Integer> grades) {
        studentSubject.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
        System.out.println(studentSubject);
        System.out.println(subjectStudents);
    }

    public void addSubjectForExistingStudent(Student student, Subject subject, int grade) {
        studentSubject.putIfAbsent(student, new HashMap<>());
        studentSubject.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);

        System.out.println(studentSubject);
        System.out.println(subjectStudents);
    }

    public void deleteStudent(Student student) {
        Map<Subject, Integer> subjectIntegerMap = studentSubject.remove(student);
        if(subjectIntegerMap != null){
            for(Subject subject : subjectIntegerMap.keySet()){
                List<Student> students = subjectStudents.get(subject);
                if (student != null){
                    students.remove(student);
                }
            }
        }
    }

    public void printStudentWithGrade() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println(subject);
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
        }
    }

    public void addSubjectAndStudent(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubject.putIfAbsent(student, new HashMap<>());
            studentSubject.get(student).put(subject, 3);
        }

        System.out.println(subjectStudents);
        System.out.println(studentSubject);
    }

    public void addSubjectExistingStudent(Subject subject, Student student) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubject.putIfAbsent(student, new HashMap<>());
        studentSubject.get(student).put(subject, 3);

        System.out.println(studentSubject);
        System.out.println(subjectStudents);
    }

    public void deleteStudentFromSubject(Student student, Subject subject) {
        List<Student> studentList = subjectStudents.get(subject);
        if (studentList != null) {
            studentList.remove(student);
        }
        Map<Subject, Integer> subjectIntegerMap = studentSubject.get(student);
        if (subjectIntegerMap != null) {
            subjectIntegerMap.remove(subject);
        }
    }

    public void printSubjectAndStudent() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println(subject);
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
        }
    }
}
