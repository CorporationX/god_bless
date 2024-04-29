package faang.school.godbless.minizoom;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Conference conference = new Conference("Daily");

        List<Participant> participants = List.of(
                new Participant("Vasya"),
                new Participant("Petya"),
                new Participant("Katya"),
                new Participant("Andrey"),
                new Participant("Dima")
        );

        participants.forEach(member -> executorService
                .execute(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
                        member.joinConference(conference);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }));

        executorService.shutdown();
    }
}
