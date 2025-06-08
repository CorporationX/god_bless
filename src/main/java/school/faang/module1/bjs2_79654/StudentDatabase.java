package school.faang.module1.bjs2_79654;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class StudentDatabase {

    private final Map<Student, Map<Subject, Optional<Integer>>> studentSubjects;
    private final Map<Subject, List<Student>> subjectStudents;

    public void addStudentWithSubjects(Student student, Map<Subject, Optional<Integer>> grades) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (grades == null) {
            throw new IllegalArgumentException("Grades map cannot be null");
        }
        if (!studentSubjects.containsKey(student)) {
            studentSubjects.put(student, new HashMap<>(grades));
            updateSubjectsWithStudent(student, grades);
        }
    }

    private void updateSubjectsWithStudent(Student student, Map<Subject, Optional<Integer>> grades) {
        for (Subject subject : grades.keySet()) {
            List<Student> students = subjectStudents.computeIfAbsent(subject, subjectKey -> new ArrayList<>());
            if (!students.contains(student)) {
                students.add(student);
            }
        }
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
        studentSubjects.computeIfAbsent(student, studentKey -> new HashMap<>()).put(subject, Optional.of(grade));
        List<Student> students = subjectStudents.computeIfAbsent(subject, subjectKey -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        Map<Subject, Optional<Integer>> grades = studentSubjects.remove(student);
        if (grades != null) {
            removeStudentFromSubjects(student, grades.keySet());
        }
    }

    private void removeStudentFromSubjects(Student student, Set<Subject> subjects) {
        for (Subject subject : subjects) {
            List<Student> students = subjectStudents.get(subject);
            if (students != null) {
                students.remove(student);
                if (students.isEmpty()) {
                    subjectStudents.remove(subject);
                }
            }
        }
    }

    public String getAllStudentsWithGrades() {
        StringBuilder stringBuilder = new StringBuilder();
        studentSubjects.forEach((student, gradesMap) -> {
            stringBuilder.append("Студент: ").append(student.getName()).append("\n");
            gradesMap.forEach((subject, gradeOptional) -> stringBuilder.append("  ")
                    .append(subject.getName())
                    .append(": ")
                    .append(formatGrade(gradeOptional.orElse(null)))
                    .append("\n"));
        });
        return stringBuilder.toString();
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
        if (students == null) {
            throw new IllegalArgumentException("Students list cannot be null");
        }
        subjectStudents.put(subject, new ArrayList<>(students));
        addSubjectToEachStudent(subject, students);
    }

    private void addSubjectToEachStudent(Subject subject, List<Student> students) {
        for (Student student : students) {
            studentSubjects
                    .computeIfAbsent(student, studentKey -> new HashMap<>())
                    .putIfAbsent(subject, Optional.empty());
        }
    }

    public void addStudentToSubject(Subject subject, Student student) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        List<Student> students = subjectStudents.computeIfAbsent(subject, subjectKey -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
        Map<Subject, Optional<Integer>> subjects = studentSubjects.computeIfAbsent(student, studentKey -> new HashMap<>());
        subjects.putIfAbsent(subject, Optional.empty());
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }
        removeSubjectFromStudent(student, subject);
    }

    private void removeSubjectFromStudent(Student student, Subject subject) {
        Map<Subject, Optional<Integer>> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject);
            if (grades.isEmpty()) {
                studentSubjects.remove(student);
            }
        }
    }

    public String getAllSubjectsWithStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        subjectStudents.forEach((subject, students) -> {
            stringBuilder.append("Предмет: ").append(subject.getName()).append("\n");
            students.forEach(student -> stringBuilder.append("  ").append(student.getName()).append("\n"));
        });
        return stringBuilder.toString();
    }

    private String formatGrade(Integer grade) {
        return grade != null ? String.valueOf(grade) : "нет оценки";
    }
}