package school.faang.task427;

import school.faang.task427.conference.Conference;
import school.faang.task427.participant.Participant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int PARTICIPANT_COUNT = 10;

    public static void main(String[] args) {
        Conference conference = new Conference(PARTICIPANT_COUNT);
        ExecutorService service = Executors.newFixedThreadPool(PARTICIPANT_COUNT);


        for (int i = 0; i < PARTICIPANT_COUNT; i++) {
            service.submit(new Participant(conference));
        }

        service.shutdown();
        try {
            if (service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Ошибка конференции, сворачиваемся");
                service.isShutdown();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getStackTrace().toString());
        }

    }
}
