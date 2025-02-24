package school.faang.sprint1.task_45271;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDayabase {
    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    // Метод для добавления нового предмета и списка студентов, изучающих его
    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentGrades.putIfAbsent(student, new HashMap<>());
            studentGrades.get(student).put(subject, 0);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
            // Обновляем studentGrades для нового предмета (по умолчанию ставим 0)
            studentGrades.putIfAbsent(student, new HashMap<>());
            studentGrades.get(student).put(subject, 0);
        }
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (subjectStudents.containsKey(subject)) {
            subjectStudents.get(subject).remove(student);
        }
        if (studentGrades.containsKey(student)) {
            studentGrades.get(student).remove(subject);
        }
    }

    public void printAllSubjectsWithStudents() {
        System.out.println("Список предметов и студентов");
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();
            System.out.println(subject + "->" + students);

        }
    }
}
