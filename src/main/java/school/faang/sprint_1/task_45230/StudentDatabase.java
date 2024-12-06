package school.faang.sprint_1.task_45230;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentsGrades = new HashMap<>();
    private final Map<Subject, Set<Student>> studentsLearningSubjects = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentsGrades.put(student, grades);
        for (var subject : grades.keySet()) {
            studentsLearningSubjects.computeIfAbsent(subject, (key) -> new HashSet<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grate) {
        var studentGrades = studentsGrades.get(student);
        if (studentGrades != null) {
            studentGrades.put(subject, grate);
            studentsLearningSubjects.computeIfAbsent(subject, key -> new HashSet<>()).add(student);
        }
    }

    public void removeStudent(Student student) {
        var studentSubjects = studentsGrades.get(student);
        if (studentSubjects != null) {
            studentsGrades.remove(student);
            for (var subject : studentSubjects.keySet()) {
                var subjectStudents = studentsLearningSubjects.get(subject);
                if (subjectStudents == null) {
                    continue;
                }
                subjectStudents.remove(student);
                if (subjectStudents.isEmpty()) {
                    studentsLearningSubjects.remove(subject);
                }
            }
        }
    }

    public void printAllStudentsWithTheirEstimates() {
        for (var studentGrades : studentsGrades.entrySet()) {
            System.out.println(studentGrades.getKey() + ":");
            studentGrades.getValue()
                    .forEach((key, value) -> System.out.println(key.getName() + " : " + value));
        }
    }

    public void addSubjectAndStudentsLearningIt(Subject subject, Map<Student, Integer> studentsEstimates) {
        studentsLearningSubjects.put(subject, studentsEstimates.keySet());
        for (var studentEstimate : studentsEstimates.entrySet()) {
            studentsGrades.computeIfAbsent(studentEstimate.getKey(), (key) -> new HashMap<>())
                    .put(subject, studentEstimate.getValue());
        }
    }

    public void addStudentForSubject(Student student, Subject subject, int grade) {
        var studentsLearningSubject = studentsLearningSubjects.get(subject);
        if (studentsLearningSubject == null) {
            throw new NoSuchElementException("Subject not exist");
        }
        studentsLearningSubject.add(student);
        studentsGrades.computeIfAbsent(student, key -> new HashMap<>()).put(subject, grade);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        var studentEstimates = studentsGrades.get(student);
        if (studentEstimates == null) {
            throw new NoSuchElementException("Student don`t learning this subject");
        }
        studentEstimates.remove(subject);
        var subjectStudents = studentsLearningSubjects.get(subject);
        if (subjectStudents == null) {
            throw new NoSuchElementException("Subject nobody learning");
        }
        subjectStudents.remove(student);
    }

    public void printAllSubjectAndStudentsLearningTheir() {
        for (var subjectStudents : studentsLearningSubjects.entrySet()) {
            System.out.println(subjectStudents.getKey() + ":");
            subjectStudents.getValue()
                    .forEach(value -> System.out.println(value.getName()));
        }
    }
}
