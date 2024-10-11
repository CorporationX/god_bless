package school.faang.bjs2_32525;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final StudentManager studentManager = new StudentManager();

    public static void main(String[] args) {
        Map<Student, Map<Subject, Integer>> studentsSubjectsGrades = new HashMap<>();
        Map<Subject, List<Student>> studentsBySubject = new HashMap<>();

        Student student = new Student("Alex");
        testAddStudentWithGradesBySubjects(student, studentsSubjectsGrades);
        testAddSubjectWithGradesToStudent(student, studentsSubjectsGrades);
        testRemoveStudentWithGradesBySubject(student,studentsSubjectsGrades);

    }

    private static void testAddStudentWithGradesBySubjects(Student student, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        System.out.println("\ntestAddStudentWithGradesBySubjects\n");


        Subject math = new Subject("Mathematics");
        Subject physics = new Subject("Physics");
        Subject literature = new Subject("Literature");

        Map<Subject, Integer> gradesBySubjects = new HashMap<>();

        int gradeMath = 4;
        gradesBySubjects.put(math, gradeMath);
        int gradePhysics = 4;
        gradesBySubjects.put(physics, gradePhysics);
        int gradeLiterature = 5;
        gradesBySubjects.put(literature, gradeLiterature);

        studentManager.addStudentWithGradesBySubjects(student, gradesBySubjects, studentsWithGradesBySubjects);

        printStudentsWithGradesBySubjects(studentsWithGradesBySubjects);
    }

    private static void testAddSubjectWithGradesToStudent(Student student, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        System.out.println("\ntestAddSubjectWithGradesToStudent\n");

        Subject physics = new Subject("Physical education");
        int gradePhysicalEducation = 5;

        System.out.println("students with grades by subjects before:\n");
        printStudentsWithGradesBySubjects(studentsWithGradesBySubjects);

        System.out.println("add a student Subject - " + physics.getName() + ", grade - " + gradePhysicalEducation);
        studentManager.addSubjectWithGradesToStudent(student, physics, gradePhysicalEducation, studentsWithGradesBySubjects);

        System.out.println("\nstudents with grades by subjects after:\n");
        printStudentsWithGradesBySubjects(studentsWithGradesBySubjects);
    }

    private static void testRemoveStudentWithGradesBySubject(Student student, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        System.out.println("\ntestRemoveStudentWithGradesBySubject\n");

        System.out.println("students with grades by subjects before:\n");
        printStudentsWithGradesBySubjects(studentsWithGradesBySubjects);

        System.out.println("remove student with grades by subject: " + student);
        studentManager.removeStudentWithGradesBySubject(student, studentsWithGradesBySubjects);

        System.out.println("\nstudents with grades by subjects after:\n");
        printStudentsWithGradesBySubjects(studentsWithGradesBySubjects);
    }

    private static void printStudentsWithGradesBySubjects(Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        for (Map.Entry<Student, Map<Subject, Integer>> studentMapEntry : studentsWithGradesBySubjects.entrySet()) {
            System.out.println(studentMapEntry.getKey() + ":");
            Map<Subject, Integer> gradesBySubjects = studentMapEntry.getValue();

            for (Map.Entry<Subject, Integer> subjectIntegerEntry : gradesBySubjects.entrySet()) {
                System.out.println(subjectIntegerEntry.getKey().getName() + " = " + subjectIntegerEntry.getValue());
            }

        }
        System.out.println();
    }

}
