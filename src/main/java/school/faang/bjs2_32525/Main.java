package school.faang.bjs2_32525;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static StudentManager studentManager;

    public static void main(String[] args) {
        Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects = new HashMap<>();
        Map<Subject, List<Student>> studentsBySubject = new HashMap<>();
        studentManager = new StudentManager(studentsWithGradesBySubjects,studentsBySubject);

        Student student = new Student("Alex");
        testAddStudentWithGradesBySubjects(student);
        testAddSubjectWithGradesToStudent(student);
        testRemoveStudentWithGradesBySubject(student);

        Subject mathematics = new Subject("Mathematics");
        testAddSubjectWithStudents(mathematics);
        testAddStudentToSubject(mathematics);
        testRemoveStudentFromSubject(mathematics, studentsBySubject);
    }

    private static void testRemoveStudentFromSubject(Subject subject, Map<Subject, List<Student>> studentsBySubject) {
        System.out.println("\ntestRemoveStudentFromSubject\n");

        System.out.println("students by subject before:\n");
        studentManager.printAllStudentsBySubjects();

        List<Student> students = studentsBySubject.get(subject);
        Student student = students.get(0);
        studentManager.removeStudentFromSubject(subject, student);
        System.out.println("remove: " + student);

        System.out.println("\nstudents by subject before:\n");
        studentManager.printAllStudentsBySubjects();
    }

    private static void testAddStudentToSubject(Subject subject) {
        System.out.println("\ntestAddSubjectWithStudents\n");

        System.out.println("students by subject before:\n");
        studentManager.printAllStudentsBySubjects();

        Student student = new Student("Mark");
        System.out.println("add: " + student);
        studentManager.addStudentToSubject(subject, student);

        System.out.println("\nstudents by subject before:\n");
        studentManager.printAllStudentsBySubjects();
    }

    private static void testAddSubjectWithStudents(Subject subject) {
        System.out.println("\ntestAddSubjectWithStudents\n");

        List<Student> students = generateListStudents();

        System.out.println("students by subject before:\n");
        studentManager.printAllStudentsBySubjects();

        System.out.println("add subject with list students");
        studentManager.addSubjectWithStudents(subject, students);

        System.out.println("\nstudents by subject after:\n");
        studentManager.printAllStudentsBySubjects();
    }

    private static List<Student> generateListStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex"));
        students.add(new Student("Maria"));
        students.add(new Student("John"));
        students.add(new Student("Emily"));
        students.add(new Student("Michael"));
        return students;
    }

    private static void testAddStudentWithGradesBySubjects(Student student) {
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

        studentManager.addStudentWithGradesBySubjects(student, gradesBySubjects);
        System.out.println("print all map:\n");
        studentManager.printAllStudentsWithGradesBySubjects();
    }

    private static void testAddSubjectWithGradesToStudent(Student student) {
        System.out.println("\ntestAddSubjectWithGradesToStudent\n");

        Subject physics = new Subject("Physical education");
        int gradePhysicalEducation = 5;

        System.out.println("students with grades by subjects before:\n");
        studentManager.printAllStudentsWithGradesBySubjects();

        System.out.println("add a student Subject - " + physics.getName() + ", grade - " + gradePhysicalEducation);
        studentManager.addSubjectWithGradesToStudent(student, physics, gradePhysicalEducation);

        System.out.println("\nstudents with grades by subjects after:\n");
        studentManager.printAllStudentsWithGradesBySubjects();
    }

    private static void testRemoveStudentWithGradesBySubject(Student student) {
        System.out.println("\ntestRemoveStudentWithGradesBySubject\n");

        System.out.println("students with grades by subjects before:\n");
        studentManager.printAllStudentsWithGradesBySubjects();

        System.out.println("remove student with grades by subject: " + student);
        studentManager.removeStudentWithGradesBySubject(student);

        System.out.println("\nstudents with grades by subjects after:\n");
        studentManager.printAllStudentsWithGradesBySubjects();
    }


}
