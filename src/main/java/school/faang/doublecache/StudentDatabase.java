package school.faang.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    protected static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECTS = new HashMap<>();
    protected static final Map<Subject, List<Student>> SUBJECT_STUDENTS = new HashMap<>();

    protected static void addStudent(Student student, Map<Subject, Integer> studentSubjects) {
        STUDENT_SUBJECTS.put(student, studentSubjects);
        for (var entry : studentSubjects.entrySet()) {
            SUBJECT_STUDENTS.computeIfAbsent(entry.getKey(), studentToAdd -> new ArrayList<>()).add(student);
        }
    }

    protected static void addSubject(Subject subject, Integer grade, Student student) {
        STUDENT_SUBJECTS.computeIfAbsent(student, studentSubject -> new HashMap<>()).put(subject, grade);
        SUBJECT_STUDENTS.computeIfAbsent(subject, students -> new ArrayList<>()).add(student);
    }

    protected static void deleteStudent(Student student) {
        Map<Subject, Integer> studentSubjects = STUDENT_SUBJECTS.get(student);

        if (studentSubjects != null) {
            for (var entry : studentSubjects.entrySet()) {
                SUBJECT_STUDENTS.computeIfPresent(entry.getKey(), (subject, students) -> {
                    students.remove(student);
                    return students.isEmpty() ? null : students;
                });
            }
        }
        STUDENT_SUBJECTS.remove(student);
    }

    protected void getStudentsWithGrades() {
        for (var entry : STUDENT_SUBJECTS.entrySet()) {
            System.out.println(entry.getKey() + ":");
            Map<Subject, Integer> subjects = entry.getValue();
            if (subjects != null) {
                for (var entrySubject : subjects.entrySet()) {
                    System.out.println(entrySubject.getKey() + " : " + entrySubject.getValue());
                }
            }
        }
    }

    protected static void addSubjectStudents(Subject subject, List<Student> students) {
        SUBJECT_STUDENTS.put(subject, students);
        for (Student student : students) {
            STUDENT_SUBJECTS.computeIfAbsent(student, subjectToAdd -> new HashMap<>()).put(subject, null);
        }
    }

    protected static void addStudentToSubject(Student student, Subject subject) {
        STUDENT_SUBJECTS.computeIfAbsent(student, subjectToAdd -> new HashMap<>()).put(subject, null);
        SUBJECT_STUDENTS.computeIfAbsent(subject, students -> new ArrayList<>()).add(student);
    }

    protected static void deleteStudentFromSubject(Student student, Subject subject) {
        SUBJECT_STUDENTS.computeIfPresent(subject, (studentsSubject, students) -> {
            students.remove(student);
            return students.isEmpty() ? null : students;
        });
        STUDENT_SUBJECTS.computeIfPresent(student, (deletedStudent, subjects) -> {
            subjects.remove(subject);
            return subjects.isEmpty() ? null : subjects;
        });

    }

    protected static void getSubjectStudents() {
        for (var entry : SUBJECT_STUDENTS.entrySet()) {
            System.out.println(entry.getKey() + ":");
            if (entry.getValue() != null) {
                for (Student student : entry.getValue()) {
                    System.out.print(student + " ");
                }
            }
        }
    }
}
