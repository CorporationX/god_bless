package faang.school.godbless.BJS2_19890;

import lombok.Getter;

import java.util.*;

public class Application {
    @Getter
    private static Map<Student, Map<Subject, Integer>> studentsEvaluates = new HashMap<>();
    @Getter
    private static Map<Subject, List<Student>> subjectsAndStudents = new HashMap<>();

    public static void main(String[] args) {
    }

    public static void addStudent(Student student, Subject subject, int grade,
                                  Map<Student, Map<Subject, Integer>> studentsEvaluates) {

        var studentsSubjectAndGrade = new HashMap<>(Map.of(subject, grade));
        studentsEvaluates.put(student, studentsSubjectAndGrade);
    }

    public static void addSubjectAndGradeForStudent(Student student, Subject subject, int grade,
                                                    Map<Student, Map<Subject, Integer>> studentsEvaluates,
                                                    Map<Subject, List<Student>> subjectsAndStudents) {

        if (!studentsEvaluates.containsKey(student)) {
            addStudent(student, subject, grade, studentsEvaluates);
        }
        var studentsSubjectsAndGrades = studentsEvaluates.get(student);
        studentsSubjectsAndGrades.put(subject, grade);
        subjectsAndStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);

    }

    public static void deleteStudentAndHisGrades(Student student,
                                                 Map<Student, Map<Subject, Integer>> studentsEvaluates,
                                                 Map<Subject, List<Student>> subjectsAndStudents) {
        if (studentsEvaluates.containsKey(student)) {
            studentsEvaluates.remove(student);

            for (Map.Entry<Subject, List<Student>> subjectListEntry : subjectsAndStudents.entrySet()) {
                subjectListEntry.getValue().removeIf(deletedStudent -> deletedStudent.equals(student));
            }
        }
    }

    public static void deleteStudentFromSubject(Subject subject, Student deletingStudent,
                                                Map<Subject, List<Student>> subjectsAndStudents) {

        if (subjectsAndStudents.containsKey(subject)) {
            subjectsAndStudents.get(subject).remove(deletingStudent);
        }

    }

    public static void printStudentsTheirAndSubjects(Map<Student, Map<Subject, Integer>> studentsEvaluates) {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsEvaluates.entrySet()) {
            System.out.println("Subjects of student: " + entry.getKey().getName());
            entry.getValue().forEach((subject, grade) ->
                    System.out.println(subject.getName() + ": " + grade));
        }
    }

    public static void printSubjectsAndStudents(Map<Subject, List<Student>> subjectsAndStudents) {
        for (Map.Entry<Subject, List<Student>> entry : subjectsAndStudents.entrySet()) {
            System.out.println("Subject " + entry.getKey().getName() + " has next students:");
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }
}