package school.faang.doublecash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private HashMap<Student, Map<Subject, Integer>> studentsGrade;
    private HashMap<Subject, List<Student>> subjects;

    public StudentDatabase(HashMap<Student, Map<Subject, Integer>> studentsGrade,
                           HashMap<Subject, List<Student>> subjects) {
        this.studentsGrade = studentsGrade;
        this.subjects = subjects;
    }

    public void addStudentAndSubjects(Student student, Subject subject, int grade) {
        studentsGrade.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }

    public void addSubjectForExistingStudent(Student student, Subject subject, int grade) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Студент и/или предмет не могут быть null");
        }
        if (studentsGrade.containsKey(student)) {
            studentsGrade.get(student).put(subject, grade);
        } else {
            System.out.println("Студент не найден: " + student);
        }
    }

    public void removeStudentAndSubjects(Student student) {
        studentsGrade.remove(student);
    }

    public void printAllStudentsAndGrade() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentGrade : studentsGrade.entrySet()) {
            System.out.printf("Успеваемость ученика %s следующая: \n", studentGrade.getKey().getName());
            for (Map.Entry<Subject, Integer> grade : studentGrade.getValue().entrySet()) {
                System.out.println(grade.getKey().getName() + " - " + grade.getValue());
            }
        }
    }

    public void addSubjectAndStudents(Subject subject, Student student) {
        subjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);

    }

    public void addStudentToSubject(Subject subject, Student student) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Студент и/или предмет не могут быть null");
        }
        if (subjects.containsKey(subject)) {
            subjects.get(subject).add(student);
        } else {
            System.out.println("Такого предмета нет");
        }
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        if (subjects.containsKey(subject)) {
            subjects.get(subject).remove(student);
        }
    }

    public void printAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> subject : subjects.entrySet()) {
            System.out.printf("Предмет %s изучают: \n", subject.getKey().getName());
            for (Student student : subject.getValue()) {
                System.out.println(student.getName());
            }
        }
    }
}
