package school.faang.task_45221;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private HashMap<Student, Map<Subject, Integer>> studentsGrades = new HashMap<Student, Map<Subject, Integer>>();
    private HashMap<Subject, List<Student>> studentSubjects = new HashMap<Subject, List<Student>>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public StudentDatabase() {
        subjects.add(new Subject("Math"));
        subjects.add(new Subject("English"));
        subjects.add(new Subject("Russian Language"));
    }

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        students.add(student);
        studentsGrades.put(student, grades);
        for (Subject subject : grades.keySet()) {
            studentSubjects.putIfAbsent(subject, new ArrayList<>());
            studentSubjects.get(subject).add(student);
            if (!subjects.contains(subject)) {
                subjects.add(subject);
            }
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentsGrades.get(student).putIfAbsent(subject, grade);
        if (!studentSubjects.containsKey(subject)) {
            studentSubjects.putIfAbsent(subject, new ArrayList<>());
        }
        studentSubjects.get(subject).add(student);
        if (!subjects.contains(subject)) {
            subjects.add(subject);
        }
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentsGrades.remove(student);
        if (!grades.isEmpty()) {
            for (Subject subject : grades.keySet()) {
                studentSubjects.get(subject).remove(student);
            }
        }
        students.remove(student);
    }

    public void printAllSubjectsWithStudents() {
        System.out.println("<----------------------------------------------->");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsGrades.entrySet()) {
            System.out.println(String.format("Grades of student: %s", entry.getKey().getName()));
            for (Map.Entry<Subject, Integer> entrySub : entry.getValue().entrySet()) {
                System.out.println(String.format("Subject: %s, grade: %d", entrySub.getKey().getName(),
                        entrySub.getValue()));
            }
        }
        System.out.println("<----------------------------------------------->");
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (!subjects.contains(subject)) {
            subjects.add(subject);
        }
        studentSubjects.putIfAbsent(subject, students);
    }

    public void addStudentToSubject(Student student, Subject subject) {
        studentSubjects.get(subject).add(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        studentSubjects.get(subject).remove(student);
    }

    public void printAllStudentsSubjets() {
        System.out.println("<----------------------------------------------->");
        for (Map.Entry<Subject, List<Student>> entry : studentSubjects.entrySet()) {
            System.out.println(String.format("Subject: %s", entry.getKey().getName()));
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
        System.out.println("<----------------------------------------------->");
    }
}
