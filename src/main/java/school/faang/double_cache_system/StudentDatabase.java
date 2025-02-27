package school.faang.double_cache_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class StudentDatabase {
    public static final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    public static final Map<Subject, List<Student>> subjectsStudents = new HashMap<>();
    private static final int NO_MARKS_YET_CASE = 0;

    public static void addNewStudentWithHisSubjectsWithMarks(Student student, Map<Subject, Integer> subjectsWithMarks) {
        studentSubjects.computeIfAbsent(student, key -> new HashMap<Subject, Integer>()).putAll(subjectsWithMarks);
        for (Map.Entry<Subject, Integer> entry : subjectsWithMarks.entrySet()) {
            subjectsStudents.computeIfAbsent(entry.getKey(), key -> new ArrayList<Student>()).add(student);
        }
    }

    public static void addNewSubjectToTheExistingStudent(Student student, Subject subject) {
        studentSubjects.computeIfAbsent(student, key -> new HashMap<>()).put(subject, NO_MARKS_YET_CASE);
        subjectsStudents.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
    }

    public static void removeStudentWithHisSubjects(Student student) {
        Map<Subject, Integer> studentsSubjectsWithMarks = studentSubjects.remove(student);
        if (studentsSubjectsWithMarks == null) {
            return;
        }
        for (Subject subject : studentsSubjectsWithMarks.keySet()) {
            List<Student> students = subjectsStudents.get(subject);
            if (students != null) {
                students.remove(student);
                if (students.isEmpty()) {
                    subjectsStudents.remove(subject);
                }
            }
        }
    }

    public static void printAllStudentsAndTheirMarksBySubject() {
        if (studentSubjects.isEmpty() || subjectsStudents.isEmpty()) {
            System.out.println("Holidays!");
            return;
        }
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<Subject, Integer> subjectIntegerEntry : entry.getValue().entrySet()) {
                System.out.println(subjectIntegerEntry.getKey() + ", Mark: " + subjectIntegerEntry.getValue());
            }
        }
    }

    public static void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectsStudents.put(subject, students);
        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, key -> new HashMap<Subject, Integer>())
                    .put(subject, NO_MARKS_YET_CASE);
        }
    }

    public static void addStudentToTheExistingSubject(Student student, Subject subject) {
        List<Student> studentList = subjectsStudents.get(subject);
        if (!studentList.contains(student)) {
            studentList.add(student);
        }
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectsStudents.get(subject);
        if (students != null) {
            students.remove(student);
            if (students.isEmpty()) {
                subjectsStudents.remove(subject);
            }
        }

        Map<Subject, Integer> subjects = studentSubjects.get(student);
        if (subjects != null) {
            subjects.remove(subject);
            if (subjects.isEmpty()) {
                studentSubjects.remove(student);
            }
        }
    }

    public static void printAllSubjectsWithItsStudents() {
        if (subjectsStudents.isEmpty()) {
            System.out.println("No subjects in the database.");
            return;
        }

        for (Map.Entry<Subject, List<Student>> entry : subjectsStudents.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
