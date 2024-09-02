package mini.zoom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference();
        Participant participant1 = new Participant("Сашка");
        Participant participant2 = new Participant("Мишка");
        Participant participant3 = new Participant("Аннушка");
        Participant participant4 = new Participant("Викуся");

        ExecutorService executorService = Executors.newFixedThreadPool(Conference.MEMBERS);

        executorService.execute(() -> participant1.joinConference(conference));
        executorService.execute(() -> participant2.joinConference(conference));
        executorService.execute(() -> participant3.joinConference(conference));
        executorService.execute(() -> participant4.joinConference(conference));

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
