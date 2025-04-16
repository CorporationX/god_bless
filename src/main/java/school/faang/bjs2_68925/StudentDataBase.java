package school.faang.bjs2_68925;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDataBase {
    Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void newStudent(Student student, Map<Subject, Integer> subjectGrades) {
        studentSubjects.put(student, subjectGrades);
        for (Subject subject : subjectGrades.keySet()) {
            subjectStudents.computeIfAbsent(subject, a -> new ArrayList<>()).add(student);
        }
    }

    public void newSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, a -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, a -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        studentSubjects.remove(student);
        for (List<Student> students : subjectStudents.values()) {
            students.removeIf(existedStudent -> existedStudent.equals(student));
        }
    }

    public void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey().name() + ": ");
            for (Map.Entry<Subject, Integer> subjGrade : entry.getValue().entrySet()) {
                System.out.println("Subject: " + subjGrade.getKey().name() + '\n'
                        + "Grade: " + subjGrade.getValue());
            }
        }
    }

    public void addNewSubject(Subject subject, List<Student> students, List<Integer> grades) {
        subjectStudents.put(subject, students);
        for (int i = 0; i < students.size(); i++) {
            studentSubjects.computeIfAbsent(students.get(i), a -> new HashMap<>()).put(subject, grades.get(i));
        }
    }

    public void newStudentForSubj(Student student, Subject subject, int grade) {
        subjectStudents.get(subject).add(student);
        studentSubjects.computeIfAbsent(student, a -> new HashMap<>()).put(subject, grade);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if(students == null) {
            System.out.println("Subject does not exist in this database");
        } else {
            students.remove(student);
            studentSubjects.get(student).remove(subject);
        }
    }

    public void printAllSubj() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Урок: " + entry.getKey().name());
            System.out.println("Ученики: ");
            for (Student student : entry.getValue()) {
                System.out.println(student.name());
            }
        }
    }
}
