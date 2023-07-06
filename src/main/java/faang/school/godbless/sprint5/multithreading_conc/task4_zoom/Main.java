package faang.school.godbless.sprint5.multithreading_conc.task4_zoom;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Conference conference = new Conference();

        Participant participant1 = new Participant("Иван");
        Participant participant2 = new Participant("Петр");
        Participant participant3 = new Participant("Сергей");
        Participant participant4 = new Participant("Михаил");
        Participant participant5 = new Participant("Алексей");

        List<Participant> participants = Arrays.asList(participant1, participant2, participant3, participant4, participant5);

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (Participant participant : participants) {
            executor.execute(() -> {
                participant.joinConference();
                try {
                    conference.getBarrier().await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
    }
}
