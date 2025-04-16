package gratsio_BJS2_68733;

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
            subjectStudents.computeIfAbsent(subject, value -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectAndGradesForStudent(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, value -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, value -> new ArrayList<>()).add(student);
    }

    public void deleteStudentWithSubjectsAndGrades(Student student) {
        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).forEach((subject, grade) ->
                    subjectStudents.get(subject).remove(student)
            );
            studentSubjects.remove(student);
        } else {
            System.out.println("Student " + student.name() + " does not exist");
        }
    }

    public void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey().name());
            for (Map.Entry<Subject, Integer> subjectAndGrade  : entry.getValue().entrySet()){
                System.out.println(subjectAndGrade.getKey().name() + ": " + subjectAndGrade.getValue());
            }
        }
    }

    public void addSubjectAndListOfStudents(Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>(students));
        for (Student currentStudent : students) {
            studentSubjects.computeIfAbsent(currentStudent, value -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        studentSubjects.computeIfAbsent(student, value -> new HashMap<>()).put(subject, null);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.computeIfAbsent(subject, value -> new ArrayList<>()).add(student);
        }
    }

    public void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println(entry.getKey().name() + ": ");
            for (Student student : entry.getValue()) {
                System.out.println(student.name());
            }
        }
    }
}
