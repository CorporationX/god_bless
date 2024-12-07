package school.faang.task_45221;

import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();

        addStudentsAndGrades(studentDatabase);
        addSubjectForStudent(studentDatabase);
        removeStudent(studentDatabase);
        studentDatabase.printAllSubjectsWithStudents();

        addNewSubjects(studentDatabase);
        addStudentToSubject(studentDatabase);
        removeStudentFromSubject(studentDatabase);
        studentDatabase.printAllStudentsSubjets();
    }

    private static void removeStudentFromSubject(StudentDatabase studentDatabase) {
        Subject subject = studentDatabase.getSubjects().stream().filter(subj -> "English".equals(subj.getName()))
                .findAny().orElse(null);
        Student student = studentDatabase.getStudents().stream().filter(stud -> "Ivanov Artem".equals(stud.getName()))
                .findAny().orElse(null);
        studentDatabase.removeStudentFromSubject(student, subject);
    }

    private static void addStudentToSubject(StudentDatabase studentDatabase) {
        Subject subject = studentDatabase.getSubjects().stream().filter(subj -> "Chemistry".equals(subj.getName()))
                .findAny().orElse(null);
        studentDatabase.addStudentToSubject(studentDatabase.getStudents().get(0), subject);
    }

    private static void addNewSubjects(StudentDatabase studentDatabase) {
        studentDatabase.addSubjectWithStudents(new Subject("Logic"), studentDatabase.getStudents());
    }

    private static void removeStudent(StudentDatabase studentDatabase) {
        Student student = (Student) studentDatabase.getStudentsGrades().keySet().toArray()[0];
        studentDatabase.removeStudent(student);
    }

    private static void addSubjectForStudent(StudentDatabase studentDatabase) {
        Student student = (Student) studentDatabase.getStudentsGrades().keySet().toArray()[0];
        studentDatabase.addSubjectForStudent(student, new Subject("Chemistry"), getGrade());
    }

    private static void addStudentsAndGrades(StudentDatabase studentDatabase) {
        studentDatabase.addStudentWithGrades(new Student("Ivanov Artem"), addSubjectsAndGrades(studentDatabase));
        studentDatabase.addStudentWithGrades(new Student("Petrov Sergey"), addSubjectsAndGrades(studentDatabase));
        studentDatabase.addStudentWithGrades(new Student("Chebotnilova Sveta"), addSubjectsAndGrades(studentDatabase));
        studentDatabase.addStudentWithGrades(new Student("Rubanova Olesya"), addSubjectsAndGrades(studentDatabase));
    }

    private static HashMap<Subject, Integer> addSubjectsAndGrades(StudentDatabase studentDatabase) {
        HashMap<Subject, Integer> grades = new HashMap<>();
        for (Subject subject : studentDatabase.getSubjects()) {
            grades.put(subject, getGrade());
        }
        return grades;
    }

    private static Integer getGrade() {
        Random random = new Random();
        int minGrade = 1;
        int maxGrade = 5;

        return random.nextInt(maxGrade - minGrade) + minGrade;
    }

}