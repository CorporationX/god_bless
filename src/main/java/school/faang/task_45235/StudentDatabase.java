package school.faang.task_45235;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> gradesInSubjects = new HashMap<>();
    private Map<Subject, List<Student>> studentsStudyingSubjects = new HashMap<>();

    public void addStudentAndSubject(Student student, Subject subject, Integer grade) {
        if (!gradesInSubjects.containsKey(student)) {
            gradesInSubjects.put(student, new HashMap<Subject, Integer>());
        }
        gradesInSubjects.get(student).put(subject, grade);
    }

    public void addSubject(Student student, Subject subject, Integer grade) {
        if (gradesInSubjects.containsKey(student)) {
            gradesInSubjects.get(student).put(subject, grade);
            System.out.println("Предмет " + subject.getName() + " успешно добавлен студенту: " + student.getName());
        } else {
            System.out.println("Студент с именем " + student.getName() + " не найден в списке!");
        }
    }

    public void removeStudent(Student student) {
        if (gradesInSubjects.containsKey(student)) {
            gradesInSubjects.remove(student);
            System.out.println("Студент с именем " + student.getName() + " удален из списка!");
        } else {
            System.out.println("Студент с именем " + student.getName() + " в списке не найден!");
        }
    }

    public void printStudent() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : gradesInSubjects.entrySet()) {
            System.out.println("Студент ID: " + entry.getKey().getId() + " Имя: "
                    + entry.getKey().getName() + " имеет оценки:");
            for (Map.Entry<Subject, Integer> entry1 : entry.getValue().entrySet()) {
                System.out.println("Предмет ID: " + entry1.getKey().getId() + " "
                        + entry1.getKey().getName() + " оценка - " + entry1.getValue());
            }
        }
    }

    public void addSubjectStudent(Subject subject, Student student) {
        if (!studentsStudyingSubjects.containsKey(subject)) {
            studentsStudyingSubjects.put(subject, new ArrayList<>());
        }
        studentsStudyingSubjects.get(subject).add(student);
    }

    public void addStudent(Subject subject, Student student) {
        if (studentsStudyingSubjects.containsKey(subject)) {
            studentsStudyingSubjects.get(subject).add(student);
            System.out.println("Студент с именем " + student.getName() + " успешно добавлен!");
        } else {
            System.out.println("Предмет " + student.getName() + " В списке не найден!");
        }
    }

    public void removeStudentSubject(Student student) {
        int total = 0;
        for (Map.Entry<Subject, List<Student>> entry : studentsStudyingSubjects.entrySet()) {
            if (entry.getValue().contains(student)) {
                studentsStudyingSubjects.get(entry.getKey()).remove(student);
                System.out.println("Студент с именем " + student.getName()
                        + " удален из предмета: " + entry.getKey().getName());
                total++;
            }
        }
        if (total == 0) {
            System.out.println("Студент с именем " + student.getName() + " в списке не найден!");
        }
    }

    public void printStudentSubject() {
        for (Map.Entry<Subject, List<Student>> entry : studentsStudyingSubjects.entrySet()) {
            System.out.println("Предмет ID: " + entry.getKey().getId() + " "
                    + entry.getKey().getName() + " изучают следующие студенты:");
            for (Student students : entry.getValue()) {
                System.out.println("ID: " + students.getId() + " Имя:" + students.getName());
            }
        }
    }
}