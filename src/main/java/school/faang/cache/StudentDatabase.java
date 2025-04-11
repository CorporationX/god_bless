package school.faang.cache;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addNewStudentAndSubjectAWithBall(Student student, Map<Subject, Integer> mapSubjectAndBall) {
        if (studentSubjects.get(student) != null) {
            System.out.println("Неподходящий метод, он только для новых студентов, " +
                    "пропробуй метод: addNewSubjectWithBallForOldStudent");
            return;
        }
        studentSubjects.put(student, mapSubjectAndBall);
        for (Map.Entry<Subject, Integer> entry : mapSubjectAndBall.entrySet()) {
            Subject subject = entry.getKey();
            subjectStudents.putIfAbsent(subject, new ArrayList<>(List.of(student)));
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectWithBallForOldStudent(Student student, Subject subject, Integer ball) {
        if (studentSubjects.get(student) == null) {
            System.out.println("Данного студента нет в списке, попробуй метод " +
                    "addNewStudentAndSubjectAWithBall");
            return;
        }
        Map<Subject, Integer> subjectWithBall = studentSubjects.get(student);
        subjectWithBall.put(subject, ball);
        subjectStudents.get(subject).add(student);
    }

    public void removeStudentAndYouSubject(Student student) {
        if (studentSubjects.get(student) == null) {
            System.out.println("Данного студента нет в списке)");
            return;
        }
        studentSubjects.remove(student);
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> listStudent = entry.getValue();
            listStudent.remove(student);
            if (listStudent.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }
    }

    public void printAllStudentAndSubjectWithBall() {
        for (Map.Entry<Student, Map<Subject,Integer>> entry : studentSubjects.entrySet()) {
            System.out.println("Студент: " + entry.getKey().getName() + "\n\tПредметы: ");
            for (Map.Entry<Subject, Integer> entryInner : entry.getValue().entrySet()) {
                System.out.println("\t-" + entryInner.getKey().getName() + ", Оценка:" + entryInner.getValue());
            }
        }
    }
}
