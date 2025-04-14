package school.faang.doubleCache;

import lombok.Getter;
import school.faang.doubleCache.model.Student;
import school.faang.doubleCache.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects;
    private final Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {
        this.studentSubjects = new HashMap<>();
        this.subjectStudents = new HashMap<>();
    }

    public Student addStudent(Student student, Map<Subject, Integer> marks) {
        studentSubjects.put(student, marks);
        for (Map.Entry<Subject, Integer> subjectIntegerEntry : marks.entrySet()) {
            subjectStudents.computeIfAbsent(subjectIntegerEntry.getKey(), key -> new ArrayList<>()).add(student);
        }
        return student;
    }

    public Subject addSubjectForExistingStudent(Subject subject, Integer mark, Student student) {
        if (!studentSubjects.keySet().contains(student)) {
            throw new RuntimeException(String.format("Student with name %s not found", student.getName()));
        }
        subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
        studentSubjects.get(student).put(subject, mark);
        return subject;
    }

    public Student deleteStudent(Student student) {
        Map<Subject, Integer> subjects = studentSubjects.remove(student);
        subjects.forEach((key, value) -> subjectStudents.get(key).remove(student));
        return student;
    }

    public String getStudentMarks() {
        return studentSubjects.toString();
    }

    public Subject addSubject(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        students.forEach(student -> studentSubjects.get(student).put(subject, null));
        return subject;
    }

    public Student addStudentToExistingSubject(Student student, Subject subject, Integer mark) {
        if (!subjectStudents.keySet().contains(subject)) {
            throw new RuntimeException(String.format("Subject with name %s not found", subject.getName()));
        }
        studentSubjects.computeIfAbsent(student, key -> new HashMap<>()).put(subject, mark);
        subjectStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
        return student;
    }

    public Student deleteStudentFromSubject(Student student, Subject subject) {
        if (subjectStudents.keySet().contains(subject) && studentSubjects.keySet().contains(student)) {
            subjectStudents.get(subject).remove(student);
            studentSubjects.get(student).remove(subject);
        }
        return student;
    }

    public String getSubjectsForStudents() {
        return subjectStudents.toString();
    }
}
