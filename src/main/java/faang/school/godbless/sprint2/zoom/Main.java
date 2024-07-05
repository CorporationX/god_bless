package faang.school.godbless.sprint2.zoom;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {

    private static final int REQUIRED_PARTICIPANTS = 10;
    private static final int POOL_SIZE = 8;

    public static void main(String[] args) {
        Conference conference = new Conference(REQUIRED_PARTICIPANTS);
        ExecutorService executors = Executors.newFixedThreadPool(POOL_SIZE);

        for (int i = 0; i < REQUIRED_PARTICIPANTS; i++) {
            final int number = i;
            Participant participant = new Participant(conference);
            executors.submit(() -> participant.joinConference(number));
        }
        executors.shutdown();

        try {
            log.info("Ожидаем участников...");
            conference.getLatch().await();
            conference.startStreaming();
        } catch (InterruptedException e) {
            log.error("Ошибка выполнения потока ", e);
        }

        try {
            if (!executors.awaitTermination(20, TimeUnit.SECONDS)) {
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            executors.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
