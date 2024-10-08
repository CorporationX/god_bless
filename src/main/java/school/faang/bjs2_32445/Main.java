package school.faang.bjs2_32445;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECTS_AND_GRADES = new HashMap<>();
    private static final Map<Subject, List<Student>> STUDENTS_STUDYING_SUBJECT = new HashMap<>();

    private Main() {
    }

    public static void main(String[] args) {
        addNewStudent(new Student(1, "Steve"), new Subject(40, "Physics"), 4);
        addNewStudent(new Student(1, "Steve"), new Subject(55, "Geography"), 3);
        addNewStudent(new Student(2, "Tom"), new Subject(50, "Astronomy"), 5);

        deleteStudent(new Student(1, "Steve"));

        printStudents();
    }

    public static void addNewStudent(Student student, Subject subject, int grade) {
        STUDENT_SUBJECTS_AND_GRADES.putIfAbsent(student, new HashMap<>());
        STUDENT_SUBJECTS_AND_GRADES.get(student).put(subject, grade);
    }

    public static void deleteStudent(Student student) {
        STUDENT_SUBJECTS_AND_GRADES.remove(student);
    }

    public static void printStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> student : STUDENT_SUBJECTS_AND_GRADES.entrySet()) {
            log.info("\nStudent: " + student.getKey().getName() + "\n" + "Subjects and grades: " + student.getValue().entrySet();
        }
    }

}
