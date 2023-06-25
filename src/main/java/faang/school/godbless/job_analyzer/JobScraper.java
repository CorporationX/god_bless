package faang.school.godbless.job_analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JobScraper<T> {
    private final ObjectMapper objectMapper;
    private final Class<T> targetClass;

    public JobScraper(Class<T> targetClass) {
        this.targetClass = targetClass;
        this.objectMapper = new ObjectMapper();
    }

    public T parse(String json) {
        try {
            return objectMapper.readValue(json, targetClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
