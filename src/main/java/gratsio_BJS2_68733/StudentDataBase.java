package gratsio_BJS2_68733;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDataBase {
    Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);
        for (Map.Entry<Subject, Integer> entry : grades.entrySet()) {
            Subject subject = entry.getKey();
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectAndGradesForStudent(Student student, Subject subject, int grade) {
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void deleteStudentWithSubjectsAndGrades(Student student) {
        if (studentSubjects.containsKey(student)) {
            for (Map.Entry<Subject, Integer> entry : studentSubjects.get(student).entrySet()) {
                Subject subject = entry.getKey();
                subjectStudents.get(subject).remove(student);
            }
            studentSubjects.remove(student);
        } else {
            System.out.println("Student " + student.getName() + " does not exist");
        }
    }

    public void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey().getName());
            for (Map.Entry<Subject, Integer> subjectAndGrade  : entry.getValue().entrySet()){
                System.out.println(subjectAndGrade.getKey().getName() + ": " + subjectAndGrade.getValue());
            }
        }
    }

    public void addSubjectAndListOfStudents(Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>(students));
        for (Student currentStudent : students) {
            studentSubjects.putIfAbsent(currentStudent, new HashMap<>());
            studentSubjects.get(currentStudent).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, null);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.put(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println(entry.getKey().getName() + ": ");
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }
}
