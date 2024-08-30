package faang.school.godbless.MiniZoom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        CyclicBarrier barrier = new CyclicBarrier(6);
        Conference conference = new Conference("cool", 5, barrier);
        List<Participant> participants = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            participants.add(new Participant(Integer.toString(i), barrier));
        }

        executorService.execute(conference::startStream);

        for (Participant participant : participants) {
            executorService.execute(() -> {
                participant.joinConference(conference);
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
