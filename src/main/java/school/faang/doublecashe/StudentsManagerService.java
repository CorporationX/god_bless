package school.faang.doublecashe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentsManagerService {
    private final Map<Student, Map<Subject, Integer>> students = new HashMap<>();
    private final Map<Subject, List<Student>> subjects = new HashMap<>();

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> studentsSubjects) {
        students.computeIfAbsent(student, s -> studentsSubjects);
        studentsSubjects.forEach((key, value) -> subjects.computeIfAbsent(key, l -> new ArrayList<>()).add(student));
    }

    public void showStudents() {
        students.forEach((key, value) -> {
            System.out.println(key);
            System.out.println("- - -");
            value.forEach((subjKey, subjValue) -> System.out.println("Subject: " + subjKey + " Grade: " + subjValue));
            System.out.println("---------------");
        });
        System.out.println("---END---");
        System.out.println();
    }

    public void showSubjects() {
        subjects.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(System.out::println);
            System.out.println("- - -");
        });
        System.out.println("---END---");
        System.out.println();
    }

    public void addSubjectWithGradeToStudent(Student student, Subject subject, int grade) {
        students.computeIfAbsent(student, s -> new HashMap<>()).put(subject, grade);
        subjects.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
    }

    public void deleteStudent(Student student) {
        Map<Subject, Integer> removedItem = students.remove(student);

        if(removedItem == null) {
            return;
        }

        subjects.forEach((key, value) -> value.remove(student));
    }

    public void addSubjectWithStudents(Subject newSubject, List<Student> studentsList) {
        subjects.computeIfAbsent(newSubject, s -> new ArrayList<>()).addAll(studentsList);
        // решил обработать кейс, когда добавляемый предмет уже существует, и в него могут добавиться дубликаты
        // записей о студентах
        List<Student> studentList = subjects.get(newSubject);
        Set<Student> studentsWithoutDuplicate = new HashSet<>(studentList);
        studentList.clear();
        studentList.addAll(studentsWithoutDuplicate);

        studentList.forEach(student -> students.computeIfAbsent(student, s -> new HashMap<>()).put(newSubject, null));
    }

    public void deleteStudentFromSubject(Student student, Subject subject) {
        subjects.get(subject).remove(student);
        students.get(student).remove(subject);
    }
}
