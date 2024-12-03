package school.faang.task_45206;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {

    public HashMap<Student, Map<Subject, Integer>> studentGrades;
    public HashMap<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        studentGrades = new HashMap<>();
        subjectStudents = new HashMap<>();
    }

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
    }

    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        Map<Subject, Integer> subjectGrades = studentGrades.get(student);
        if (subjectGrades != null) {
            subjectGrades.put(subject, grade);
            return;
        }
        throw new IllegalArgumentException("Такого студента не существует");
    }

    public void deleteStudent(Student student) {
        if (studentGrades.remove(student) == null) {
            throw new IllegalArgumentException("Такого студента не существует");
        }
    }

    public void printStudentsWithSubjects() {
        for (Map.Entry entry : studentGrades.entrySet()) {
            System.out.println(entry);
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
    }

    public void addStudentForSubject(Student student, Subject subject) {
        List<Student> currentStudents = subjectStudents.get(subject);
        if (currentStudents != null) {
            currentStudents.add(student);
            return;
        }
        throw new IllegalArgumentException("Такого предмета не существует");
    }

    public void deleteStudentFromSubject(Subject subject, Student student) {
        List<Student> currentStudents = subjectStudents.get(subject);
        if (currentStudents != null) {
            currentStudents.remove(student);
        }
        throw new IllegalArgumentException("Такого предмета не существует");
    }

    public void printSubjectsWithStudents() {
        for (Map.Entry entry : subjectStudents.entrySet()) {
            System.out.println(entry);
        }
    }
}
