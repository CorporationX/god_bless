package faang.school.godbless.task_4_analizator.scrappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import faang.school.godbless.task_4_analizator.models.Job;

public interface JobScrapper {
    Job parse(String data) throws JsonProcessingException;
}
