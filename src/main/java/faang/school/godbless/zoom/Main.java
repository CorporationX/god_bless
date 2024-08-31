package faang.school.godbless.zoom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Participant participant1 = new Participant("1");
        Participant participant2 = new Participant("2");

        Conference conference = new Conference();

        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(() -> conference.joinConf(participant1));

        Thread.sleep(3_000);

        service.execute(() -> conference.joinConf(participant2));

        service.shutdown();
        try {
            if (service.awaitTermination(1_000, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }

    }
}
