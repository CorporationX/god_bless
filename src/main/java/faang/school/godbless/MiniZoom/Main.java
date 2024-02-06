package faang.school.godbless.MiniZoom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Conference conference = new Conference("Planing");

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i < conference.getNUMBER_OF_PARTICIPANTS() + 1; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Ошибка подключения");;
            }
            int finalI = i;
            executor.submit(() -> {
                Participant participant = new Participant("User" + finalI);
                participant.joinConference(conference);
            });
        }
        executor.shutdown();
        executor.awaitTermination(20, TimeUnit.SECONDS);

        conference.startStreaming();
    }
}
