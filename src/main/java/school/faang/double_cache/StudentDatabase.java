package school.faang.double_cache;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class StudentDatabase {

    Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Integer> subjectsWithGrades) {
        if (student == null || subjectsWithGrades == null) {
            throw new IllegalArgumentException("Student or subjects not be a null");
        }

        Map<Subject, Integer> existingSubjects = studentSubjects.getOrDefault(student, new HashMap<>());

        for (Map.Entry<Subject, Integer> entry : subjectsWithGrades.entrySet()) {
            existingSubjects.putIfAbsent(entry.getKey(), entry.getValue());
        }

        studentSubjects.put(student, existingSubjects);

        for (Subject subject : subjectsWithGrades.keySet()) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        if (student == null || subject == null || grade == null) {
            throw new IllegalArgumentException("Student, subject and grade cannot be null");
        }
        studentSubjects.computeIfAbsent(student, newMap -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects != null) {
            subjects.keySet().removeIf(subject -> {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                    return students.isEmpty();
                }
                return false;
            });
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println("Предмет: " + subject.getName());
            for (Student student : entry.getValue()) {
                System.out.println("   Студент: " + student.getName());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public String getAllStudentsWithGrades() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Student, Map<Subject, Integer>> studentEntry : studentSubjects.entrySet()) {
            Student student = studentEntry.getKey();
            sb.append("Student: ").append(student.getName()).append(" (ID: ").append(student.getId()).append(")\n");

            Map<Subject, Integer> subjects = studentEntry.getValue();
            if (subjects.isEmpty()) {
                sb.append("  No subjects\n");
            } else {
                for (Map.Entry<Subject, Integer> subjectEntry : subjects.entrySet()) {
                    sb.append("  Subject: ").append(subjectEntry.getKey().getName())
                            .append(" - Grade: ").append(subjectEntry.getValue()).append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}