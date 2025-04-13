package doubled.cache.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Subject, Integer> subjectsAndGradesDan = new HashMap<>();
    private static Map<Subject, Integer> subjectsAndGradesJohn = new HashMap<>();
    private static Map<Subject, Integer> subjectsAndGradesMaria = new HashMap<>();

    public static void main(String[] args) {
        //Такая длинная инициализация просто для тестирования
        subjectsAndGradesDan.put(new Subject("Geometry"), 5);
        subjectsAndGradesDan.put(new Subject("Mathematic"), 8);
        subjectsAndGradesDan.put(new Subject("Informatic"), 9);
        subjectsAndGradesDan.put(new Subject("Geography"), 6);

        subjectsAndGradesJohn.put(new Subject("Sport"), 10);
        subjectsAndGradesJohn.put(new Subject("Mathematic"), 7);
        subjectsAndGradesJohn.put(new Subject("Informatic"), 5);
        subjectsAndGradesJohn.put(new Subject("Phisics"), 9);

        subjectsAndGradesMaria.put(new Subject("Geometry"), 9);
        subjectsAndGradesMaria.put(new Subject("Mathematic"), 10);
        subjectsAndGradesMaria.put(new Subject("Litherature"), 8);
        subjectsAndGradesMaria.put(new Subject("Geography"), 9);

        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudent("Dan", subjectsAndGradesDan);
        studentDatabase.addStudent("John", subjectsAndGradesJohn);
        studentDatabase.addStudent("Maria", subjectsAndGradesMaria);

        studentDatabase.printAllStudentsInfo();

        studentDatabase.addSubjectToExistingStudent("Maria", "Algebra", 9);
        studentDatabase.addSubjectToExistingStudent("Maria", "History", 5);
        studentDatabase.addSubjectToExistingStudent("Dan", "Biology", 5);

        System.out.println("After add nex subjects-------------------------------------");
        studentDatabase.printAllStudentsInfo();
        System.out.println("After remove------------------------------------------------");

        studentDatabase.removeStudentAndData("John");
        studentDatabase.printAllStudentsInfo();
    }
}
