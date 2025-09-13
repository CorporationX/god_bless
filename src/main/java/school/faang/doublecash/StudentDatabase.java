package school.faang.doublecash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        if (!Validator.validateStudentAndSubjects(student, subjects)) {
            return;
        }
        studentSubjects.put(student, subjects);
        for (Subject subject : subjects.keySet()) {
            if (!Validator.validateSubject(subject)) {
                continue;
            }
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    private void addSubjectWithGradeToStudent(Student student, Subject subject, int grade) {
        if (grade <= 0) {
            throw new IllegalArgumentException("Оценка не может быть 0 или отрицательной.");
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        if (!Validator.validateStudentName(student) || !Validator.validateSubject(subject)) {
            return;
        }
        addSubjectWithGradeToStudent(student, subject, grade);
    }

    public void removeStudent(Student student) {
        if (Validator.isNull(student)) {
            System.out.println("\nОшибка: Студент не может быть null.");
            return;
        }
        if (!studentSubjects.containsKey(student)) {
            System.out.println("\nОшибка: Студент " + student.getName() + " не найден.");
            return;
        }
        Map<Subject, Integer> subjects = studentSubjects.remove(student);
        for (Subject subject : subjects.keySet()) {
            subjectStudents.get(subject).remove(student);
            if (subjectStudents.get(subject).isEmpty()) {
                subjectStudents.remove(subject);
            }
        }
        System.out.println("\nСтудент " + student.getName() + " успешно удален.");
    }

    public void printStudents() {
        if (Validator.isNull(studentSubjects) || studentSubjects.isEmpty()) {
            System.out.println("Нет данных о студентах.");
            return;
        }
        for (Student student : studentSubjects.keySet()) {
            if (!Validator.validateStudentName(student)) {
                continue;
            }
            System.out.println("\nСтудент " + student.getName() + ":");
            Map<Subject, Integer> subjects = studentSubjects.get(student);
            for (Subject subject : subjects.keySet()) {
                if (!Validator.validateSubject(subject)) {
                    continue;
                }
                System.out.println(" " + subject.getName() + ": " + subjects.get(subject));
            }
        }
    }

    public void addSubject(Subject subject, List<Student> students, int defaultGrade) {
        if (!Validator.validateSubject(subject)) {
            return;
        }
        if (Validator.isNull(students) || students.isEmpty()) {
            throw new IllegalArgumentException("Список студентов не может быть пустым.");
        }
        subjectStudents.put(subject, students);
        for (Student student : students) {
            if (!Validator.validateStudentName(student)) {
                continue;
            }
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, defaultGrade);
        }
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (Validator.isNull(student) || Validator.isNull(subject)) {
            System.out.println("\nОшибка: Студент или предмет не могут быть null.");
            return;
        }
        if (!studentSubjects.containsKey(student)) {
            System.out.println("\nОшибка: Студент " + student.getName() + " уже удален.");
            return;
        }
        if (!studentSubjects.get(student).containsKey(subject)) {
            System.out.println("\nОшибка: Студент не связан с предметом " + subject.getName());
            return;
        }

        studentSubjects.get(student).remove(subject);
        if (subjectStudents.containsKey(subject)) {
            subjectStudents.get(subject).remove(student);
            if (subjectStudents.get(subject).isEmpty()) {
                subjectStudents.remove(subject);
            }
        }
        System.out.println("\nСтудент " + student.getName() + " успешно удален из предмета " + subject.getName());
    }

    public void printAllSubjectsAndStudents() {
        if (Validator.isNull(subjectStudents) || subjectStudents.isEmpty()) {
            System.out.println("Нет данных о предметах.");
            return;
        }
        Map<String, List<Subject>> studentSubjectsMap = new HashMap<>();
        for (Subject subject : subjectStudents.keySet()) {
            if (!Validator.validateSubject(subject)) {
                continue;
            }
            List<Student> students = subjectStudents.get(subject);
            for (Student student : students) {
                if (!Validator.validateStudentName(student)) {
                    continue;
                }
                studentSubjectsMap.putIfAbsent(student.getName(), new ArrayList<>());
                studentSubjectsMap.get(student.getName()).add(subject);
            }
        }
        for (String studentName : studentSubjectsMap.keySet()) {
            System.out.println("\nСтудент: " + studentName);
            for (Subject subject : studentSubjectsMap.get(studentName)) {
                System.out.println(" " + subject.getName());
            }
        }
    }
}