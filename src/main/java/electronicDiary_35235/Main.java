package electronicDiary_35235;


import electronicDiary_35235.entity.School;

public class Main {

    public static void main(String[] args) {

        School school = new School();
        school.addStudentsFromJSON("C:\\students_test_data.json");
        school.calculateAverageScore(school.getStudents())
                .forEach((k, v) -> System.out.println("Предмет: " + k + " " + v));
    }
}
