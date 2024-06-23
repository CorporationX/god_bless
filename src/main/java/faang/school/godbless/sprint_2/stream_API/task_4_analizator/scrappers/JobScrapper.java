package faang.school.godbless.sprint_2.stream_API.task_4_analizator.scrappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import faang.school.godbless.sprint_2.stream_API.task_4_analizator.models.Job;

public interface JobScrapper {
    Job parse(String data) throws JsonProcessingException;
}
