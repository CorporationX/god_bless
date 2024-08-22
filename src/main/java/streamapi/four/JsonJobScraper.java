package streamapi.four;

import lombok.SneakyThrows;

public class JsonJobScraper extends JobScraper {

    @SneakyThrows
    @Override
    public Job parse(String json) {
        return objectMap.readValue(json, Job.class);
    }
}
