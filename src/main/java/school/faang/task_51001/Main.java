package school.faang.task_51001;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_PARTICIPANTS = 5;

    public static void main(String[] args) {
        Conference conference = new Conference(NUM_PARTICIPANTS);
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_PARTICIPANTS);

        IntStream.range(0, NUM_PARTICIPANTS).forEach(num -> {
            Participant participant = new Participant("Participant " + num, conference);
            executorService.execute(participant);
        });

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("All tasks successfully completed");
            } else {
                log.info("Tasks are not completed");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}