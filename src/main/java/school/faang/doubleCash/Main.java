package school.faang.doubleCash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> studentsGrades = new HashMap<>();
    private static final Map<Subject, List<Student>> learntSubjects = new HashMap<>();

    public static void main(String[] args) {
        Student ilya = new Student(13248, "Ilya Vyalov");
        Student sasha = new Student(48123, "Alexandr Tolstopyatenko");
        Subject algebra = new Subject(1, "Linear algebra");
        Subject diff = new Subject(2, "Differential equations");
        Subject philosophy = new Subject(3, "Philosophy");
        Map<Subject, Integer> ilyaGrades = new HashMap<>();
        ilyaGrades.put(algebra, 3);
        ilyaGrades.put(diff, 4);
        Map<Subject, Integer> sashaGrades = new HashMap<>();
        sashaGrades.put(algebra, 5);
        Map<Student, Integer> grades = new HashMap<>();
        grades.put(ilya, 5);
        grades.put(sasha, 3);

        addStudentAndGrades(ilya, ilyaGrades);
        addStudentAndGrades(sasha, sashaGrades);
        addSubjectAndGrade(sasha, diff, 4);
        removeStudent(sasha);
        addSubjectAndStudents(philosophy, grades);
        addStudentToExistingSubject(diff, sasha, 4);
        removeStudentFromSubject(sasha, philosophy);
        removeStudentFromSubject(sasha, diff);
        printStudents();
        printSubjects();
    }

    private static void addStudentAndGrades(Student student, Map<Subject, Integer> gradeMap) {
        studentsGrades.put(student, gradeMap);
        for (var entry : gradeMap.entrySet()) {
            learntSubjects.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(student);
        }
    }

    private static void addSubjectAndGrade(Student student, Subject subject, int grade) {
        Map<Subject, Integer> grades = studentsGrades.get(student);
        grades.put(subject, grade);
    }

    private static void removeStudent(Student student) {
        List<Subject> subjectsToRemove = new ArrayList<>();
        studentsGrades.remove(student);
        for (var entry : learntSubjects.entrySet()) {
            entry.getValue().remove(student);
            if (entry.getValue().isEmpty()) {
                subjectsToRemove.add(entry.getKey());
            }
        }
        for (Subject subject : subjectsToRemove) {
            learntSubjects.remove(subject);
        }
    }

    private static void addSubjectAndStudents(Subject subject, Map<Student, Integer> grades) {
        for (var entry : grades.entrySet()) {
            Student currentStudent = entry.getKey();
            int currentGrade = entry.getValue();

            learntSubjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(currentStudent);
            studentsGrades.computeIfAbsent(currentStudent, k -> new HashMap<>()).put(subject, currentGrade);
        }
    }

    private static void addStudentToExistingSubject(Subject subject, Student student, int grade) {
        learntSubjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentsGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }

    private static void removeStudentFromSubject(Student studentToRemove, Subject subject) {
        List<Subject> subjectsToRemove = new ArrayList<>();
        List<Student> studentsToRemove = new ArrayList<>();
        for (var entry : learntSubjects.entrySet()) {
            List<Student> students = entry.getValue();
            students.removeIf(student -> (student.equals(studentToRemove) && entry.getKey().equals(subject)));
            for (var studentsEntry : studentsGrades.entrySet()) {
                Map<Subject, Integer> gradesForSubject = studentsEntry.getValue();
                for (var subjectsEntry : gradesForSubject.entrySet()) {
                    if (subjectsEntry.getKey().equals(subject)
                            && studentsEntry.getKey().equals(studentToRemove)) {
                        subjectsToRemove.add(subjectsEntry.getKey());
                    }
                }
                for (Subject subjectToRemove : subjectsToRemove) {
                    gradesForSubject.remove(subjectToRemove);
                }
                if (studentsEntry.getValue().isEmpty()) {
                    studentsToRemove.add(studentsEntry.getKey());
                }
            }
        }
        for (Student student : studentsToRemove) {
            studentsGrades.remove(student);
        }
    }

    private static void printStudents() {
        for (var entry : studentsGrades.entrySet()) {
            System.out.println("Grades for student: " + entry.getKey().getName());
            for (var grades : entry.getValue().entrySet()) {
                System.out.println(grades.getKey().getName() + ": " + grades.getValue());
            }
        }
    }

    private static void printSubjects() {
        System.out.println("---------------");
        for (var entry : learntSubjects.entrySet()) {
            System.out.println("Students who learn subject: " + entry.getKey().getName());
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }
}
