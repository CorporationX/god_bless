package school.faang.bjs2_68782;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
@Getter
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    /**
     * Добавление нового студента и его предметов с оценками.
     */
    public void addStudentWithSubjectsAndGrade(Student student, Map<Subject, Integer> subjectsWithGrades) {
        if (studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Студент %s уже есть в списке".formatted(student));
        }
        studentSubjects.computeIfAbsent(student, stud -> new HashMap<>(subjectsWithGrades));
    }

    /**
     * Добавление нового предмета для существующего студента с оценкой.
     */
    public void addSubjectsForStudent(Student student, Map<Subject, Integer> subjectsWithGrades) {
        if (!studentSubjects.containsKey(student)) {
            log.info("Студент {} отсутствует в списке, предметы не были обновлены", student);
        }
        studentSubjects.computeIfPresent(student, (stud, subGrades) -> {
            subjectsWithGrades.forEach(
                    (subject, grade) -> subGrades.computeIfAbsent(subject, sub -> grade));
            return subGrades;
        });
    }

    /**
     * Удаление студента и его предметов.
     */
    public void deleteStudentWithSubjects(Student student) {
        if (studentSubjects.remove(student) == null) {
            throw new NoSuchElementException("Студент %s отсутствует в списке, не был удалён".formatted(student));
        }
    }

    /**
     * Вывод списка всех студентов и их оценок по предметам.
     */
    public void printStudentInfo() {
        studentSubjects.forEach((student, sub) -> {
            log.info(student.toString());
            sub.forEach((subject, grade) ->
                    log.info("{} - {}", subject, grade));
        });
    }

    /**
     * Добавление нового предмета и списка студентов, изучающих его.
     */
    private void addSubjectWithStudents(Subject subject, List<Student> students) {
    }

    /**
     * Добавление студента к существующему предмету.
     */
    private void addStudentToSubject(Subject subject, Student student) {
    }

    /**
     * Удаление студента из предмета.
     */
    private void deleteStudentFromSubject(Subject subject, Student student) {
    }

    /**
     * Вывод списка всех предметов и студентов, изучающих их.
     */
    private void printSubjectInfo(Subject subject) {
    }
}
