package school.faang.electronic_devil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, List<Integer>> cources = new HashMap<>();
        cources.put("Math", List.of(3,4,5,4));
        cources.put("Prog", List.of(4,4,3));
        cources.put("Deu", List.of(4,5,5));
        Student student1 = new Student("Garry", "Potter", cources);

        cources = new HashMap<>();
        cources.put("Math", List.of(3,4,5,5,5));
        cources.put("Russ", List.of(5,5,2));
        cources.put("Transf", List.of(5,5,5,5));
        cources.put("Sport", List.of(2,3));
        cources.put("Deu", List.of(2,3));
        Student student2 = new Student("Germiona", "Granger", cources);

        cources = new HashMap<>();
        cources.put("Math", List.of(3,2,4));
        cources.put("Sport", List.of(5,5,5,4));
        cources.put("Prog", List.of(4,4,4));
        Student student3 = new Student("Ron", "Uezli", cources);

        List<Student> students = new ArrayList<>(List.of(student1,student2,student3));

        System.out.println(SchoolService.averageGradeSchoolEachSubject(students));


        SchoolService service = new SchoolService();
        Map<String, Integer> grades = service.getFinalGradesForStudent(students, "Germiona", "Granger");

        System.out.println("Итоговые оценки студента:");
        grades.forEach((subject, grade) ->
                System.out.println(subject + ": " + grade));

    }
}
