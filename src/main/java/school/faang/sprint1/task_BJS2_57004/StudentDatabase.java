package school.faang.sprint1.task_BJS2_57004;

import lombok.NonNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    /**
     * Добавляет в базу студента с его предметами и их оценками
     * Если студент уже существует, то добавляет ему предметы и их оценки
     * Если у студента уже есть такие предметы то оценки обновятся на новые
     *
     * @param name не может быть null или пустым
     *             если {@param name} null или пустым будет выброшено исключение IllegalArgumentException
     * @param subjectsWithRatings не может быть null или пустым
     *             если {@param subjectsWithRatings} null или пустым будет выброшено исключение IllegalArgumentException
     */

    public void addStudent(@NonNull String name, @NonNull Map<Subject, Integer> subjectsWithRatings) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        Student student = new Student(name);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        studentSubjects.get(student).putAll(subjectsWithRatings);


        subjectsWithRatings.keySet().forEach(subject -> {
            subjectStudents.computeIfAbsent(subject, s -> new HashSet<>());
            subjectStudents.get(subject).add(student);
        });
    }

    public void addSubjectToStudent(Subject subject, Student student, int rating) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        studentSubjects.get(student).put(subject, rating);

        subjectStudents.computeIfAbsent(subject, k -> new HashSet<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        studentSubjects.get(student).keySet()
                .forEach(subject -> subjectStudents.get(subject).remove(student));
        studentSubjects.remove(student);
    }

    public void printStudentInfo() {
        studentSubjects.forEach((student, subjects) -> {
            System.out.printf("Зачетка студента %s :\n", student.getName());
            subjects.forEach((subject, rating) ->
                    System.out.printf("%s - %d\n", subject.getName(), rating));
        });
    }

    public void addNewSubject(Subject subject, List<Student> students) {
        subjectStudents.get(subject).addAll(students);
        students.forEach(student -> {
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        });
    }

    public void addStudentToSubject(Subject subject, Student student) {
        subjectStudents.computeIfAbsent(subject, k -> new HashSet<>());
        subjectStudents.get(subject).add(student);

        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        studentSubjects.get(student).put(subject, null);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        studentSubjects.computeIfPresent(student, (key, subjects) -> {
            subjects.remove(subject);
            return subjects;
        });

        subjectStudents.computeIfPresent(subject, (key, students)  -> {
            students.remove(student);
            return students;
        });
    }

    public void printSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.printf("Предмет %s изучают :\n", subject.getName());
            System.out.println(String.join(", ", (CharSequence) students));
            System.out.println();
        });
    }
}
