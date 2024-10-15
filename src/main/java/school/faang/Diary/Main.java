package school.faang.Diary;

import java.io.IOException;
import java.util.List;

import static school.faang.Diary.StudentService.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "students.json";
        List<Student> students;

        try {
            students = loadStudentsFromJson(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Средние оценки по предметам:");
        System.out.println(getAverageGradesBySubject(students));
        System.out.println("\nИтоговые оценки Олега Сидорова:");
        System.out.println(getFinalGrades(students, "Олег Сидоров"));
        System.out.println("\nСамый сложный предмет:");
        System.out.println(getMostDifficultSubject(students));
    }
}
