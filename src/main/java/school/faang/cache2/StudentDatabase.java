package school.faang.cache2;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class StudentDatabase {

    private static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECTS = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_STUDENTS = new HashMap<>();

    public static void addNewStudentWithSubjects(@NonNull Student student, @NonNull Map<Subject, Integer> subjects) {
        STUDENT_SUBJECTS.put(student, subjects);
        for (var subject : subjects.keySet()) {
            addNewSubjectWithStudents(subject, new ArrayList<>());
            addNewStudentToSubject(student, subject);
        }
    }

    public static void addNewSubjectToStudent(@NonNull Student student, @NonNull Subject subject,
                                              @NonNull Integer grade) {
        STUDENT_SUBJECTS.get(student).putIfAbsent(subject, grade);
        addNewSubjectWithStudents(subject, new ArrayList<>());
        addNewStudentToSubject(student, subject);
    }

    public static void deleteStudentWithSubjects(@NonNull Student student) {
        var removedStudentSubjects = STUDENT_SUBJECTS.remove(student);
        if (removedStudentSubjects == null) {
            System.out.printf("%s not found!\n", student);
            return;
        }
        for (var subject : removedStudentSubjects.keySet()) {
            deleteStudentFromSubject(student, subject);
        }
    }

    public static void printStudentsWithSubjects() {
        for (var studentSubjectEntry : STUDENT_SUBJECTS.entrySet()) {
            System.out.println(studentSubjectEntry.getKey());
            for (var subjectGradeEntry : studentSubjectEntry.getValue().entrySet()) {
                System.out.printf("- %s: %s\n", subjectGradeEntry.getKey(), subjectGradeEntry.getValue());
            }
        }
    }

    public static void addNewSubjectWithStudents(@NonNull Subject subject, @NonNull List<Student> students) {
        SUBJECT_STUDENTS.putIfAbsent(subject, students);
    }

    public static void addNewStudentToSubject(@NonNull Student student, @NonNull Subject subject) {
        SUBJECT_STUDENTS.get(subject).add(student);
    }

    public static void deleteStudentFromSubject(@NonNull Student student, @NonNull Subject subject) {
        var isStudentRemoved = SUBJECT_STUDENTS.get(subject).remove(student);
        if (!isStudentRemoved) {
            System.out.printf("%s deleted from %s subject list\n", student, subject);
        }
    }

    public static void printSubjectsWithStudents() {
        for (var subjectStudentEntry : SUBJECT_STUDENTS.entrySet()) {
            System.out.println(subjectStudentEntry.getKey());
            for (var student : subjectStudentEntry.getValue()) {
                System.out.printf("- %s\n", student);
            }
        }
    }
}
