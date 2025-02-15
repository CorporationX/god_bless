package school.faang.doublecash;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(String nameStudent, Map<Subject, Integer> grades) {
        checkNameStudent(nameStudent);
        checkMapGrades(grades);
        Student newStudent = new Student(nameStudent);
        studentSubjects.put(newStudent, grades);

        for (var entry : grades.entrySet()) {
            subjectStudents.computeIfAbsent(entry.getKey(), subject -> new ArrayList<>()).add(newStudent);
        }
    }

    public void addSubjectForStudent(String nameSubject, String nameStudent, int grade) {
        checkNameStudent(nameStudent);
        checkNameSubject(nameSubject);
        checkGrade(grade);
        Student student = new Student(nameStudent);
        Subject newSubject = new Subject(nameSubject);
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(newSubject, grade);
        subjectStudents.computeIfAbsent(newSubject, subject -> new ArrayList<>()).add(student);
    }

    public boolean removeStudent(String nameStudent) {
        checkNameStudent(nameStudent);
        Student student = new Student(nameStudent);
        if (studentSubjects.containsKey(student)) {
            for (var entry : studentSubjects.get(student).entrySet()) {
                if (subjectStudents.get(entry.getKey()).contains(student)) {
                    if (subjectStudents.get(entry.getKey()).size() == 1) {
                        subjectStudents.remove(entry.getKey());
                    } else {
                        subjectStudents.get(entry.getKey()).remove(student);
                    }
                }
            }
            studentSubjects.remove(student);
            return true;
        }
        return false;
    }

    public void printAllStudents() {
        for (var entry : studentSubjects.entrySet()) {
            System.out.println("Студент: " + entry.getKey().name());
            printAllSubjectsForStudent(entry.getKey());
        }

    }

    public void printAllSubjectsForStudent(Student student) {
        checkStudent(student);
        for (var entry : studentSubjects.get(student).entrySet()) {
            System.out.println(entry.getKey().name() + " : " + entry.getValue());
        }
        System.out.println();
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        checkSubject(subject);
        checkListStudents(students);
        subjectStudents.put(subject, new ArrayList<>(students));
        for (var student : students) {
            studentSubjects.computeIfAbsent(student, newStudent -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToSubject(String nameStudent, String nameSubject, int grade) {
        checkNameStudent(nameStudent);
        checkNameSubject(nameSubject);
        checkGrade(grade);
        Student student = new Student(nameStudent);
        Subject subject = new Subject(nameSubject);
        subjectStudents.get(subject).add(student);
        studentSubjects.computeIfAbsent(student, newStudent -> new HashMap<>()).put(subject, grade);
    }

    public boolean removeStudentFromSubject(String nameStudent, String nameSubject) {
        checkNameStudent(nameStudent);
        checkNameSubject(nameSubject);
        Student student = new Student(nameStudent);
        Subject subject = new Subject(nameSubject);
        if (subjectStudents.containsKey(subject) && subjectStudents.get(subject).contains(student)) {
            if (subjectStudents.get(subject).size() == 1) {
                subjectStudents.remove(subject);
            } else {
                subjectStudents.get(subject).remove(student);
                studentSubjects.get(student).remove(subject);
            }
            return true;
        } else {
            return false;
        }
    }

    public void printAllSubjects() {
        for (var entry : subjectStudents.entrySet()) {
            System.out.println("Предмет: " + entry.getKey().name());
            for (Student student : entry.getValue()) {
                System.out.println(student.name());
            }
        }

    }

    public void checkNameStudent(String nameStudent) {
        if (nameStudent == null || nameStudent.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    public void checkNameSubject(String nameSubject) {
        if (nameSubject == null || nameSubject.isBlank()) {
            throw new IllegalArgumentException("Название предмета не может быть пустым");
        }
    }

    public void checkGrade(int grade) {
        if (grade < 1 || grade > 5) {
            throw new IllegalArgumentException("Оценка может быть только целым числом от 1 до 5");
        }
    }

    public void checkStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Студент не может быть null");
        }
    }

    public void checkListStudents(List<Student> students) {
        if (students == null) {
            throw new IllegalArgumentException("Список студентов не может быть null");
        }
    }

    public void checkSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Предмет не может быть null");
        }
    }

    public void checkMapGrades(Map<Subject, Integer> grades) {
        if (grades == null || grades.isEmpty()) {
            throw new IllegalArgumentException("Предметы с оценками не могут быть null");
        }
    }
}