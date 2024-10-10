package school.faang.bjs2_32525;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final StudentManager studentManager = new StudentManager();

    public static void main(String[] args) {
        Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects = new HashMap<>();
        Map<Subject, List<Student>> studentsBySubject = new HashMap<>();

        testAddStudentWithGradesBySubjects(studentsWithGradesBySubjects);
    }

    private static void testAddStudentWithGradesBySubjects(Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        System.out.println("\ntestAddStudentWithGradesBySubjects\n");

        Student student = new Student(1, "Alex");

        Subject math = new Subject(1, "Mathematics");
        Subject physics = new Subject(2, "Physics");
        Subject literature = new Subject(3, "Literature");

        Map<Subject, Integer> gradesBySubjects = new HashMap<>();
        gradesBySubjects.put(math, 4);
        gradesBySubjects.put(physics, 4);
        gradesBySubjects.put(literature, 5);

        studentManager.addStudentWithGradesBySubjects(student, gradesBySubjects, studentsWithGradesBySubjects);

        printStudentsWithGradesBySubjects(studentsWithGradesBySubjects);
    }

    private static void printStudentsWithGradesBySubjects(Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        for (Map.Entry<Student, Map<Subject, Integer>> studentMapEntry : studentsWithGradesBySubjects.entrySet()) {
            System.out.println(studentMapEntry.getKey()+":");
            Map<Subject, Integer> gradesBySubjects2 = studentMapEntry.getValue();

            for (Map.Entry<Subject, Integer> subjectIntegerEntry : gradesBySubjects2.entrySet()) {
                System.out.println(subjectIntegerEntry.getKey().getName() + " = " + subjectIntegerEntry.getValue());
            }

        }
        System.out.println();
    }

}
