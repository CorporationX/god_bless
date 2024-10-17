package module_2.module_2_2_StreamAPI.electronicDiary_35235;


import module_2.module_2_2_StreamAPI.electronicDiary_35235.entity.School;
import module_2.module_2_2_StreamAPI.electronicDiary_35235.entity.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        School hogvarts = new School("Hogvarts");
        List<Student> studentsHogvarts = hogvarts.getStudents();

        hogvarts.addStudentsFromJSON("C:\\students_test_data.json");
        hogvarts.calculateAverageScore(studentsHogvarts)
                .forEach((k, v) -> System.out.println("Предмет: " + k + " " + Math.round(v)));

        System.out.println("\nИтоговые оценки студента: Алексей Петрова ");
        hogvarts.getTotalScoreStudent(studentsHogvarts, "Алексей", "Петрова").ifPresent(map -> {
            map.forEach((k, v) -> System.out.println(k + "-" + Math.round(v)));
        });

        System.out.println("\nСамый сложный предмет: " + hogvarts.calculateHardSubject(studentsHogvarts));

        hogvarts.printTotalScoreStudents(studentsHogvarts);

    }
}
