package school.faang.bsj2_87050;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentAndSubjectGrades(String newStudentName, Map<Subject, Integer> subjectAndGrades) {
        Student newStudent = new Student(newStudentName);
        studentSubjects.put(newStudent, subjectAndGrades);
        for (Subject subject : subjectAndGrades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(newStudent);
        }
    }

    public void addStudentAndSubjectGrades(Student student, Subject subject, Integer grade) {
        Map<Subject, Integer> subjectAndGrades = studentSubjects.getOrDefault(student, new HashMap<>());
        subjectAndGrades.put(subject, grade);
        studentSubjects.put(student, subjectAndGrades);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void deleteStudentAndSubjects(Student student) {
        studentSubjects.remove(student);
        for (Subject subject : subjectStudents.keySet()) {
            subjectStudents.get(subject).remove(student);
        }
    }

    public void printAllStudentsAndSubjectGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentGrade : studentSubjects.entrySet()) {
            for (Map.Entry<Subject, Integer> subjectGrade : studentGrade.getValue().entrySet()) {
                System.out.printf("%s, %s, %d\n",
                        studentGrade.getKey().getName(),
                        subjectGrade.getKey().getName(),
                        subjectGrade.getValue());
            }
        }
    }

    public void addNewSubjectAndStudents(String subjectName, List<Student> students) {
        Subject newSubject = new Subject(subjectName);
        subjectStudents.putIfAbsent(newSubject, new ArrayList<>());
        subjectStudents.get(newSubject).addAll(students);
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        subjectStudents.getOrDefault(subject, new ArrayList<>()).remove(student);
    }

    public void printAllSubjectAndStudents() {
        for (Map.Entry<Subject, List<Student>> subjectStudent : subjectStudents.entrySet()) {
            System.out.println(subjectStudent.getKey());
            for (Student student : subjectStudent.getValue()) {
                System.out.printf("%s %s\n", " -", student.getName());
            }
        }
    }
}
