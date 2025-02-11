package school.faang.sprint1.task_56984;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentSubjects.remove(student);
        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
    }

    public void printAllStudentsWithGrades() {
        for (var entry : studentSubjects.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> grades = entry.getValue();

            System.out.println("Student: " + student.getName());
            for (var gradeEntry : grades.entrySet()) {
                Subject subject = gradeEntry.getKey();
                Integer grade = gradeEntry.getValue();
                System.out.println("\tSubject: " + subject.getName() + ", Grade: " + grade);
            }
            System.out.println();
        }
    }

    public void printAllSubjectsWithStudents() {
        for (var entry : subjectStudents.entrySet()) {
            System.out.println("Subject: " + entry.getKey().getName());
            for (Student student : entry.getValue()) {
                System.out.println("\tStudent: " + student.getName());
            }
            System.out.println();
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student); // Добавляем студента к предмету
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null); // Добавляем предмет в записи студента
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student); // Удаляем студента из списка предмета
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject); // Удаляем предмет из записей студента
        }
    }

    public Integer getGradeForStudentInSubject(Student student, Subject subject) {
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            return grades.get(subject);
        } else {
            return null;
        }
    }

    public Map<Student, Map<Subject, Integer>> getStudentSubjects() {
        return studentSubjects;
    }

    public Map<Subject, List<Student>> getSubjectStudents() {
        return subjectStudents;
    }
}
