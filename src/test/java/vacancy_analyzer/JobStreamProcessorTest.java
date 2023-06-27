package vacancy_analyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobStreamProcessorTest {
    private JobStreamProcessor jobStreamProcessor;

    @BeforeEach
    void setUp() {
        jobStreamProcessor = new JobStreamProcessor();
    }

    @Test
    void transformJsonsToJobs() {
        Job job1 = new Job("junior java developer", List.of("Написание кода", "Тестирование кода",
                "Исправление ошибок", "Проверка кода", "Оптимизация кода",
                "Поддержка кода"),
                100_000, "Москва", LocalDate.now()
        );
        Job job2 = new Job("Senior java developer", List.of("Написание кода", "Тестирование кода",
                "Исправление ошибок", "Проверка кода", "Оптимизация кода",
                "Поддержка кода"),
                250_000, "Москва", LocalDate.now()
        );

        List<Job> expected = new ArrayList<>();
        expected.add(job1);
        expected.add(job2);

        List<String> jsonJobs = List.of(
                "{\"position\":\"junior java developer\",\"skills\":[\"Написание кода\",\"Тестирование кода\",\"Исправление ошибок\",\"Проверка кода\",\"Оптимизация кода\",\"Поддержка кода\"],\"salary\":100000,\"location\":\"Москва\",\"date\":\"25-06-2023\"}",
                "{\"position\":\"Senior java developer\",\"skills\":[\"Написание кода\",\"Тестирование кода\",\"Исправление ошибок\",\"Проверка кода\",\"Оптимизация кода\",\"Поддержка кода\"],\"salary\":250000,\"location\":\"Москва\",\"date\":\"25-06-2023\"}"
        );

        List<Job> actual = jobStreamProcessor.transformJsonsToJobs(jsonJobs);

        assertEquals(expected, actual);
    }
}