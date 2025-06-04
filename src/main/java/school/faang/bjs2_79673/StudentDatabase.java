package school.faang.bjs2_79673;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ToString
public class StudentDatabase {
    private Map<Student, Map<Subject, Grade>> studentSubject = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Grade> subjectsWithGrades) {
        if (!(isValidStudent(student) && isValidGrades(subjectsWithGrades))) {
            return;
        }

        studentSubject.put(student, subjectsWithGrades);
        for (var subjectWithGrade : subjectsWithGrades.entrySet()) {
            subjectStudents.computeIfAbsent(subjectWithGrade.getKey(), key -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectWithGrade(Student student, Subject subject, Grade grade) {
        if (!isValidStudent(student)) {
            return;
        }

        studentSubject.computeIfPresent(student, (key, logOfGrades) -> {
            logOfGrades.put(subject, grade);
            return logOfGrades;
        });
    }

    private boolean isValidStudent(Student student) {
        return student != null;
    }

    private boolean isValidGrades(Map<Subject, Grade> subjectsWithGrades) {
        return subjectsWithGrades != null;
    }


}
