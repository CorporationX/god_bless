package school.faang.task_45221;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Subject subject = studentDatabase.getStudentSubjects().keySet().stream().filter(subj -> "English"
                .equals(subj.getName())).findAny().orElse(null);
        Student student = studentDatabase.getStudentsGrades().keySet().stream().filter(stud -> "Ivanov Artem"
                        .equals(stud.getName()))
                .findAny().orElse(null);
        studentDatabase.removeStudentFromSubject(student, subject);
    }

    private static void addStudentToSubject(StudentDatabase studentDatabase) {
        Subject subject = studentDatabase.getStudentSubjects().keySet().stream().filter(subj -> "Chemistry"
                .equals(subj.getName())).findAny().orElse(null);
        Student student = (Student) Arrays.stream(Arrays.stream(studentDatabase.getStudentsGrades().keySet().toArray())
                .toArray()).findAny().orElse(null);
        studentDatabase.addStudentToSubject(student, subject);
    }

    private static void addNewSubjects(StudentDatabase studentDatabase) {
        studentDatabase.addSubjectWithStudents(new Subject("Logic"), studentDatabase.getStudentsGrades()
                .keySet().stream().toList());
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
        List<Subject> subjects = addSubjects();

        studentDatabase.addStudentWithGrades(new Student("Ivanov Artem"), addGradesToSybjects(subjects));
        studentDatabase.addStudentWithGrades(new Student("Petrov Sergey"), addGradesToSybjects(subjects));
        studentDatabase.addStudentWithGrades(new Student("Chebotnilova Sveta"), addGradesToSybjects(subjects));
        studentDatabase.addStudentWithGrades(new Student("Rubanova Olesya"), addGradesToSybjects(subjects));
    }

    private static Map<Subject, Integer> addGradesToSybjects(List<Subject> subjects) {
        HashMap<Subject, Integer> grades = new HashMap<>();
        for (Subject subject : subjects) {
            grades.put(subject, getGrade());
        }
        return grades;
    }

    private static List<Subject> addSubjects() {
        List<Subject> subjects = new ArrayList<>();

        subjects.add(new Subject("Math"));
        subjects.add(new Subject("English"));
        subjects.add(new Subject("Russian Language"));

        return subjects;
    }

    private static Integer getGrade() {
        Random random = new Random();
        int minGrade = 3;
        int maxGrade = 5;

        return random.nextInt(maxGrade - minGrade) + minGrade;
    }
}