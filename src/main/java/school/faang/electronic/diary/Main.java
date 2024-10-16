package school.faang.electronic.diary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final String PATH_TO_FILE = "src/main/resources/students_test_data.json";

    public static void main(String[] args) throws IOException {
        File jsonFile = new File(PATH_TO_FILE);
        ObjectMapper objectMapper = new ObjectMapper();
        PerformanceAnalysisService perfAnalyzer = new PerformanceAnalysisService();
        List<Student> students = objectMapper.readValue(jsonFile, new TypeReference<>() {
        });
        System.out.println("Отчет об успеваемости: ");
        perfAnalyzer.printPerformanceTable(students);

        System.out.println("Средняя оценка по каждому предмету: ");
        System.out.println(perfAnalyzer.averageMarkBySubject(students));

        System.out.println("Итоговые оценки по всем предметам Олега Сидорова: ");
        System.out.println(perfAnalyzer.finalMarkBySubject(students,
                "Олег", "Сидоров"));

        System.out.println("Самый сложный предмет: " + perfAnalyzer.findMostDifficultSubject(students));
    }
}
