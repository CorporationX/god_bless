package faang.school.godbless.BJS2_1580;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) {
        Conference conference = new Conference("FAANG SCHOOL"); // Например, необходимо 5 участников для начала трансляции

        Participant participant1 = new Participant(conference, "Eda");
        Participant participant2 = new Participant(conference, "Vlad");
        Participant participant3 = new Participant(conference, "Inna");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        CompletableFuture.allOf(
                CompletableFuture.runAsync(conference, executor),
                CompletableFuture.runAsync(participant1::joinConference, executor),
                CompletableFuture.runAsync(participant2::joinConference, executor),
                CompletableFuture.runAsync(participant3::joinConference, executor)
        ).join();

        executor.shutdown();
    }
}