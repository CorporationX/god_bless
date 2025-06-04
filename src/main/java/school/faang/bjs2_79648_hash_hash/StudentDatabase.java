package school.faang.bjs2_79648_hash_hash;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private static final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private static final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void addStudentWithSubjects(Student student, Map<Subject, Integer> subjectsWithGrades) {
        if (student == null || subjectsWithGrades == null) {
            throw new IllegalArgumentException("Student or subjects cannot be null");
        }

        subjectsWithGrades.forEach((subject, grade) -> addToStudentAndSubjectRegistries(student, subject, grade));
    }

    public static void addToStudentAndSubjectRegistries(Student student, Subject subject, Integer grade) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Student or subject cannot be null");
        }
        addStudentSubject(student, subject, grade);
        addSubjectStudent(subject, student);
    }

    private static void addStudentSubject(Student student, Subject subject, Integer grade) {
        if (student == null || subject == null) {
            throw new IllegalArgumentException("Student or subject cannot be null");
        }
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        addSubjectStudent(subject, student);
    }

    public static void removeStudent(Student student) {
        List<Subject> currentSubjects = new ArrayList<>(studentSubjects.get(student).keySet());
        currentSubjects.forEach(subject -> subjectStudents.get(subject).remove(student));
        studentSubjects.remove(student);
    }

    public static void printStudentsWithSubjects() {
        System.out.println("\n- StudentRegistry: -");
        studentSubjects.forEach((student, subjects) -> {
            System.out.println(student);
            subjects.forEach((subject, grade) -> System.out.println(subject + " grade " + grade));
        });
    }

    public static void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject == null || students == null) {
            throw new IllegalArgumentException("Student or subjects cannot be null");
        }

        students.forEach(student -> addToStudentAndSubjectRegistries(student, subject, null));

    }

    private static void addSubjectStudent(Subject subject, Student student) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Student or subject cannot be null");
        }
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("Student or subject cannot be null");
        }

        if (studentSubjects.get(student) != null) {
            studentSubjects.get(student).remove(subject);
        }
        if (subjectStudents.get(subject) != null) {
            subjectStudents.get(subject).remove(student);
        }
    }

    public static void printSubjectsWithStudents() {
        System.out.println("\n- SubjectRegistry: -");
        subjectStudents.forEach((subject, students) -> {
            System.out.println(subject);
            students.forEach(student -> System.out.println("Student " + student));
        });
    }
}

//Добавление нового предмета и списка студентов, изучающих его. V
//
//Добавление студента к существующему предмету. V
//
//Удаление студента из предмета. V
//
//Вывод списка всех предметов и студентов, изучающих их. V


//Добавление нового студента и его предметов с оценками. V
//
//Добавление нового предмета для существующего студента с оценкой. V
//
//Удаление студента и его предметов. V
//
//Вывод списка всех студентов и их оценок по предметам. V