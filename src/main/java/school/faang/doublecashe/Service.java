package school.faang.doublecashe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Service {
    public static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECT_GRADE = new HashMap<>();
    public static final Map<Subject, List<Student>> SUBJECT_STUDENTS = new HashMap<>();

    public void addStudent(Student student) {
        if (!STUDENT_SUBJECT_GRADE.containsKey(student)) {
            STUDENT_SUBJECT_GRADE.put(student, new HashMap<>());
        }
    }

    /**
     * добавление нового студента и его предметов с оценками
     */
    public void addNewStudent(Student student, Subject subject, int grade) {
        addStudent(student);
        STUDENT_SUBJECT_GRADE.get(student).put(subject, grade);
        SUBJECT_STUDENTS.putIfAbsent(subject, new ArrayList<>());
        if (!SUBJECT_STUDENTS.get(subject).contains(student)) {
            SUBJECT_STUDENTS.get(subject).add(student);
        }
    }

    /**
     * добавление нового предмета для существующего студента с оценкой
     */

    public void addNewSubject(Student student, Subject subject, Integer grade) {
        STUDENT_SUBJECT_GRADE.get(student).put(subject, grade);
        SUBJECT_STUDENTS.putIfAbsent(subject, new ArrayList<>());
        if (!SUBJECT_STUDENTS.get(subject).contains(student)) {
            SUBJECT_STUDENTS.get(subject).add(student);
        }
    }

    /**
     * удаление студента и его предметов с оценками
     */
    public void removeStudent(Student student) {
        List<Subject> studentSubjects = (List<Subject>) STUDENT_SUBJECT_GRADE.get(student);
        if (studentSubjects != null) {
            STUDENT_SUBJECT_GRADE.remove(student);
        }
        for (Subject subject : studentSubjects) {
            Set<Student> studentsInSubject = (Set<Student>) SUBJECT_STUDENTS.get(subject);
            if (studentsInSubject != null) {
                studentsInSubject.remove(student);
            }
        }
    }

    /**
     * вывод списка всех студентов и их оценок по предметам.
     */
    public void printAllStudent() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENT_SUBJECT_GRADE.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> grades = entry.getValue();
            System.out.println(student + " -> " + grades);
        }
    }

    /**
     * добавление нового предмета и списка студентов, изучающих его
     */
    public void addNewSubject(Subject subject, List<Student> students) {
        SUBJECT_STUDENTS.putIfAbsent(subject, students);
    }

    /**
     * добавление студента к существующему предмету
     */
    public void addStudentToSubject(Student student, Subject subjects) {
        SUBJECT_STUDENTS.putIfAbsent(subjects, new ArrayList<>());
        if (!SUBJECT_STUDENTS.get(subjects).contains(student)) {
            SUBJECT_STUDENTS.get(subjects).add(student);
        }
    }

    /**
     * удаление студента из предмета
     */

    public void removeStudentsIsSubject(Student student, Subject subject) {
        List<Student> students = SUBJECT_STUDENTS.get(subject);
        if (students != null) {
            students.remove(student);
        }
    }

    /**
     * вывод списка всех предметов и студентов, изучающих их.
     */

    public void printListSubjectAndStudent() {
        for (Map.Entry<Subject, List<Student>> entry : SUBJECT_STUDENTS.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();
            System.out.println(subject + " ->" + students);
        }
    }
}
