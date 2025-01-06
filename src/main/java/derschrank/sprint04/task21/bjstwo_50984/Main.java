package derschrank.sprint04.task21.bjstwo_50984;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final int REQUIRED_PARTICIPANTS = 10;
    private static final int SIZE_OF_THREADPOOL = 10;
    private static final ExecutorService executor = Executors.newFixedThreadPool(SIZE_OF_THREADPOOL);

    public static void main(String[] args) {
        Conference conference = new Conference(REQUIRED_PARTICIPANTS);
        List<Future<?>> futures = new LinkedList<>();

        for (int i = 0; i < REQUIRED_PARTICIPANTS * 3; i++) {
            final int id = i;
            futures.add(
                    executor.submit(() -> {
                        Participant p = new Participant("Teilnehmer #" + id);
                        p.joinConference(conference);
                    })
            );
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Main was interrupted: " + e);
            }
        }
        executor.shutdownNow();
        System.out.println("END");
    }
}
