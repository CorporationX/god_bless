package school.faang.bjs2_80042;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private static final int MAX_SCORE = 100;
    private static final int BASE_SCORE = 0;
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public boolean addStudentInfo(Student student, Map<Subject, Integer> subjectScore) {
        if (student == null || subjectScore.isEmpty() || studentSubjects.containsKey(student)) {
            return false;
        }

        for (int score : subjectScore.values()) {
            if (score < BASE_SCORE || score > MAX_SCORE) {
                return false;
            }
        }

        studentSubjects.put(student, new HashMap<>(subjectScore));

        for (Subject subject : subjectScore.keySet()) {
            if (!subjectStudents.containsKey(subject)) {
                subjectStudents.put(subject, new ArrayList<>());
            }
            subjectStudents.get(subject).add(student);
        }
        return true;
    }

    public boolean addSubjectForStudent(Student student, Subject subject, int integer) {
        if (student == null || subject == null || integer < BASE_SCORE
                || integer > MAX_SCORE || !studentSubjects.containsKey(student)) {
            return false;
        }

        studentSubjects.get(student).put(subject, integer);

        if (!subjectStudents.containsKey(subject)) {
            subjectStudents.put(subject, new ArrayList<>());
        }

        List<Student> studentsForSubject = subjectStudents.get(subject);
        if (!studentsForSubject.contains(student)) {
            studentsForSubject.add(student);
        }
        return true;
    }

    public boolean removeStudentInfo(Student student) {
        if (student == null || !studentSubjects.containsKey(student)) {
            return false;
        }

        Map<Subject, Integer> subjects = studentSubjects.get(student);
        studentSubjects.remove(student);

        for (Subject subject : subjects.keySet()) {
            subjectStudents.get(subject).remove(student);
            List<Student> students = subjectStudents.get(subject);
            if (students != null) {
                students.remove(student);

                if (students.isEmpty()) {
                    subjectStudents.remove(subject);
                }
            }
        }
        return true;
    }

    public void displayAllStudents() {
        for (Student student : studentSubjects.keySet()) {
            System.out.println(student.toString().replaceAll("Student\\(name=|\\).*", "") + ":");
            for (Subject subject : studentSubjects.get(student).keySet()) {
                System.out.println(subject.toString().replaceAll("Subject\\(name=|\\).*", "") +
                        " " + studentSubjects.get(student).get(subject));
            }
        }
    }

    public boolean addStudentListSubject(Subject subject, List<Student> students) {
        if (subject == null || students == null) {
            return false;
        }

        if (subjectStudents.containsKey(subject)) {
            return false;
        }

        subjectStudents.put(subject, new ArrayList<>());
        for (Student student : students) {
            if (student == null) {
                continue;
            }
            if (!studentSubjects.containsKey(student)) {
                studentSubjects.put(student, new HashMap<>());
            }

            studentSubjects.get(student).put(subject, BASE_SCORE);
            subjectStudents.get(subject).add(student);
        }
        return true;
    }

    public boolean addStudentToSubject(Student student, Subject subject) {
        if (student == null || !subjectStudents.containsKey(subject)) {
            return false;
        }

        if (subjectStudents.get(subject).contains(student)) {
            return false;
        }

        subjectStudents.get(subject).add(student);
        if (!studentSubjects.containsKey(student)) {
            return false;
        }
        studentSubjects.get(student).put(subject, BASE_SCORE);
        return true;
    }

    public boolean removeStudentIntoSubject(Student student, Subject subject) {
        if (student == null || subject == null) {
            return false;
        }
        if (!subjectStudents.containsKey(subject) || !subjectStudents.get(subject).contains(student)) {
            return false;
        }
        studentSubjects.get(student).remove(subject);
        subjectStudents.get(subject).remove(student);

        if (subjectStudents.get(subject).isEmpty()) {
            subjectStudents.remove(subject);
        }
        return true;
    }

    public void displayAllSubjects() {
        for (Subject subject : subjectStudents.keySet()) {
            System.out.println(subject.toString().replaceAll("Subject\\(name=|\\).*", "") + ":");
            for (Student student : subjectStudents.get(subject)) {
                System.out.println(student.toString().replaceAll("Student\\(name=|\\).*", ""));
            }
        }
    }
}