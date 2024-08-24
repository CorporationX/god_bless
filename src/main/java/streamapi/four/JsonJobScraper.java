package streamapi.four;

import lombok.SneakyThrows;

public class JsonJobScraper extends JobScraper {

    @SneakyThrows
    @Override
    public Job parse(String json) {

        if (json == null || json.isEmpty()) {
            throw new IllegalArgumentException("Json не может быть пустым");
        }

        return objectMap.readValue(json, Job.class);
    }
}
