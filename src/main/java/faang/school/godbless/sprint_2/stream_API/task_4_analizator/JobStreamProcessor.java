package faang.school.godbless.sprint_2.stream_API.task_4_analizator;

import faang.school.godbless.sprint_2.stream_API.task_4_analizator.models.Job;
import faang.school.godbless.sprint_2.stream_API.task_4_analizator.scrappers.JsonJobScrapper;

import java.util.List;
import java.util.stream.Stream;


public class JobStreamProcessor {
    private final JsonJobScrapper scrapper = new JsonJobScrapper();

    /**
     * Метод создаёт список Job из строк в json формате
     * @param stream
     * @return
     */
    public List<Job> process(Stream<String> stream){
        return stream.map(scrapper::parse)
                .peek(System.out::println)
                .toList();
    }
}
