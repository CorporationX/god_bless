package electronic_diary;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        List<Student> students = jsonReader.readStudentsFromJson("/students_test_data.json");

        if (students == null) {
            System.out.println("Error reading json file");
            return;
        }

        System.out.println("Средние оценки по предметам: " + School.averageGrades(students));
        System.out.println("Итоговые оценки Олега Сидорова: " + School.finalGrades(students, "Олег", "Сидоров"));
        System.out.println("Самый сложный предмет: " + School.hardestSubject(students));
        School.printPerformanceTable(students);
    }
}
