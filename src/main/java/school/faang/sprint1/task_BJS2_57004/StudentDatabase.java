package school.faang.sprint1.task_BJS2_57004;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Класс StudentDatabase представляет базу данных студентов и их предметов.
 * Он позволяет добавлять, удалять и просматривать информацию о студентах и их оценках.
 */
@Getter // for tests
public class StudentDatabase {
    private static final int MIN_RATING = 0;
    private static final int MAX_RATING = 5;

    /**
     * Карта, хранящая информацию о студентах и их предметах с оценками.
     * Ключ — студент, значение — карта предметов и оценок.
     */
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();

    /**
     * Карта, хранящая информацию о предметах и студентах, которые их изучают.
     * Ключ — предмет, значение — множество студентов.
     */
    private final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    /**
     * Добавляет студента в базу данных с указанными предметами и оценками.
     * Если студент уже существует, то добавляет ему предметы и их оценки,
     *              если у студента уже есть такие предметы, то оценки обновятся на новые.
     *
     * @param name Имя студента, не может быть null или пустым.
     * @param subjects Предметы с оценками.
     *           Если карта со студентами пуста, студент добавится с пустой картой.
     *           Если предмет равен null он не добавится базу.
     *           Оценка студента по предмету. Должна быть в диапазоне от {@link #MIN_RATING} до {@link #MAX_RATING}.
     *           Если оценка у предмета не валидная, то предмет не добавится в базу.
     *
     * @throws IllegalArgumentException если name равен null или пустой
     */
    public void addStudent(String name, Map<Subject, Integer> subjects) {
        checkValidName(name);

        Student student = new Student(name);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());

        if (subjects == null) {
            return;
        }

        subjects.entrySet().stream()
                .filter(entry -> entry.getKey() != null)
                .filter(entry -> entry.getValue() == null || isValidRating(entry.getValue()))
                .forEach(entry -> {
                    studentSubjects.get(student).put(entry.getKey(), entry.getValue());

                    subjectStudents.computeIfAbsent(entry.getKey(), s -> new HashSet<>());
                    subjectStudents.get(entry.getKey()).add(student);
                });
    }

    /**
     * Добавляет предмет и оценку для указанного студента,
     * если предмет уже существует у студента, тогда обновляет его оценку.
     *
     * @param subject Предмет, который нужно добавить. Не может быть null.
     * @param student Студент, для которого добавляется предмет. Не может быть null.
     * @param rating Оценка студента по предмету. Должна быть в диапазоне от {@link #MIN_RATING} до {@link #MAX_RATING}.
     * @throws IllegalArgumentException Если subject или student равны null, либо если rating невалиден.
     */
    public void addSubjectToStudent(Subject subject, Student student, int rating) {
        checkValidSubject(subject);
        checkValidStudent(student);
        checkValidRating(rating);

        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        studentSubjects.get(student).put(subject, rating);

        subjectStudents.computeIfAbsent(subject, k -> new HashSet<>());
        subjectStudents.get(subject).add(student);
    }

    /**
     * Удаляет студента из базы данных.
     *
     * @param student Студент, которого нужно удалить.
     */
    public void removeStudent(Student student) {
        if (student == null || !studentSubjects.containsKey(student)) {
            return;
        }

        studentSubjects.get(student).keySet()
                .forEach(subject -> subjectStudents.get(subject).remove(student));
        studentSubjects.remove(student);
    }

    /**
     * Выводит информацию о всех студентах и их предметах с оценками.
     */
    public void printStudentInfo() {
        studentSubjects.forEach((student, subjects) -> {
            System.out.printf("Зачетка студента %s :\n", student.getName());
            subjects.forEach((subject, rating) ->
                    System.out.printf("%s - %d\n", subject.getName(), rating));
        });
    }

    /**
     * Добавляет новый предмет и связывает его с указанными студентами.
     *
     * @param subject Предмет, который нужно добавить. Не может быть null.
     * @param students Список студентов, которые будут изучать предмет,
     *                 если список равен null, создастся предмет с пустым множеством студентов,
     *                 если студент в списке равен null, он не добавится.
     * @throws IllegalArgumentException Если subject равен null.
     */
    public void addNewSubject(Subject subject, List<Student> students) {
        checkValidSubject(subject);
        subjectStudents.computeIfAbsent(subject, k -> new HashSet<>());

        if (students == null) {
            return;
        }

        students.stream()
                .filter(student -> student != null)
                .forEach(student -> {
                    subjectStudents.get(subject).add(student);
                    studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
                    studentSubjects.get(student).put(subject, null);
                });
    }

    /**
     * Добавляет студента в {@link #subjectStudents} список изучающих указанный предмет.
     * Добавляет предмет указанному студенту в {@link #studentSubjects}.
     *
     * @param subject Предмет, в который нужно добавить студента. Не может быть null.
     * @param student Студент, которого нужно добавить. Не может быть null.
     * @throws IllegalArgumentException Если subject или student равны null.
     */
    public void addStudentToSubject(Subject subject, Student student) {
        checkValidSubject(subject);
        checkValidStudent(student);

        subjectStudents.computeIfAbsent(subject, k -> new HashSet<>());
        subjectStudents.get(subject).add(student);

        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        studentSubjects.get(student).put(subject, null);
    }

    /**
     * Удаляет студента из {@link #subjectStudents} списка изучающих указанный предмет.
     * Удаляет у {@link #studentSubjects} студента указанный предмет.
     *
     * @param subject Предмет, из которого нужно удалить студента. Не может быть null.
     * @param student Студент, которого нужно удалить. Не может быть null.
     * @throws IllegalArgumentException Если subject или student равны null.
     */
    public void removeStudentFromSubject(Subject subject, Student student) {
        checkValidSubject(subject);
        checkValidStudent(student);

        studentSubjects.computeIfPresent(student, (key, subjects) -> {
            subjects.remove(subject);
            return subjects;
        });

        subjectStudents.computeIfPresent(subject, (key, students)  -> {
            students.remove(student);
            return students;
        });
    }

    /**
     * Выводит информацию о всех предметах и студентов изучающих их.
     */
    public void printSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.printf("Предмет %s изучают :\n", subject.getName());
            System.out.println(String.join(", ", (CharSequence) students));
            System.out.println();
        });
    }

    private boolean isValidRating(int rating) {
        return rating >= MIN_RATING && rating <= MAX_RATING;
    }

    private void checkValidRating(int rating) {
        if (!isValidRating(rating)) {
            throw new IllegalArgumentException("Не валидная оценка : " + rating);
        }
    }

    private void checkValidName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    private void checkValidSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Предмет не может быть пустым");
        }
    }

    private void checkValidStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Студент не может быть пустым");
        }
    }
}
