package AnalyzatorVakansiy;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Map;


public class JobScraper {
    private final ObjectMapper objectMapper;

    public JobScraper() {
        this.objectMapper = new ObjectMapper();
    }

    public Job parseJson(String json) {
        try {
            Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);

            String position = (String) jsonMap.get("position");

            // Обработка списка требований
            List<String> candidateRequirements;
            Object requirementsObj = jsonMap.get("candidateRequirements");
            if (requirementsObj instanceof String) {
                candidateRequirements = Arrays.asList(((String) requirementsObj).split(","));
                // Для строки и листа разные обработчики
            } else if (requirementsObj instanceof List) {
                candidateRequirements = ((List<?>) requirementsObj).stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList());
            } else {
                // Если формат неожиданный, принимаем решение, что это пустой список
                candidateRequirements = new ArrayList<>();
            }

            // Обработка зарплаты
            Number salaryObj = (Number) jsonMap.get("salary");
            double salary = salaryObj.doubleValue();

            String location = (String) jsonMap.get("location");
            LocalDateTime vacancyDateTime = LocalDateTime.parse((CharSequence) jsonMap.get("vacancyDate"));
            LocalDate vacancyDate = vacancyDateTime.toLocalDate();

            return new Job(position, candidateRequirements, salary, location, vacancyDate);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}