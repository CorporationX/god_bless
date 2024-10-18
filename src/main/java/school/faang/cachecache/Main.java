package school.faang.cachecache;

import java.util.*;
import java.util.function.Function;

public class Main {

    static Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();
    static Map<Subject, List<Student>> subjectMap = new HashMap<>();

    static public boolean addNewStudent(Student student, Subject subject, Integer grade) {
        if (!studentMap.containsKey(student)) {
            studentMap.computeIfAbsent(student, map -> new HashMap<>()).put(subject, grade);
            subjectMap.computeIfAbsent(subject, value -> new ArrayList<>()).add(student);
            return true;
        }
        return false;
    }

    static public void addNewSubjectWithGrade(Student student, Subject subject, Integer grade) {
        studentMap.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
        subjectMap.computeIfAbsent(subject, st -> new ArrayList<>()).add(student);
    }

    static public void addNewSubjectWithStudentList(Subject subject, List<Student> studentList) {
        subjectMap.put(subject, studentList);
        studentList.stream()  //if list contains new students
                .filter(student -> !studentMap.containsKey(student))
                .forEach(student -> studentMap
                        .computeIfAbsent(student, value -> new HashMap<>())
                        .put(subject, 0));
    }

    static public void addNewStudentToSubject(Student student, Subject subject) {
        subjectMap.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
        addNewStudent(student, subject, 0);
    }

    static public boolean removeStudentFromStudentMap(Student student) {
        Iterator<Map.Entry<Student, Map<Subject, Integer>>> iterator = studentMap.entrySet().iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            boolean wasRemoved = iterator.next().getKey().equals(student);
            if (wasRemoved) {
                iterator.remove();
                removed = true;
            }
        }
        for (Map.Entry<Subject, List<Student>> entry : subjectMap.entrySet()) {
            entry.getValue().remove(student);
        }
        return removed;
    }

    static public void removeStudentFromSubjectMap(Student student) {
        Iterator<Map.Entry<Subject, List<Student>>> iterator = subjectMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Subject, List<Student>> entry = iterator.next();
            List<Student> students = entry.getValue();
            students.remove(student);
            if (students.isEmpty()) {
                iterator.remove();
            }
        }
    }

    static public void printAllStudents() {
        studentMap.forEach((student, subjectsGrades) -> {
            System.out.println("Student: " + student.getName());
            subjectsGrades.forEach((subject, grade) -> {
                System.out.println("  Subject: " + subject.getName() + ", Grade: " + grade);
            });
            System.out.println();
        });
    }

    static public void printAllSubjects() {
        subjectMap.forEach((subject, students) -> {

            System.out.println("Subject: " + subject.getName());

            students.forEach(student -> System.out.println("  Student: " + student.getName()));
        });
    }


    public static void main(String[] args) {

        Student student1 = new Student(1, "John");
        Student student2 = new Student(2, "Jane");
        Student student3 = new Student(3, "Vova");
        Student student4 = new Student(4, "Igor");

        Subject math = new Subject(1, "Math");
        Subject science = new Subject(2, "Science");

        addNewStudent(student1, math, 90);
        addNewSubjectWithGrade(student1, science, 85);

        addNewStudent(student2, math, 95);
        addNewSubjectWithGrade(student2, science, 75);

        addNewStudent(student3, math, 90);
        addNewSubjectWithGrade(student3, science, 85);

        addNewStudent(student4, math, 95);
        addNewSubjectWithGrade(student4, science, 75);
        List<Student> studentList1 = new ArrayList<>(Arrays.asList(student1, student2));
        List<Student> studentList2 = new ArrayList<>(Arrays.asList(student3, student4));

        addNewSubjectWithStudentList(math, studentList1);
        addNewSubjectWithStudentList(science, studentList2);

        printAllStudents();
        printAllSubjects();
        removeStudentFromSubjectMap(student1);
        removeStudentFromStudentMap(student1);
        printAllStudents();
        printAllSubjects();
    }
}


