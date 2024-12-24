package double_Cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private static Map<Subject, List<Student>> studentsStudyingSubject = new HashMap<>();
    private static final StudentDatabase studentDatabase = new StudentDatabase();

    public static void main(String[] args) {
        Student Petr = new Student("Petr");
        Student Dima = new Student("Dima");
        Student Kate = new Student("Kate");
        Student Kirill = new Student("Kirill");
        Subject mathematics = new Subject("Mathematics");
        Subject physics = new Subject("physics");
        Subject chemistry = new Subject("chemistry");
        List<Student> studentList = new ArrayList<>();
        studentList.add(Petr);
        studentList.add(Dima);
        studentList.add(Kate);
        studentList.add(Kirill);

        //обаботка методов для studentGrades

        System.out.println(studentGrades);
        System.out.println(studentGrades);

        studentDatabase.printAllAssessmentsStudents(studentGrades);

        //Обработка методов для StudentsStudyingSubject
        studentDatabase.addSubjectWithListStudents(physics, studentList, studentsStudyingSubject);
        studentDatabase.addSubjectWithListStudents(mathematics, studentList, studentsStudyingSubject);

        //studentDatabase.removeStudentFromSubject(physics,Dima,studentsStudyingSubject);
        studentDatabase.printAllStudentFromSubject(studentsStudyingSubject);
    }
}
