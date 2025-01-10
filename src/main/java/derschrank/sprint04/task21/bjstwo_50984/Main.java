package derschrank.sprint04.task21.bjstwo_50984;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TIME_OUT_FOR_AWAIT_SEC = 10;
    private static final int REQUIRED_PARTICIPANTS = 10;
    private static final int SIZE_OF_THREADPOOL = 10;
    private static final ExecutorService executor = Executors.newFixedThreadPool(SIZE_OF_THREADPOOL);

    public static void main(String[] args) {
        Conference conference = new Conference(REQUIRED_PARTICIPANTS);

        for (int i = 0; i < REQUIRED_PARTICIPANTS * 3; i++) {
            final int id = i;
            executor.submit(() -> {
                Participant p = new Participant("Teilnehmer #" + id);
                p.joinConference(conference);
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(TIME_OUT_FOR_AWAIT_SEC, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Main was interrupted: " + e);
        }
        System.out.println("END");
    }
}
