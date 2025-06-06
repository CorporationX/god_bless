package school.faang.module1.bjs2_79654;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubjects;
    private final Map<Subject, List<Student>> subjectStudents;

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> grades) {
        if (!studentSubjects.containsKey(student)) {
            studentSubjects.put(student, new HashMap<>(grades));
            updateSubjectsWithStudent(student, grades);
        }
    }

    private void updateSubjectsWithStudent(Student student, Map<Subject, Integer> grades) {
        for (Subject subject : grades.keySet()) {
            List<Student> students = subjectStudents.computeIfAbsent(subject, s -> new ArrayList<>());
            if (!students.contains(student)) {
                students.add(student);
            }
        }
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        List<Student> students = subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentSubjects.remove(student);
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

    public void printAllStudentsWithGrades() {
        studentSubjects.forEach((student, gradesMap) -> {
            System.out.println("Студент: " + student.getName());
            gradesMap.forEach((subject, grade) ->
                    System.out.println("  " + subject.getName() + ": " + grade)
            );
        });
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        addSubjectToEachStudent(subject, students);
    }

    private void addSubjectToEachStudent(Subject subject, List<Student> students) {
        for (Student student : students) {
            studentSubjects
                    .computeIfAbsent(student, k -> new HashMap<>())
                    .putIfAbsent(subject, null);
        }
    }

    public void addStudentToSubject(Subject subject, Student student) {
        List<Student> students = subjectStudents.computeIfAbsent(subject, (newSubject) -> new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
        }
        Map<Subject, Integer> subjects = studentSubjects.computeIfAbsent(student, (newStudent) -> new HashMap<>());
        subjects.putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
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
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject);
            if (grades.isEmpty()) {
                studentSubjects.remove(student);
            }
        }
    }

    public void printAllSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.println("Предмет: " + subject.getName());
            students.forEach(student -> System.out.println("  " + student.getName()));
        });
    }
}
