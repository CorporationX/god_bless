package school.faang.cache;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Slf4j
public class StudentDatabase {
    private final Map<Student, Map<Subject, Ball>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addNewStudentAndSubjectAWithBall(Student student, Map<Subject, Ball> mapSubjectAndBall) {
        if (studentSubjects.get(student) != null) {
            log.error("Неподходящий метод, он только для новых студентов, " +
                    "попробуй метод: addNewSubjectWithBallForOldStudent");
            return;
        }
        studentSubjects.put(student, mapSubjectAndBall);
        for (Map.Entry<Subject, Ball> entry : mapSubjectAndBall.entrySet()) {
            Subject subject = entry.getKey();
            subjectStudents.putIfAbsent(subject, new ArrayList<>(List.of(student)));
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectWithBallForOldStudent(Student student, Subject subject, Ball ball) {
        if (studentSubjects.get(student) == null) {
            log.error("Данного студента нет в списке, попробуй метод " +
                    "addNewStudentAndSubjectAWithBall");
            return;
        }
        Map<Subject, Ball> subjectWithBall = studentSubjects.get(student);
        subjectWithBall.put(subject, ball);
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void removeStudentAndYouSubject(Student student) {
        if (studentSubjects.get(student) == null) {
            log.error("Данного студента нет в списке)");
            return;
        }
        studentSubjects.remove(student);
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            List<Student> students = entry.getValue();
            entry.getValue().remove(student);
            if (students.isEmpty()) {
                subjectStudents.remove(entry.getKey());
            }
        }
    }

    public void printAllStudentAndSubjectWithBall() {
        for (Map.Entry<Student, Map<Subject, Ball>> entry : studentSubjects.entrySet()) {
            System.out.println("Студент: " + entry.getKey().name() + "\n\tПредметы: ");
            entry.getValue().forEach((subject, ball) -> System.out.println("\t-"
                    + subject.name() + ", Оценка:" + ball));
        }
    }

    public void addNewSubjectAndStudent(Subject subject, List<Student> students) {
        if (subjectStudents.containsKey(subject)) {
            log.error("Такой предмет уже существует в списке, попробуй использовать другой метод");
            return;
        }
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, Ball.DEFAULT);
        }
    }

    public void addStudentOfOldSubject(Student student, Subject subject) {
        if (!subjectStudents.containsKey(subject)) {
            log.error("Воспользуйся другим методом, данного предмета нет в списке");
            return;
        }
        List<Student> students = subjectStudents.get(subject);
        if (students.contains(student)) {
            log.error("Данный студент уже находится в списке по данному предмету. Неподходящий метод");
            return;
        }
        students.add(student);
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, Ball.DEFAULT);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (!subjectStudents.containsKey(subject)) {
            log.error("неподходящий метод, данного предмета не существует");
            return;
        }
        if (subjectStudents.get(subject).remove(student)){
            studentSubjects.get(student).remove(subject);
        }
    }

    public void printAllSubjectWithStudent() {
        for (Map.Entry<Subject, List<Student>> entry: subjectStudents.entrySet()) {
            System.out.println("Предмет: " + entry.getKey().name() + "\n\t" + "Студенты: ");
            entry.getValue().forEach((student) -> System.out.println("\t-" + student.name()));

        }
    }
}
