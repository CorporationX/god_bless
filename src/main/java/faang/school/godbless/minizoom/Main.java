package faang.school.godbless.minizoom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Conference conference = new Conference();
        List<Participant> participants = getParticipants();

        participants.forEach(participant -> executorService.execute(() -> {
            participant.joinConference();
            awaitBarrier(conference.getCyclicBarrier());
        }));

        executorService.shutdown();
        awaitTermination(executorService, 5);
    }

    private static List<Participant> getParticipants() {
        List<Participant> participants = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            participants.add(new Participant(String.format("Participant %d", i)));
        }
        return participants;
    }

    private static void awaitBarrier(CyclicBarrier cyclicBarrier) {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    private static void awaitTermination(ExecutorService executorService, int minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
