package school.faang.task_45202;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> studentBySubject = new HashMap<>();

    public void addNewStudentWithGrades(Student student, Map<Subject, Integer> subjects) {
        if (studentGrades.containsKey(student)) {
            System.out.println("Студент" + student.getName() + "уже есть в списке");
            return;
        }
        studentGrades.computeIfAbsent(student, key -> subjects);
        for (Subject subject : subjects.keySet()) {
            studentBySubject.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
        }
    }

    public void addNewSubjectForStudent(Student student, Subject subject, int grade) {
        if (!studentGrades.containsKey(student)) {
            System.out.println(student.getName() + " отсутствует в списке");
            return;
        }
        Map<Subject, Integer> subjectMap = studentGrades.get(student);
        subjectMap.put(subject, grade);
        studentGrades.put(student, subjectMap);

        studentBySubject.putIfAbsent(subject, new ArrayList<>());
        List<Student> students = studentBySubject.get(subject);

        if (!students.contains(student)) {
            students.add(student);
        }
        System.out.println("Добавлен предмет " + subject + " с оценкой " + grade + " для " + student.getName());
    }

    public void removeStudent(Student student) {
        if (!studentGrades.containsKey(student)) {
            System.out.println("Данный студент не существует");
            return;
        }
        studentGrades.remove(student);
        for (Map.Entry<Subject, List<Student>> entry : studentBySubject.entrySet()) {
            List<Student> students = entry.getValue();
            students.remove(student);
        }
        System.out.println("Студент " + student.getName() + " удален");
    }


    public void printAllStudentsFromSubject() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            System.out.println("Студент " + entry.getKey());
            System.out.println("Предметы " + entry.getValue());
        }
        System.out.println();
    }

    public void addSubjectForStudent(Subject subject, List<Student> students) {
        if (studentBySubject.containsKey(subject)) {
            System.out.println("Данный предмет уже есть в списке");
            return;
        }
        studentBySubject.put(subject, students);

        for (Student student : students) {
            if (studentGrades.containsKey(student)) {
                Map<Subject, Integer> subjectMap = studentGrades.get(student);
                subjectMap.put(subject, 0);
            } else {
                Map<Subject, Integer> newsubjectMap = new HashMap<>();
                newsubjectMap.put(subject, 0);
                studentGrades.put(student, newsubjectMap);
            }
        }
        System.out.println("Предмет " + subject.getName() + " добавлен");
    }

    public void addStudentToSubject(Student student, Subject subject) {
        if (!studentBySubject.containsKey(subject)) {
            System.out.println("Данный предмет отсутствует в списке");
            return;
        }
        List<Student> students = studentBySubject.get(subject);
        if (students.contains(student)) {
            System.out.println("Данный студент уже есть в списке");
            return;
        }
        students.add(student);

        if (!studentGrades.containsKey(student)) {
            studentGrades.put(student, new HashMap<>());
        }
        Map<Subject, Integer> subjectIntegerMap = studentGrades.get(student);

        if (!subjectIntegerMap.containsKey(subject)) {
            subjectIntegerMap.put(subject, 0);
        }
        System.out.println("Студент " + student.getName() + " добавлен к предмету " + subject.getName());
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (!studentBySubject.containsKey(subject)) {
            System.out.println("Данный предмет отсутствует в списке");
            return;
        }
        List<Student> currentStudents = studentBySubject.get(subject);
        if (!currentStudents.contains(student)) {
            System.out.println("Студент отсутствует в данном предмете");
            return;
        }
        currentStudents.remove(student);
        if (currentStudents.isEmpty()) {
            studentBySubject.remove(subject);
        }
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.remove(subject);
            if (grades.isEmpty()) {
                studentGrades.remove(student);
            }
        }
        System.out.println("Студент " + student.getName() + " удален из предмета " + subject.getName());
    }

    public void printAllSubjectsForStudent() {
        for (var entry : studentBySubject.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
