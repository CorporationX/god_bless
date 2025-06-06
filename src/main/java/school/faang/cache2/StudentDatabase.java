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

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addNewStudentWithSubjects(@NonNull Student student, @NonNull Map<Subject, Integer> subjects) {
        studentSubjects.put(student, subjects);
        for (var subject : subjects.keySet()) {
            addNewSubjectWithStudents(subject, new ArrayList<>());
            addNewStudentToSubject(student, subject);
        }
    }

    public void addNewSubjectToStudent(@NonNull Student student, @NonNull Subject subject,
                                              @NonNull Integer grade) {
        studentSubjects.get(student).putIfAbsent(subject, grade);
        addNewSubjectWithStudents(subject, new ArrayList<>());
        addNewStudentToSubject(student, subject);
    }

    public void deleteStudentWithSubjects(@NonNull Student student) {
        var removedStudentSubjects = studentSubjects.remove(student);
        if (removedStudentSubjects == null) {
            System.out.printf("%s not found!\n", student);
            return;
        }
        for (var subject : removedStudentSubjects.keySet()) {
            deleteStudentFromSubject(student, subject);
        }
    }

    public void printStudentsWithSubjects() {
        for (var studentSubjectEntry : studentSubjects.entrySet()) {
            System.out.println(studentSubjectEntry.getKey());
            for (var subjectGradeEntry : studentSubjectEntry.getValue().entrySet()) {
                System.out.printf("- %s: %s\n", subjectGradeEntry.getKey(), subjectGradeEntry.getValue());
            }
        }
    }

    public void addNewSubjectWithStudents(@NonNull Subject subject, @NonNull List<Student> students) {
        subjectStudents.putIfAbsent(subject, students);
    }

    public void addNewStudentToSubject(@NonNull Student student, @NonNull Subject subject) {
        subjectStudents.get(subject).add(student);
    }

    public void deleteStudentFromSubject(@NonNull Student student, @NonNull Subject subject) {
        var isStudentRemoved = subjectStudents.get(subject).remove(student);
        if (!isStudentRemoved) {
            System.out.printf("%s deleted from %s subject list\n", student, subject);
        }
    }

    public void printSubjectsWithStudents() {
        for (var subjectStudentEntry : subjectStudents.entrySet()) {
            System.out.println(subjectStudentEntry.getKey());
            for (var student : subjectStudentEntry.getValue()) {
                System.out.printf("- %s\n", student);
            }
        }
    }
}
