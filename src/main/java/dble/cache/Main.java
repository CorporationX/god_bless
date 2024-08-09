package dble.cache;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Main {
    private final Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void main(String[] args) {
        var cache = new Main();
        Subject subject1 = new Subject("Math");
        Subject subject2 = new Subject("Biology");
        Subject subject3 = new Subject("Chemistry");
        Student student1 = new Student("Petya");
        Student student2 = new Student("Kolya");
        Student student3 = new Student("Vasya");
        var students1 = new ArrayList<>(List.of(student1, student2));
        var students2 = new ArrayList<>(List.of(student2));
        var students3 = new ArrayList<>(List.of(student1, student3));
        var grades1 = new HashMap<>(Map.of(
                subject1, 4,
                subject3, 5));
        var grades2 = new HashMap<>(Map.of(
                subject2, 4,
                subject3, 5));
        var grades3 = new HashMap<>(Map.of(
                new Subject("English"), 4,
                subject3, 5));
        cache.addSubjectStudents(subject1, students1);
        cache.addSubjectStudents(subject2, students2);
        cache.addSubjectStudents(subject3, students3);
        cache.printAllSubjectsStudents();
        cache.addSubjectStudents(subject1, students1);
        cache.addStudentToSubject(subject2, student3);
        cache.addStudentToSubject(subject1, student1);
        cache.addStudentToSubject(new Subject("English"), student1);
        cache.printAllSubjectsStudents();
        cache.removeStudentFromSubject(subject2, student3);
        cache.removeStudentFromSubject(subject1, new Student("Aboba"));
        cache.removeStudentFromSubject(new Subject("Programming"), student1);
        cache.printAllSubjectsStudents();
        cache.addStudentGrades(student1, grades1);
        cache.addStudentGrades(student2, grades2);
        cache.addStudentGrades(student3, grades3);
        cache.addStudentGrades(student1, grades1);
        cache.printAllStudentsGrades();
        cache.addStudentToSubject(subject2, student1);
        cache.addGradeForStudent(student1, subject1, 5);
        cache.addGradeForStudent(new Student("Aboba"), subject1, 5);
        cache.addGradeForStudent(student1, subject2, 5);
        cache.addGradeForStudent(student1, new Subject("PE"), 5);
        cache.printAllStudentsGrades();
        cache.removeStudentGrades(student1);
        cache.removeStudentGrades(student3);
        cache.printAllStudentsGrades();
    }

    public void addStudentGrades(@NonNull Student student, @NonNull Map<Subject, Integer> grades) {
        if (studentGrades.containsKey(student)) {
            System.out.println("\nStudent grades already added");
        } else {
            for (Subject subject : grades.keySet()) {
                if (subjectStudents.containsKey(subject)) {
                    if (!subjectStudents.get(subject).contains(student)) {
                        System.out.println("\nStudent not in this subject list");
                        return;
                    }
                } else {
                    System.out.println("\nStudent has grade for subject not in the subject list");
                    return;
                }
            }
            studentGrades.put(student, grades);
            System.out.println("\nStudent grades added");
        }
    }

    public void addGradeForStudent(@NonNull Student student, @NonNull Subject subject, int grade) {
        if (studentGrades.containsKey(student)) {
            if (!studentGrades.get(student).containsKey(subject)) {
                if (subjectStudents.containsKey(subject)) {
                    if (subjectStudents.get(subject).contains(student)) {
                        studentGrades.get(student).put(subject, grade);
                        System.out.println("\nGrade added");
                    } else {
                        System.out.println("\nStudent not in this subject list");
                    }
                } else {
                    System.out.println("\nDon't have this subject in the list");
                }
            } else {
                System.out.println("\nStudent already has this subject grade");
            }
        } else {
            System.out.println("\nDon't have grades for this student");
        }
    }

    public void removeStudentGrades(@NonNull Student student) {
        if (studentGrades.containsKey(student)) {
            studentGrades.remove(student);
            System.out.println("\nGrades for this student removed");
        } else {
            System.out.println("\nDon't have grades for this student");
        }
    }

    public void printAllStudentsGrades() {
        System.out.println();
        studentGrades.forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach((subject, grade) -> System.out.println("    " + subject + " : " + grade));
        });
    }

    public void addSubjectStudents(@NonNull Subject subject, @NonNull List<Student> students) {
        if (subjectStudents.containsKey(subject)) {
            System.out.println("\nThis subject already added");
        } else {
            subjectStudents.put(subject, students);
            System.out.println("\nSubject added");
        }
    }

    public void addStudentToSubject(@NonNull Subject subject, @NonNull Student student) {
        if (subjectStudents.containsKey(subject)) {
            if (subjectStudents.get(subject).contains(student)) {
                System.out.println("\nThis student already in this subject list");
            } else {
                subjectStudents.get(subject).add(student);
                System.out.println("\nStudent added to subject");
            }
        } else {
            System.out.println("\nNo such subject!");
        }
    }

    public void removeStudentFromSubject(@NonNull Subject subject, @NonNull Student student) {
        if (subjectStudents.containsKey(subject)) {
            if (subjectStudents.get(subject).contains(student)) {
                subjectStudents.get(subject).remove(student);
                System.out.println("\nStudent remove from subject");
            } else {
                System.out.println("\nNo such student in the subject list");
            }
        } else {
            System.out.println("\nNo such subject!");
        }
    }

    public void printAllSubjectsStudents() {
        System.out.println();
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(student -> System.out.println("    " + student));
        }
    }
}
