package school.faang.bjs2_79699;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {

    Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjectsWithGrades) {
        if (!studentSubjects.containsKey(student)) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
        }
        for (Map.Entry<Subject, Integer> entry : subjectsWithGrades.entrySet()) {
            Subject subject = entry.getKey();
            Integer grade = entry.getValue();

            studentSubjects.get(student).putIfAbsent(subject, grade);

            subjectStudents.putIfAbsent(subject, new ArrayList<>());

            if (!subjectStudents.get(subject).contains(student)) {
                subjectStudents.get(subject).add(student);
            }
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Student not found in the database: " + student);
        }

        studentSubjects.get(student).put(subject, grade);

        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        List<Student> students = subjectStudents.get(subject);
        if (!students.contains(student)) {
            students.add(student);
        }
    }


    public void removeStudent(Student student) {
        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects != null) {
            for (Subject subject : subjects.keySet()) {
                List<Student> studentsList = subjectStudents.get(subject);
                if (studentsList != null) {
                    studentsList.remove(student);
                    if (studentsList.isEmpty()) {
                        subjectStudents.remove(subject);
                    }
                }
            }
        }
        studentSubjects.remove(student);
    }

    public void printAllStudentsAndGrades() {
        if (studentSubjects.isEmpty()) {
            System.out.println("There are no students in the database yet.");
            return;
        }

        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> subjects = entry.getValue();

            System.out.println("Student: " + student.getName());
            for (Map.Entry<Subject, Integer> subjectEntry : subjects.entrySet()) {
                System.out.println("  Subject: " + subjectEntry.getKey().getName() +
                        ", Evaluation: " + subjectEntry.getValue());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());

        for (Student student : students) {
            if (!studentSubjects.containsKey(student)) {
                throw new IllegalArgumentException("Student not found: " + student.getName());
            }

            studentSubjects.get(student).putIfAbsent(subject, 0);

            List<Student> studentList = subjectStudents.get(subject);
            if (!studentList.contains(student)) {
                studentList.add(student);
            }
        }
    }

    public void addStudentToSubject(Subject subject, Student student) {
        if (!studentSubjects.containsKey(student)) {
            throw new IllegalArgumentException("Student not found: " + student.getName());
        }

        studentSubjects.get(student).putIfAbsent(subject, 0);

        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        List<Student> students = subjectStudents.get(subject);
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects != null) {
            subjects.remove(subject);
        }

        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }
    }

    public void printAllSubjectsAndStudents() {
        if (subjectStudents.isEmpty()) {
            System.out.println("There are no items in the database yet.");
            return;
        }

        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();

            System.out.println("Subject: " + subject.getName());
            for (Student student : students) {
                System.out.println("  Student: " + student.getName());
            }
        }
    }
}
