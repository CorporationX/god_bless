package faang.school.godbless.DoubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    Map<Student, Map<Subject, Integer>> studentsGrades;
    Map<Subject, List<Student>> studentsBySubject;

    public void addStudent(Student student, HashMap<Subject, Integer> subjects) {
        studentsGrades.putIfAbsent(student, subjects);

        for (Map.Entry<Subject, Integer> entry : subjects.entrySet()) {
            if (!studentsBySubject.containsKey(entry.getKey())) {
                studentsBySubject.put(entry.getKey(), new ArrayList<>());
            }
            studentsBySubject.get(entry.getKey()).add(student);
        }
    }

    public void addSubject(Student student, Subject subject, int grade) {
        studentsGrades.get(student).putIfAbsent(subject, grade);

            if (!studentsBySubject.containsKey(subject)) {
                studentsBySubject.put(subject, new ArrayList<>());
            }
            studentsBySubject.get(subject).add(student);
    }

    public void removeStudent(Student student){
        studentsGrades.remove(student);

        for (Map.Entry<Subject, List<Student>> entry : studentsBySubject.entrySet()) {
            entry.getValue().remove(student);
        }
    }

    public void printAllStats() {
        for (Map.Entry<Student, Map<Subject, Integer>> students : studentsGrades.entrySet()) {
            System.out.println("ID: " + students.getKey().getId() + "Name: " + students.getKey().getName());
            for (Map.Entry<Subject, Integer> subjects : students.getValue().entrySet()) {
                System.out.println(subjects.getKey() + " - " + subjects.getValue());
            }
        }
    }
}
