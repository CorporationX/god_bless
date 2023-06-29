package faang.school.godbless.sprint3.streamAPI.task4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;

public class JobScraper {

    private final ObjectMapper objectMapper;

    public JobScraper() {
        this.objectMapper = new ObjectMapper();
    }

    public Job transformJsonToJob(String json) {
        try {
            return objectMapper.readValue(json, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String transformJobToJson(Job job) {
        try {
            return objectMapper.writeValueAsString(job);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Job job = new Job("Senior java developer", List.of("Написание кода", "Тестирование кода",
                "Исправление ошибок", "Проверка кода", "Оптимизация кода",
                "Поддержка кода"),
                250_000, "Москва", LocalDate.now()
        );
        JobScraper jobScraper = new JobScraper();

        String json = jobScraper.transformJobToJson(job);
        System.out.println(json);

        Job job1 = jobScraper.transformJsonToJob(json);
        System.out.println(job1);
    }
}
