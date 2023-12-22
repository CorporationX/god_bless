package faang.school.godbless.java_hashmap.double_cache_cache;

import java.util.*;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> cache1 = new HashMap<>();

    private static final Map<Subject, List<Student>> cache2 = new HashMap<>();
    private static Random random = new Random();

    public static void main(String[] args) {

        Subject subject1 = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "History");
        Subject subject3 = new Subject(3, "Physics");
        Subject subject4 = new Subject(4, "Music");
        Subject subject5 = new Subject(5, "Biology ");
        Subject subject6 = new Subject(6, "Chemistry");
        Subject subject7 = new Subject(7, "English");
        Subject subject8 = new Subject(8, "Spanish");
        Subject subject9 = new Subject(9, "Programming");
        Subject subject10 = new Subject(10, "Gymnastics");

        Student student1 = new Student(1, "Student_1");
        Student student2 = new Student(2, "Student_2");
        Student student3 = new Student(3, "Student_3");
        Student student4 = new Student(4, "Student_4");
        Student student5 = new Student(5, "Student_5");
        Student student6 = new Student(6, "Student_6");
        Student student7 = new Student(7, "Student_7");
        Student student8 = new Student(8, "Student_8");

        addNewStudentWithSubject(student1, new ArrayList<>(List.of(subject1, subject2, subject3)));
        addNewStudentWithSubject(student2, new ArrayList<>(List.of(subject1, subject6, subject7)));
        addNewStudentWithSubject(student3, new ArrayList<>(List.of(subject1, subject9, subject10)));
        addNewStudentWithSubject(student4, new ArrayList<>(List.of(subject1, subject2, subject7)));
        addNewStudentWithSubject(student5, new ArrayList<>(List.of(subject1, subject6, subject2)));

        addNewSubjectForStudent(student1, subject4);

        removeStudent(student2);

        printStudentsWithSubjects();

        addNewSubjectWithStudents(subject1, new ArrayList<>(List.of(student1, student2, student3)));
        addNewSubjectWithStudents(subject2, new ArrayList<>(List.of(student1, student4, student5)));
        addNewSubjectWithStudents(subject7, new ArrayList<>(List.of(student2, student4)));

        addStudent(student4, subject2);


    }


    static void addNewStudentWithSubject(Student student, List<Subject> subjects) {

        for (Subject sub : subjects) {
            cache1.computeIfAbsent(student, v -> new HashMap<>()).put(sub, random.nextInt(1, 6));
        }
    }


    static void addNewSubjectForStudent(Student student, Subject subject) {
        cache1.computeIfPresent(student, (k, v) -> {
            v.put(subject, random.nextInt(1, 6));
            return v;
        });
    }

    static void removeStudent(Student student) {
        if (cache1.remove(student) == null) {
            System.out.println("Student not found");
        }else {
            System.out.println("successfully deleted");
        }
    }

    static void printStudentsWithSubjects() {
        cache1.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }

    static void addNewSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject == null || students == null) throw new IllegalArgumentException("args is null");
        cache2.put(subject, students);
    }

    static void addStudent(Student student, Subject subject) {
        cache2.computeIfPresent(subject, (key, list) -> {
            list.add(student);
            return list;
        });
    }


}
