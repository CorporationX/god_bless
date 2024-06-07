package faang.school.godbless.doubleCacheCache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Student, Map<Subject, Integer>> studentsSubjectsAndGrades = new HashMap<>();
    static Map<Subject, List<Student>> studentsStudyingSubjects = new HashMap<>();

    public static void main(String[] args) {

    }

    private void addNewStudentSubjectsAndGrades(Student newStudent,
                                                Map<Subject, Integer> subjects) {
        studentsSubjectsAndGrades.put(newStudent, subjects);
    }

    private void addNewSubjectAndGradeForExistingStudent(Student student,
                                                         Subject newSubject, int grade) {
        studentsSubjectsAndGrades.get(student).put(newSubject, grade);
    }

    private void removeStudentSubjectsAndGrades(Student student) {
        studentsSubjectsAndGrades.remove(student);
    }

    private void displayInfoAboutAllStudentsSubjectsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsSubjectsAndGrades.entrySet()) {
            System.out.println("Имя студента: " + entry.getKey() + ", его предметы с оценками: "
                    + entry.getValue());
        }
    }

    private void addNewSubjectAndStudents(Subject newSubject, List<Student> students) {
        studentsStudyingSubjects.put(newSubject, students);
    }

    private void addNewStudentToSubject(Student newStudent, Subject subject) {
        studentsStudyingSubjects.get(subject).add(newStudent);
    }

    private void removeStudentInSubject(Student student, Subject subject) {
        studentsStudyingSubjects.get(subject).remove(student);
    }

    private void displayInfoAboutAllSubjectsAndStudent() {
        for (Map.Entry<Subject, List<Student>> entry : studentsStudyingSubjects.entrySet()) {
            System.out.println("Название предмета: " + entry.getKey() + ", студенты, изучающие этот предмет: "
                    + entry.getValue());
        }
    }
}