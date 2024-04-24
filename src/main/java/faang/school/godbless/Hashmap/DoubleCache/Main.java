package faang.school.godbless.Hashmap.DoubleCache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECT_GRADES = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        Main app = new Main();

        Student student1 = new Student(1, "Peeter");
        Student student2 = new Student(2, "Joana");
        Student student3 = new Student(3, "Jack");

        Subject subject1 = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "Physical_Activity");
        Subject subject3 = new Subject(3, "Biology");
        Subject subject4 = new Subject(4, "Geo");
        Subject subject5 = new Subject(5, "Art");

        List<Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(student1, student2, student3));

        app.addNewStudentForStudentGradesMap(student1, subject1, 5);
        app.addNewStudentForStudentGradesMap(student1, subject3, 2);
        app.addNewStudentForStudentGradesMap(student2, subject1, 4);
        app.addNewStudentForStudentGradesMap(student2, subject3, 3);
        app.addNewStudentForStudentGradesMap(student3, subject4, 5);
        app.addNewStudentForStudentGradesMap(student3, subject1, 5);
        app.addNewSubjectForStudent(student1, subject2, 5);
        app.getAllStudentGrades();

        app.deleteStudent(1);

        app.getAllStudentGrades();

        System.out.println();

        app.addNewSubjectForSubjectMap(subject1, students);

        app.addNewStudentForSubject(student1, subject3);
        app.addNewStudentForSubject(student1, subject2);
        app.addNewStudentForSubject(student2, subject1);
        app.addNewStudentForSubject(student2, subject5);
        app.addNewStudentForSubject(student3, subject4);
        app.addNewStudentForSubject(student3, subject2);

        app.deleteStudentFromSubject(1, subject1);
        app.deleteStudentFromSubject(1, subject2);
        app.deleteStudentFromSubject(1, subject3);

        app.getAllSubjectStudents();
    }

    private void addNewStudentForStudentGradesMap(Student student, Subject subject, int grades) {
        try {
            Map<Subject, Integer> gradesMap = STUDENT_SUBJECT_GRADES.getOrDefault(student, new HashMap<>());

            gradesMap.put(subject, grades);

            STUDENT_SUBJECT_GRADES.put(student, gradesMap);
        } catch (Exception e) {
            System.out.println("Error: null");
        }
    }

    private void addNewSubjectForStudent(Student student, Subject subject, Integer grades) {
        try {
            for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENT_SUBJECT_GRADES.entrySet()) {
                if (entry.equals(student)) {
                    Map<Subject, Integer> newSubject = entry.getValue();
                    newSubject.put(subject, grades);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: null");
        }
    }

    private void deleteStudent(int id) {
        try {
            Iterator<Map.Entry<Student, Map<Subject, Integer>>> iterator = STUDENT_SUBJECT_GRADES.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Student, Map<Subject, Integer>> entry = iterator.next();
                Student studentToDelete = entry.getKey();
                if (studentToDelete.getId() == id) {
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: null");
        }
    }

    private void getAllStudentGrades() {
        try {
            for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENT_SUBJECT_GRADES.entrySet()) {
                Student student = entry.getKey();
                Map<Subject, Integer> studentGrades = entry.getValue();

                for (Map.Entry<Subject, Integer> innerEntry : studentGrades.entrySet()) {
                    Subject subject = innerEntry.getKey();
                    System.out.println("Student: " + student.getName() + ", with ID: " + student.getId() +
                            ", studies subject: " + subject.getName() + " with ID: " + subject.getId() +
                            " and has grade: " + innerEntry.getValue());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: null");
        }
    }

    private void addNewSubjectForSubjectMap(Subject subject, List<Student> students) {
        try {
            SUBJECT_STUDENTS.put(subject, students);
        } catch (Exception e) {
            System.out.println("Error: null");
        }
    }

    private void addNewStudentForSubject(Student student, Subject subject) {
        try {
            SUBJECT_STUDENTS.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        } catch (Exception e) {
            System.out.println("Error: null");
        }
    }

    private void deleteStudentFromSubject(int studentId, Subject subject) {
        try {
            List<Student> students = SUBJECT_STUDENTS.get(subject);
            if (students != null) {
                students.removeIf(student -> student.getId() == studentId);
            }
        } catch (Exception e) {
            System.out.println("Error: null");
        }
    }

    private void getAllSubjectStudents() {
        try {
            for (Map.Entry<Subject, List<Student>> entry : SUBJECT_STUDENTS.entrySet()) {
                Subject subject = entry.getKey();
                System.out.println("Subject: " + subject.getId() + ". " + subject.getName() + ", learns: ");
                List<Student> studentSubjects = entry.getValue();
                for (Student innerEntry : studentSubjects) {
                    System.out.println("\tStudent: " + innerEntry.getId() + ". " + innerEntry.getName());
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error: null");
        }
    }
}
