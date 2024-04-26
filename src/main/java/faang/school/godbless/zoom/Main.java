package faang.school.godbless.zoom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        Conference conference = new Conference("Java", 3);

        List<Participant> participants = List.of(
                new Participant("Maxim1"),
                new Participant("Nikita1"),
                new Participant("Olga1"),
                new Participant("Maxim2"),
                new Participant("Nikita2"),
                new Participant("Olga2")
        );

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        participants.forEach(member -> {
            futures.add(CompletableFuture.runAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
                    member.joinConference(conference);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        });

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();
    }
}
