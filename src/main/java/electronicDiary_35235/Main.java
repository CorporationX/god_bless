package electronicDiary_35235;


public class Main {

    public static void main(String[] args) {

        School school = new School();
        school.addStudentsFromJSON("Z:\\Downloads\\students_test_data.json");
        school.calculateAverageScore(school.getStudents())
                .forEach((k, v) -> System.out.println("Предмет: " + k + " " + v));
    }
}
