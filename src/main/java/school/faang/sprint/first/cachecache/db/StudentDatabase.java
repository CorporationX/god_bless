package school.faang.sprint.first.cachecache.db;

import lombok.NonNull;
import school.faang.sprint.first.cachecache.model.Student;
import school.faang.sprint.first.cachecache.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();


    public boolean addStudentWithAttr(@NonNull String studentName,
                                      @NonNull String subjectName,
                                      @NonNull Integer score
    ) {
        if (isDataInvalid(new Object[]{studentName, subjectName, score})) {
            return false;
        }

        workWithNewStudents(subjectName, Map.of(studentName, score));

        return true;
    }

    public boolean addSubjectForExistStudentWithScore(@NonNull String subjectName,
                                                      @NonNull String studentName,
                                                      @NonNull Integer score
    ) {
        if (isDataInvalid(new Object[]{studentName, subjectName, score})) {
            return false;
        }

        workWithNewStudents(subjectName, Map.of(studentName, score));

        return true;
    }

    public boolean deleteStudent(@NonNull String studentName) {
        if (studentName.isBlank()) {
            return false;
        }

        Student studentForDelete = new Student(studentName);
        Map<Subject, Integer> subjectScoresMap = studentSubjects.get(studentForDelete);

        if (subjectScoresMap == null || subjectScoresMap.isEmpty()) {
            return false;
        }

        subjectScoresMap.keySet()
                .forEach(subject -> subjectStudents.get(subject)
                        .removeIf(student -> student.equals(studentForDelete)));

        studentSubjects.remove(studentForDelete);

        return true;
    }

    public void printAllStudentsWithAttr() {
        StringBuilder stringBuilder = new StringBuilder();

        if (studentSubjects.isEmpty()) {
            System.out.println("Пока туть пусто");
            return;
        }

        for (var entry : studentSubjects.entrySet()) {
            stringBuilder
                    .append("Студент: ")
                    .append(entry.getKey().getName())
                    .append("\r\n")
                    .append("Данные по предметам: ")
                    .append("\r\n");

            for (var subject : entry.getValue().entrySet()) {
                stringBuilder
                        .append("- ")
                        .append(subject.getKey().getName())
                        .append(" - ")
                        .append(subject.getValue())
                        .append("\r\n");
            }

            stringBuilder.append("\r\n");
        }

        System.out.println(stringBuilder);
    }

    public boolean addSubjectWithStudents(@NonNull String subjectName, @NonNull Set<String> studentsName) {
        if (subjectName.isBlank() || studentsName.isEmpty()) {
            return false;
        }

        Map<String, Integer> studentScoresMap = studentsName.stream()
                .collect(Collectors.toMap(Function.identity(), s -> 0));

        workWithNewStudents(subjectName, studentScoresMap);

        return true;
    }

    public boolean addStudentToExistSubject(@NonNull String studentName, @NonNull String subjectName) {
        if (isDataInvalid(new Object[]{studentName, subjectName})) {
            return false;
        }

        workWithNewStudents(subjectName, Map.of(studentName, 0));

        return true;
    }

    public boolean removeStudentFromSubject(@NonNull String studentName, @NonNull String subjectName) {
        if (isDataInvalid(new Object[]{studentName, subjectName})) {
            return false;
        }

        Student studentForDelete = new Student(studentName);
        Subject subjectForRemoveStudent = new Subject(subjectName);

        Set<Student> studentsFromSubject = subjectStudents.get(subjectForRemoveStudent);

        if (studentsFromSubject == null || studentsFromSubject.isEmpty()) {
            return false;
        }

        studentSubjects.get(studentForDelete).remove(subjectForRemoveStudent);
        studentsFromSubject.remove(studentForDelete);

        return true;
    }

    public void printAllSubjectWithStudents() {
        StringBuilder stringBuilder = new StringBuilder();

        if (subjectStudents.isEmpty()) {
            System.out.println("Пока туть пусто");
            return;
        }

        for (var entry : subjectStudents.entrySet()) {
            stringBuilder
                    .append("Предмет: ")
                    .append(entry.getKey().getName())
                    .append("\r\n")
                    .append("Студенты: ")
                    .append("\r\n");

            for (var student : entry.getValue()) {
                stringBuilder
                        .append("- ")
                        .append(student.getName())
                        .append("\r\n");
            }

            stringBuilder.append("\r\n");
        }

        System.out.println(stringBuilder);
    }

    private void workWithNewStudents(@NonNull String subjectName, @NonNull Map<String, Integer> studentsScores) {
        Subject subject = new Subject(subjectName);

        for (Map.Entry<String, Integer> entry : studentsScores.entrySet()) {
            studentSubjects.computeIfAbsent(new Student(entry.getKey()), s -> new HashMap<>())
                    .putIfAbsent(subject, entry.getValue());
        }

        List<Student> students = studentsScores.keySet().stream()
                .map(this::mapNameToStudent)
                .collect(Collectors.toCollection(ArrayList::new));

        subjectStudents.computeIfAbsent(subject, s -> new HashSet<>()).addAll(students);
    }

    private Student mapNameToStudent(@NonNull String studentName) {
        return new Student(studentName);
    }

    private boolean isDataInvalid(Object[] objects) {
        boolean isInvalid = false;
        for (Object o : objects) {
            if (o instanceof String && ((String) o).isBlank()) {
                isInvalid = true;
            } else if (o instanceof Integer && (int) o < 0) {
                isInvalid = true;
            }
        }

        return isInvalid;
    }
}
