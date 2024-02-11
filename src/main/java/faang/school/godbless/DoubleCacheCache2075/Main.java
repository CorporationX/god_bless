package faang.school.godbless.DoubleCacheCache2075;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<Student, Map<Subject, Integer>> studentSubjectsMap = new HashMap<>();
    static Map<Subject, List<Student>> subjectsMap = new HashMap<>();

    public static void main(String[] args) {
        Student testStudent1 = new Student("Kamil");
        Student testStudent2 = new Student("Dima");
        Student testStudent3 = new Student("Victor");
        Student testStudent4 = new Student("Kirill");
        Subject testSubject1 = new Subject("Math");
        Subject testSubject2 = new Subject("Literature");
        Subject testSubject3 = new Subject("English");
        Subject testSubject4 = new Subject("PE");
        addStudentToMap(testStudent1, new HashMap<>(Map.of(testSubject1, 5, testSubject2, 4, testSubject3, 3, testSubject4, 4)));
        addStudentToMap(testStudent2, new HashMap<>(Map.of(testSubject1, 5, testSubject2, 3, testSubject3, 5, testSubject4, 3)));
        addStudentToMap(testStudent3, new HashMap<>(Map.of(testSubject1, 4, testSubject2, 3, testSubject3, 5, testSubject4, 4)));
        addStudentToMap(testStudent4, new HashMap<>(Map.of(testSubject1, 5, testSubject2, 4, testSubject3, 5, testSubject4, 5)));
        testStudents("TEST 1: Adding students and their subjects/grades to map");
        Subject testSubject5 = new Subject("Chemistry");
        addSubjectToStudent(testStudent1, testSubject5, 4);
        addSubjectToStudent(testStudent3, testSubject5, 5);
        testStudents("TEST 2: Added \"Chemistry\" for Kamil and Victor");
        removeStudentFromMap(testStudent4);
        testStudents("TEST 3: Removed Kirill (sorry)");
        addSubject(testSubject1, new ArrayList<>(List.of(testStudent1, testStudent2, testStudent3, testStudent4)));
        addSubject(testSubject2, new ArrayList<>(List.of(testStudent1, testStudent2, testStudent3, testStudent4)));
        addSubject(testSubject3, new ArrayList<>(List.of(testStudent1, testStudent2, testStudent3, testStudent4)));
        addSubject(testSubject4, new ArrayList<>(List.of(testStudent1, testStudent2, testStudent3, testStudent4)));
        testSubjects("TEST 4: Subjects info");
        addStudentToSubject(testSubject2, new Student("Newbie"));
        addStudentToSubject(testSubject3, new Student("Newbie"));
        testSubjects("TEST 4: Added Newbie to Literature and English");
        removeStudentFromSubject(testSubject4, testStudent1);
        removeStudentFromSubject(testSubject2, testStudent2);
        testSubjects("TEST 5: Removed Victor from PE and Dima from Literature");
        testStudents("TEST 6: Final test");
    }

    public static void addStudentToMap(Student student, Map<Subject, Integer> grades) {
        if (!studentSubjectsMap.containsKey(student)) {
            studentSubjectsMap.put(student, grades);
        }
    }

    public static void addSubjectToStudent(Student student, Subject subject, Integer grade) {
        if (studentSubjectsMap.containsKey(student)) {
            studentSubjectsMap.get(student).put(subject, grade);
        }
    }

    public static void removeStudentFromMap(Student student) {
        studentSubjectsMap.remove(student);
    }

    public static void addSubject(Subject subject, List<Student> studentList) {
        if (!(subjectsMap.containsKey(subject))) {
            subjectsMap.put(subject, studentList);
        }
    }

    public static void addStudentToSubject(Subject subject, Student student) {
        if (subjectsMap.containsKey(subject)) {
            if (!(subjectsMap.get(subject).contains(student))) {
                subjectsMap.get(subject).add(student);
            }
        }
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        if (subjectsMap.containsKey(subject)) {
            subjectsMap.get(subject).remove(student);
        }
    }

    public static void printAllSubjectsInfo() {
        for (var entry : subjectsMap.entrySet()) {
            System.out.println("SUBJECT: " + entry.getKey().getName());
            System.out.print("STUDENTS, LEARNING IT: | ");
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(entry.getValue().get(i).getName() + " | ");
            }
            System.out.println();
        }
    }

    public static void printAllStudentsInfo() {
        for (var entry : studentSubjectsMap.entrySet()) {
            String student = entry.getKey().getName();
            Map<Subject, Integer> subjectsMap = entry.getValue();
            System.out.println("STUDENT: " + student);
            System.out.print("HIS SUBJECTS - GRADES: ");
            for (var subjectEntry : subjectsMap.entrySet()) {
                System.out.printf("%s - %d | ",
                        subjectEntry.getKey().getName(),
                        subjectEntry.getValue());
            }
            System.out.println();
        }
    }

    private static void testStudents(String message) {
        System.out.println(message);
        System.out.println("==================================================================");
        printAllStudentsInfo();
        System.out.println("==================================================================");
    }

    private static void testSubjects(String message) {
        System.out.println(message);
        System.out.println("==================================================================");
        printAllSubjectsInfo();
        System.out.println("==================================================================");
    }
}