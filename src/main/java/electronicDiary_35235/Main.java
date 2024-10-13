package electronicDiary_35235;


import electronicDiary_35235.entity.School;

public class Main {

    public static void main(String[] args) {

        School school = new School();
        school.addStudentsFromJSON("D:\\javaprojects\\faang_school\\src\\main\\java\\electronicDiary_35235\\students_test_data.json");
        school.calculateAverageScore(school.getStudents())
                .forEach((k, v) -> System.out.println("Предмет: " + k + " " + Math.round(v)));

        System.out.println("\nИтоговые оценки студента: Алексей Петрова ");
        school.getTotalScoreStudent(school.getStudents(), "Алексей", "Петрова").ifPresent(map -> {
            map.forEach((k, v) -> System.out.println(k + "-" + v));
        });

        System.out.println("Самый сложный предмет: " + school.calculateHardSubject(school.getStudents()));

    }
}
