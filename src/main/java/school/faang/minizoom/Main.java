package school.faang.minizoom;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private final static int COUNT_PARTICIPANT = 10;
    private final static int MAX_TIME_WORK = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_PARTICIPANT);
        Conference conference = new Conference(COUNT_PARTICIPANT);

        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i < COUNT_PARTICIPANT; i++) {
            participants.add(new Participant("Member " + i, conference));
        }

        for (Participant participant : participants) {
            executor.submit(participant::joinConference);
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(MAX_TIME_WORK, TimeUnit.SECONDS)) {
                log.info("Программа завершена");
            } else {
                log.warn("Программа завершена принудительно");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван " + e.getMessage());
        }
    }
}