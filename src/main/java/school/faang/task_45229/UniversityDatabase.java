package school.faang.task_45229;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
public class UniversityDatabase {
    private final Map<Student, Map<Subject, Integer>> studentsWithGrades = new HashMap<>();
    //решил поменять List<Student> из задания на Set, чтобы обеспечить сохранение только уникальных студентов
    private final Map<Subject, Set<Student>> subjectsWithStudents = new HashMap<>();

    public void addStudentAndGrades(Student student, Map<Subject, Integer> studentGrades) {
        if (student == null || studentGrades == null) {
            throw new IllegalArgumentException("Invalid params");
        }
        for (Subject subject : studentGrades.keySet()) {
            //Стоит ли делать тут проверку на subject == null, и как это сделать? с простым пропуском null элемента,
            //или сделать что-то вроде транзакции
            //if (subject == null) {
            //    throw new IllegalArgumentException("Subject is null");
            //}
            subjectsWithStudents.computeIfAbsent(subject, key -> new HashSet<>())
                    .add(student);
        }
        studentsWithGrades.put(student, studentGrades);
    }

    public void addSubjectWithGradeToStudent(Subject subject, Student student, Integer grade) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Invalid params");
        }

        studentsWithGrades.computeIfAbsent(student, key -> new HashMap<>()).put(subject, grade);
        subjectsWithStudents.computeIfAbsent(subject, key -> new HashSet<>()).add(student);
    }

    public void removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student is null");
        }
        studentsWithGrades.remove(student);
        for (Set<Student> subjectStudents : subjectsWithStudents.values()) {
            subjectStudents.remove(student);
        }
    }

    public void printStudentsWithGrades() {
        if (studentsWithGrades.isEmpty()) {
            System.out.println("There are no students in the university database");
        }

        for (Map.Entry<Student, Map<Subject, Integer>> studentMapEntry : studentsWithGrades.entrySet()) {
            System.out.println(studentMapEntry.getKey());

            for (Map.Entry<Subject, Integer> studentGradeEntry : studentMapEntry.getValue().entrySet()) {
                System.out.println(studentMapEntry.getKey() + " - Grade: " + studentGradeEntry.getValue());
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    public void addNewSubject(Subject subject, Set<Student> students) {
        if (subject == null || students == null) {
            throw new IllegalArgumentException("Invalid params");
        }

        subjectsWithStudents.computeIfAbsent(subject, key -> new HashSet<>()).addAll(students);

        for (Student student : students) {
            studentsWithGrades.computeIfAbsent(student, key -> new HashMap<>()).put(subject, null);
        }
    }

    public void addStudentToSubject(Subject subject, Student student) {
        //Если принять логику, что оценка null == отсутствие оценки, то можно переиспользовать другой метод
        addSubjectWithGradeToStudent(subject, student, null);
    }

    public void removeSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject is null");
        }
        subjectsWithStudents.remove(subject);
        for (Map<Subject, Integer> studentSubjects : studentsWithGrades.values()) {
            studentSubjects.remove(subject);
        }
    }

    public void printAllSubjects() {
        if (subjectsWithStudents.isEmpty()) {
            System.out.println("There are no subjects in the university database");
        }

        for (Map.Entry<Subject, Set<Student>> subjectEntry : subjectsWithStudents.entrySet()) {
            System.out.println(subjectEntry.getKey());
            System.out.println("Students:");
            for (Student student : subjectEntry.getValue()) {
                System.out.println(student);
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }
}
