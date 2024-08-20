package faang.school.godbless.BJS2_22788;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class JobScraper {
    public abstract Job parse(String data) throws JsonProcessingException;
}
