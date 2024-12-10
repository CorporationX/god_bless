package school.faang.double_cache;

import java.util.*;

public class StudentDatabase {
    private final HashMap<Student, Map<Subject, Integer>> studentsSubjectsAndGrades = new HashMap<>();
    private final HashMap<Subject, List<Student>> subjects = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> grades) {
        studentsSubjectsAndGrades.put(student, grades);
        grades.forEach((subject, grade) -> {
            subjects.computeIfAbsent(subject, k -> {
                List<Student> newStudentList = new ArrayList<>();
                newStudentList.add(student);
                return newStudentList;
            });
        });
        System.out.println("New student " + student.name() + " was added");
    }

    public void addSubject(Subject subject, List<Student> students) {
        if (subjects.containsKey(subject)) {
            System.out.println("Subject already exists");
            return;
        }
        subjects.put(subject, students);

        for (Student student : students) {
            Map<Subject, Integer> studentSubjects = studentsSubjectsAndGrades.get(student);
            studentSubjects.put(subject, null);
            studentsSubjectsAndGrades.put(student, studentSubjects);
        }
        System.out.println("New subject " + subject.name() + " was added");
    }

    public void addSubjectToStudent(Student student, Subject subject, int grade) {
        if (!studentsSubjectsAndGrades.containsKey(student)) {
            System.out.println("User not found");
            return;
        }
        subjects.computeIfAbsent(subject, k -> {
            List<Student> newStudentList = new ArrayList<>();
            newStudentList.add(student);
            return newStudentList;
        });

        Map<Subject, Integer> studentSubjects = studentsSubjectsAndGrades.get(student);
        studentSubjects.put(subject, grade);
        studentsSubjectsAndGrades.put(student, studentSubjects);

        System.out.println("New subject " + subject.name() + " was added to " + student.name());
    }

    public void addStudentToSubject(Student student, Subject subject, int grade) {
        if (subjects.get(subject).contains(student)) {
            System.out.println("Student already exists");
            return;
        }
        studentsSubjectsAndGrades.computeIfAbsent(student, s -> {
            HashMap<Subject, Integer> studentSubjects = new HashMap<>();
            studentSubjects.put(subject, grade);
            return studentSubjects;
        });
        List<Student> subjectStudents = subjects.get(subject);
        subjectStudents.add(student);
        subjects.put(subject, subjectStudents);
        System.out.println("Student " + student.name() + " was added to " + subject.name());
    }

    public void removeStudent(Student student) {
        List<Subject> subjectsToRemove
                = new ArrayList<>(studentsSubjectsAndGrades.get(student).keySet());
        studentsSubjectsAndGrades.remove(student);
        for (Subject subject : subjectsToRemove) {
            List<Student> subjectStudents = subjects.get(subject);
            subjectStudents.remove(student);
            subjects.put(subject, subjectStudents);
        }
        System.out.println("Student " + student.name() + " was removed");
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (!subjects.containsKey(subject)) {
            System.out.println("Subject not found");
            return;
        }
        if (!subjects.get(subject).contains(student)) {
            System.out.println("Student not found");
            return;
        }
        List<Student> subjectStudents = subjects.get(subject);
        subjectStudents.remove(student);
        subjects.put(subject, subjectStudents);

        studentsSubjectsAndGrades.get(student).remove(subject);
        System.out.println("Student " + student.name() + " was removed from " + subject.name());
    }

    public void printAllStudentsWithGrades() {
        if (studentsSubjectsAndGrades.size() == 0) {
            System.out.println("Students not found");
            System.out.println();
            return;
        }
        studentsSubjectsAndGrades.forEach((student, subjectsAndGrades) -> {
            System.out.println();
            System.out.println("Student (" + student.id() + ") " + student.name());
            subjectsAndGrades.forEach((subject, grade) -> {
                System.out.println(subject.name() + " " + grade);
            });
        });
    }

    public void printAllSubjectsWithStudents() {
        subjects.forEach((subject, students) -> {
            System.out.println("Subject " + subject.id() + " " + subject.name());
            students.forEach(student -> {
                System.out.println(student.name());
            });
            System.out.println();
        });
    }
}