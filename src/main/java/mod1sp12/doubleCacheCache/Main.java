package mod1sp12.doubleCacheCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_TO_SUBJECT_MAP = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECT_TO_STUDENTS_LIST_MAP = new HashMap<>();

    private static void addStudent(Student student, Map<Subject, Integer> SubjectsWithMarks) {
        STUDENT_TO_SUBJECT_MAP.put(student, SubjectsWithMarks);
        Map<Subject, Integer> map = STUDENT_TO_SUBJECT_MAP.get(student);
        for (Map.Entry<Subject, Integer> entry : map.entrySet()) {
            Subject subject = entry.getKey();
            SUBJECT_TO_STUDENTS_LIST_MAP.computeIfAbsent(subject, key -> new ArrayList<>()).add(student);
        }
    }

    private static void deleteStudent(Student student) {
        Map<Subject, Integer> map = STUDENT_TO_SUBJECT_MAP.get(student);
        for (Map.Entry<Subject, Integer> entry : map.entrySet()) {
            Subject subject = entry.getKey();
            SUBJECT_TO_STUDENTS_LIST_MAP.get(subject).remove(student);
            if (SUBJECT_TO_STUDENTS_LIST_MAP.get(subject).isEmpty()) {
                SUBJECT_TO_STUDENTS_LIST_MAP.remove(subject);
            }
        }
        STUDENT_TO_SUBJECT_MAP.remove(student);
    }

    private static void printStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENT_TO_SUBJECT_MAP.entrySet()) {
            System.out.printf(entry.getKey() + ": " + "\n");
            for (var entrySubjectMap : entry.getValue().entrySet()) {
                System.out.println("\t" + entrySubjectMap.getKey() + ": " + entrySubjectMap.getValue());
            }
            System.out.println();
        }
    }

    private static void printSubject() {
        for (var entry : SUBJECT_TO_STUDENTS_LIST_MAP.entrySet()) {
            System.out.printf("Subject: %s:\n\t%s", entry.getKey().getName(), entry.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        Student student = new Student(1, "Denis");
        Student student2 = new Student(2, "Andrew");
        Map<Subject, Integer> marks = new HashMap<>(Map.of(
                new Subject(1, "Math"), 5,
                new Subject(2, "English"), 5,
                new Subject(3, "Physics"), 4,
                new Subject(4, "Chemistry"), 4
        ));
        Map<Subject, Integer> marks1 = new HashMap<>(Map.of(
                new Subject(3, "Physics"), 4,
                new Subject(4, "Chemistry"), 4
        ));
        addStudent(student2, marks1);
        addStudent(student, marks);

        printStudents();
        printSubject();
        deleteStudent(new Student(1, "Denis"));
        System.out.println();
        printStudents();
        printSubject();
    }
}
