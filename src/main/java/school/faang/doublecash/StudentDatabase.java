package school.faang.doublecash;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {

    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addSubjectToStudent(Student student, Subject subject, int mark) {
        studentSubjects
                .computeIfAbsent(student, subjectMark -> new HashMap<>()).put(subject, mark);
        subjectStudents
                .computeIfAbsent(subject, students -> new ArrayList<>()).add(student);
    }

    public void addStudentWithGrades(Student student, Map<Subject, Integer> subjectMarks) {
        studentSubjects
                .computeIfAbsent(student, subjectMark -> new HashMap<>()).putAll(subjectMarks);
        for (Map.Entry<Subject, Integer> subjectMark : subjectMarks.entrySet()) {
            subjectStudents.computeIfAbsent(subjectMark.getKey(),
                    students -> new ArrayList<>()).add(student);
        }
    }

    public void removeStudent(Student student) {
        studentSubjects.remove(student);
        List<Student> students;
        Iterator<Map.Entry<Subject, List<Student>>> subjectStudentsIterator =
                subjectStudents.entrySet().iterator();
        while (subjectStudentsIterator.hasNext()) {
            Map.Entry<Subject, List<Student>> subjectStudentsEntry = subjectStudentsIterator.next();
            List<Student> studentsBySubject = subjectStudentsEntry.getValue();
            studentsBySubject.remove(student);
            if (studentsBySubject.isEmpty()) {
                subjectStudentsIterator.remove();
            }
        }
    }

    public void printAllStudentsWithMarks() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Student, Map<Subject, Integer>> studentAndMarks : studentSubjects.entrySet()) {
            sb.append("=".repeat(30)).append("\n");
            sb.append("Информация о студенте: ").append(studentAndMarks.getKey().getName()).append("\n");
            for (Map.Entry<Subject, Integer> subjectMark : studentAndMarks.getValue().entrySet()) {
                sb.append("По предмету - ").append(subjectMark.getKey()).append(" оценка - ")
                        .append(subjectMark.getValue()).append("\n");
            }
        }
        sb.append("=".repeat(30));
        System.out.println(sb);
    }

    public void addNewSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.computeIfAbsent(subject,
                studentsList -> new ArrayList<>()).addAll(students);
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, students -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }
    }

    public void printAllSubjectStudents() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Subject, List<Student>> subjectStudent : subjectStudents.entrySet()) {
            sb.append("=".repeat(30)).append("\n");
            sb.append("Предмет ").append(subjectStudent.getKey()).append(" изучают студенты:").append("\n");
            for (Student student : subjectStudent.getValue()) {
                sb.append(" - ").append(student.getName()).append("\n");
            }
        }
        sb.append("=".repeat(30));
        System.out.println(sb);
    }
}
