package school.faang.bjs245251;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class StudentDataBase {
    private HashMap<Student, Map<Subject, Integer>> students = new HashMap<>();
    private HashMap<Subject, List<Student>> subjectsStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> studentGrade) {
        if (student == null || studentGrade == null) {
            throw new IllegalArgumentException("Student or students grade can not be null");
        }
        students.put(student, studentGrade);
        for (Subject subject : studentGrade.keySet()) {
            subjectsStudents.computeIfAbsent(subject, subject1 -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        Map<Subject, Integer> grades = students.get(student);
        if (grades != null) {
            grades.put(subject, grade);
            subjectsStudents.computeIfAbsent(subject, subject1 -> new ArrayList<>()).add(student);
        }
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> studentGrade = students.remove(student);
        if (studentGrade != null) {
            for (Subject subject : subjectsStudents.keySet()) {
                List<Student> studentList = subjectsStudents.get(student);
                if (studentList != null) {
                    studentList.remove(student);
                }
            }
        }
    }

    public void printAllSubjectsWithStudents() {
        subjectsStudents.forEach((subject, students1) -> System.out.println(subject + " : " + students1));
    }

    public void addSubjectWithStudents(Subject subject, List<Student> studentsList) {
        subjectsStudents.put(subject, studentsList);
        for (Student student : studentsList) {
            students.computeIfAbsent(student, student1 -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectsStudents.computeIfAbsent(subject, subject1 -> new ArrayList<>()).add(student);
        students.computeIfAbsent(student, student1 -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        subjectsStudents.getOrDefault(subject, new ArrayList<>())
                .removeIf(currentStudent -> Objects.equals(currentStudent, student));
    }

    public void printAllStudents() {
        students.forEach((student, subjectIntegerMap) ->
                System.out.println(student + " : " + subjectIntegerMap));
    }
}
