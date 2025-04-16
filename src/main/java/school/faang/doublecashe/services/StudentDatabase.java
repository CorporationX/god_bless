package school.faang.doublecashe.services;

import lombok.Getter;
import school.faang.doublecashe.models.Student;
import school.faang.doublecashe.models.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        if (student == null || subjects == null) {
            throw new IllegalArgumentException("Введите имя студента и название предмета");
        }

        studentSubjects.put(student, subjects);

        for (Subject subject : subjects.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            if (!subjectStudents.get(subject).contains(student)) {
                subjectStudents.get(subject).add(student);
            }
        }
    }

    public void addSubjectForStudent(Subject subject, Student student, int grade) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Предмет и студент не могут быть null");
        }
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Студента с именем " + student + " нет в списке");
        }

        studentSubjects.get(student).put(subject, grade);

        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Студент не может быть null");
        }
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Студента с именем " + student + " нет в списке");
        }

        Map<Subject, Integer> subjects = studentSubjects.get(student);
        for (Subject subject : subjects.keySet()) {
            List<Student> students = subjectStudents.get(subject);
            if (students != null) {
                students.remove(student);
                if (students.isEmpty()) {
                    subjectStudents.remove(subject);
                }
            }
        }
        studentSubjects.remove(student);
    }

    public String printStudentGrade() {
        return studentSubjects.toString();
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject == null || students == null) {
            throw new IllegalArgumentException("Введите название предмета и имя студента");
        }

        subjectStudents.put(subject, new ArrayList<>(students));

        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            if (!studentSubjects.get(student).containsKey(subject)) {
                studentSubjects.get(student).put(subject, 0);
            }
        }
    }

    public void addStudentToSubject(Subject subject, Student student) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Предмет и студент не могут быть null");
        }
        if (!subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException("Предмета с названием " + subject + " нет в списке");
        }

        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }

        studentSubjects.putIfAbsent(student, new HashMap<>());
        if (!studentSubjects.get(student).containsKey(subject)) {
            studentSubjects.get(student).put(subject, 0);
        }
    }

    // Удаление студента из предмета
    public void removeStudentFromSubject(Subject subject, Student student) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Предмет и студент не могут быть null");
        }
        if (!subjectStudents.containsKey(subject)) {
            throw new IllegalArgumentException("Предмета с названием " + subject + " нет в списке");
        }

        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);

            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }

        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects != null) {
            subjects.remove(subject);

            if (subjects.isEmpty()) {
                studentSubjects.remove(student);
            }
        }
    }

    public String printSubjectsForStudents() {
        return subjectStudents.toString();
    }
}
