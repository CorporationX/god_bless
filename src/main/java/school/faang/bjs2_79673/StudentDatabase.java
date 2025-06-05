package school.faang.bjs2_79673;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@ToString
public class StudentDatabase {
    private final Map<Student, Map<Subject, Grade>> studentSubject = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Grade> subjectsWithGrades) {
        if (!(isValidStudent(student) && isValidGrades(subjectsWithGrades))) {
            return;
        }

        studentSubject.put(student, subjectsWithGrades);
        for (var subjectWithGrade : subjectsWithGrades.entrySet()) {
            subjectStudents.computeIfAbsent(subjectWithGrade.getKey(), key -> new ArrayList<>()).add(student);
        }
    }

    //ОШибка в обновлении уже существующего предмета
    public void addSubjectWithGradeToStudent(Student student, Subject subject, Grade grade) {
        if (!(isValidStudent(student) && isValidSubject(subject) && isValidGrade(grade))) {
            log.warn("Invalid argument");
            return;
        }

        studentSubject.computeIfPresent(student, (key, logOfGrades) -> {
            logOfGrades.putIfAbsent(subject, grade);
            return logOfGrades;
        });

        List<Student> students = subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        if (!isValidStudent(student)) {
            return;
        }
        Map<Subject, Grade> removedStudent = studentSubject.remove(student);
        if (removedStudent == null) {
            System.out.println("Student " + student.getName() + " is not exist");
            return;
        }

        for (Subject subject : removedStudent.keySet()) {
            subjectStudents.get(subject).remove(student);
            if (subjectStudents.get(subject).isEmpty()) {
                subjectStudents.remove(subject);
            }
        }
    }

    public void printAll() {
        log.info(String.valueOf(studentSubject));
        log.info(String.valueOf(subjectStudents));
    }

    private boolean isValidStudent(Student student) {
        return student != null && !student.getName().isBlank();
    }

    private boolean isValidSubject(Subject subject) {
        return subject != null && !subject.getName().isBlank();
    }

    private boolean isValidGrade(Grade grade) {
        return grade != null;
    }

    private boolean isValidGrades(Map<Subject, Grade> subjectsWithGrades) {
        return subjectsWithGrades != null;
    }


}
