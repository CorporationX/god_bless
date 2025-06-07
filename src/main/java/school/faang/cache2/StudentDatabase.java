package school.faang.cache2;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
@Getter
public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public final void addNewStudentWithSubjects(@NonNull Student student, @NonNull Map<Subject, Integer> subjects) {
        studentSubjects.put(student, subjects);
        for (var subject : subjects.keySet()) {
            addNewSubjectWithStudents(subject, new ArrayList<>());
            addNewStudentToSubject(student, subject);
        }
    }

    public final void addNewSubjectToStudent(@NonNull Student student, @NonNull Subject subject,
                                              @NonNull Integer grade) {
        studentSubjects.get(student).putIfAbsent(subject, grade);
        addNewSubjectWithStudents(subject, new ArrayList<>());
        addNewStudentToSubject(student, subject);
    }

    public final void deleteStudentWithSubjects(@NonNull Student student) {
        var removedStudentSubjects = studentSubjects.remove(student);
        if (removedStudentSubjects == null) {
            System.out.printf("%s not found!%n", student);
            return;
        }
        for (var subject : removedStudentSubjects.keySet()) {
            deleteStudentFromSubject(student, subject);
        }
    }

    public final void printStudentsWithSubjects() {
        for (var studentSubjectEntry : studentSubjects.entrySet()) {
            System.out.println(studentSubjectEntry.getKey());
            for (var subjectGradeEntry : studentSubjectEntry.getValue().entrySet()) {
                System.out.printf("- %s: %s%n", subjectGradeEntry.getKey(), subjectGradeEntry.getValue());
            }
        }
    }

    public final void addNewSubjectWithStudents(@NonNull Subject subject, @NonNull List<Student> students) {
        subjectStudents.putIfAbsent(subject, students);
    }

    public final void addNewStudentToSubject(@NonNull Student student, @NonNull Subject subject) {
        if (isSubjectNotExist(subject)) {
            return;
        }
        subjectStudents.get(subject).add(student);
    }

    public final void deleteStudentFromSubject(@NonNull Student student, @NonNull Subject subject) {
        if (isSubjectNotExist(subject)) {
            return;
        }
        var isStudentRemoved = subjectStudents.get(subject).remove(student);
        if (!isStudentRemoved) {
            System.out.printf("%s deleted from %s list%n", student, subject);
        }
    }

    private boolean isSubjectNotExist(@NonNull Subject subject) {
        if (!subjectStudents.containsKey(subject)) {
            System.out.printf("%s doesn't exist!%n", subject);
            return true;
        }
        return false;
    }

    public final void printSubjectsWithStudents() {
        for (var subjectStudentEntry : subjectStudents.entrySet()) {
            System.out.println(subjectStudentEntry.getKey());
            for (var student : subjectStudentEntry.getValue()) {
                System.out.printf("- %s%n", student);
            }
        }
    }
}
