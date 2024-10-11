package school.faang.bjs2_32525;

import java.util.ArrayList;
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
        testRemoveStudentWithGradesBySubject(student, studentsSubjectsGrades);

        Subject mathematics = new Subject("Mathematics");
        testAddSubjectWithStudents(mathematics, studentsBySubject);
        testAddStudentToSubject(mathematics, studentsBySubject);
        testRemoveStudentFromSubject(mathematics,studentsBySubject);
    }

    private static void testRemoveStudentFromSubject(Subject subject, Map<Subject, List<Student>> studentsBySubject) {
        System.out.println("\ntestRemoveStudentFromSubject\n");

        System.out.println("students by subject before:\n");
        studentManager.printAllStudentsBySubjects(studentsBySubject);

        List<Student> students = studentsBySubject.get(subject);
        Student student = students.get(0);
        studentManager.removeStudentFromSubject(subject,student,studentsBySubject);
        System.out.println("remove: " + student);

        System.out.println("\nstudents by subject before:\n");
        studentManager.printAllStudentsBySubjects(studentsBySubject);
    }

    private static void testAddStudentToSubject(Subject subject, Map<Subject, List<Student>> studentsBySubject) {
        System.out.println("\ntestAddSubjectWithStudents\n");

        System.out.println("students by subject before:\n");
        studentManager.printAllStudentsBySubjects(studentsBySubject);

        Student student = new Student("Mark");
        System.out.println("add: " + student);
        studentManager.addStudentToSubject(subject, student, studentsBySubject);

        System.out.println("\nstudents by subject before:\n");
        studentManager.printAllStudentsBySubjects(studentsBySubject);
    }

    private static void testAddSubjectWithStudents(Subject subject, Map<Subject, List<Student>> studentsBySubject) {
        System.out.println("\ntestAddSubjectWithStudents\n");

        List<Student> students = generateListStudents();

        System.out.println("students by subject before:\n");
        studentManager.printAllStudentsBySubjects(studentsBySubject);

        System.out.println("add subject with list students");
        studentManager.addSubjectWithStudents(subject, students, studentsBySubject);

        System.out.println("\nstudents by subject after:\n");
        studentManager.printAllStudentsBySubjects(studentsBySubject);
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

        studentManager.printAllStudentsWithGradesBySubjects(studentsWithGradesBySubjects);
    }

    private static void testAddSubjectWithGradesToStudent(Student student, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        System.out.println("\ntestAddSubjectWithGradesToStudent\n");

        Subject physics = new Subject("Physical education");
        int gradePhysicalEducation = 5;

        System.out.println("students with grades by subjects before:\n");
        studentManager.printAllStudentsWithGradesBySubjects(studentsWithGradesBySubjects);

        System.out.println("add a student Subject - " + physics.getName() + ", grade - " + gradePhysicalEducation);
        studentManager.addSubjectWithGradesToStudent(student, physics, gradePhysicalEducation, studentsWithGradesBySubjects);

        System.out.println("\nstudents with grades by subjects after:\n");
        studentManager.printAllStudentsWithGradesBySubjects(studentsWithGradesBySubjects);
    }

    private static void testRemoveStudentWithGradesBySubject(Student student, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        System.out.println("\ntestRemoveStudentWithGradesBySubject\n");

        System.out.println("students with grades by subjects before:\n");
        studentManager.printAllStudentsWithGradesBySubjects(studentsWithGradesBySubjects);

        System.out.println("remove student with grades by subject: " + student);
        studentManager.removeStudentWithGradesBySubject(student, studentsWithGradesBySubjects);

        System.out.println("\nstudents with grades by subjects after:\n");
        studentManager.printAllStudentsWithGradesBySubjects(studentsWithGradesBySubjects);
    }


}
