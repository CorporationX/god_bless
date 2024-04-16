package faang.school.godbless.electronicDiary;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student grisha = new Student("Grisha", "Pahomov");
        Map<String, List<Integer>> courses = Map.of("Math", List.of(5, 4, 4, 3, 3, 5),
                "Literature", List.of(5, 4, 5, 4, 4, 5),
                "Chemistry", List.of(3, 2, 4, 5, 5));
        grisha.setCourses(courses);

        Student vanya = new Student("Vanya", "Alekseev");
        Map<String, List<Integer>> coursesVanya = Map.of("Math", List.of(4, 4, 4, 3, 3, 5),
                "Literature", List.of(3, 4, 5, 4, 4, 3),
                "Chemistry", List.of(5, 4, 4, 5, 5));
        vanya.setCourses(coursesVanya);

        List<Student> students = List.of(grisha, vanya);
        Service service = new Service();

        System.out.println("---Total average per courses---");
        System.out.println(service.calculateAverage(students));

        System.out.println("---Grisha Pahomov : average per courses---");
        System.out.println(service.calcTotalScorePerSubjForStudent(students, "Grisha", "Pahomov"));

        System.out.println("----Most difficult subject----");
        System.out.println(service.findTheMostDifficultSubject(students));


    }
}
