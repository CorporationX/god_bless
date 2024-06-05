package faang.school.godbless.doubleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> STUDENTS = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECTS = new HashMap<>();

    public static void main(String[] args) {
        Subject math = new Subject("11bb", "math");
        Subject language = new Subject("11cc", "en language");
        Subject physics = new Subject("11dd", "physics");
        Subject literature = new Subject("11ee", "literature");

        createSubjectWithStudents(math, new ArrayList<>());
        createSubjectWithStudents(language, new ArrayList<>());
        createSubjectWithStudents(physics, new ArrayList<>());
        createSubjectWithStudents(literature, new ArrayList<>());

        Student firstStudent = new Student("44aa", "ivan");
        Map<Subject, Integer> firstStudentSubjectsWithMarks = new HashMap<>();
        firstStudentSubjectsWithMarks.put(math, 4);
        firstStudentSubjectsWithMarks.put(language, 4);
        firstStudentSubjectsWithMarks.put(physics, 4);

        Student secondStudent = new Student("33bb", "alex");
        Map<Subject, Integer> secondStudentSubjectsWithMarks = new HashMap<>();
        secondStudentSubjectsWithMarks.put(math, 4);
        secondStudentSubjectsWithMarks.put(language, 4);
        secondStudentSubjectsWithMarks.put(physics, 4);



        createStudentWithHisSubjects(firstStudent, firstStudentSubjectsWithMarks);
        addStudentToSubject(math, firstStudent);
        addStudentToSubject(language, firstStudent);
        addStudentToSubject(physics, firstStudent);

        createStudentWithHisSubjects(secondStudent, secondStudentSubjectsWithMarks);
        addStudentToSubject(math, secondStudent);
        addStudentToSubject(language, secondStudent);
        addStudentToSubject(physics, secondStudent);

        HashMap<Subject, Integer> literatureWithMark = new HashMap<>();
        literatureWithMark.put(literature, 5);
        addSubjectsToStudent(literatureWithMark, firstStudent);

        deleteStudentWithSubjects(firstStudent);
        deleteStudentFromSubject(math, firstStudent);
        deleteStudentFromSubject(language, firstStudent);
        deleteStudentFromSubject(physics, firstStudent);
        deleteStudentFromSubject(literature, firstStudent);
    }

    public static void createStudentWithHisSubjects(Student newStudent, Map<Subject, Integer> subjects) {
        subjects = filterSubject(subjects);

        if (!STUDENTS.containsKey(newStudent)) {
            STUDENTS.put(newStudent, subjects);
        }
    }

    public static void addSubjectsToStudent(Map<Subject, Integer> subject, Student student) {
        subject = filterSubject(subject);

        if (STUDENTS.get(student) != null) {
            STUDENTS.get(student).putAll(subject);
        }
    }

    public static void deleteStudentWithSubjects(Student student) {
        STUDENTS.remove(student);
    }

    public static Map<Student, Map<Subject, Integer>> getAllStudents() {
        return STUDENTS;
    }

    public static void createSubjectWithStudents(Subject subject, List<Student> students) {
        students = filterStudent(students);

        if (!SUBJECTS.containsKey(subject)) {
            SUBJECTS.put(subject, students);
        }
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        List<Student> filteredStudent = filterStudent(List.of(student));
        student = filterStudent(List.of(student)).isEmpty() ? null : filteredStudent.get(0);

        Set<Map.Entry<Subject, List<Student>>> entries = SUBJECTS.entrySet();

        for (Map.Entry<Subject, List<Student>> subj : entries) {
            if (subj.getKey().equals(subject)) {
                subj.getValue().add(student);
            }
        }
    }

    public static void deleteStudentFromSubject(Subject subject, Student student) {
        Set<Map.Entry<Subject, List<Student>>> entries = SUBJECTS.entrySet();

        for (Map.Entry<Subject, List<Student>> subj : entries) {
            if (subj.getKey().equals(subject)) {
                subj.getValue().remove(student);
            }
        }
    }

    public static Map<Subject, List<Student>> getAllSubjects() {
        return SUBJECTS;
    }


    public static Map<Subject, Integer> filterSubject(Map<Subject, Integer> subjects) {
        if (subjects != null && !subjects.isEmpty()) {
            Map<Subject, Integer> filteredSubjects = new HashMap<>();
            Set<Map.Entry<Subject, Integer>> entries = subjects.entrySet();

            entries.forEach(subj -> {
                if (SUBJECTS.containsKey(subj.getKey())) {
                    filteredSubjects.put(subj.getKey(), subj.getValue());
                }
            });

            return filteredSubjects;
        } else {
            return subjects;
        }
    }

    public static List<Student> filterStudent(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return students;
        } else {
            return students.stream()
                    .filter(STUDENTS::containsKey)
                    .toList();
        }
    }
}
