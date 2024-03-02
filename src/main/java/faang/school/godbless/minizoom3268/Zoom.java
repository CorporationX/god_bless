package faang.school.godbless.minizoom3268;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Zoom {
    static final List<Participant> PARTICIPANTS = new ArrayList<>();

    public static void main(String[] args) {
        createParticipants();
        Conference conference = new Conference(PARTICIPANTS.size());
        ExecutorService executor = Executors.newFixedThreadPool(PARTICIPANTS.size());
        List<CompletableFuture<Void>> futureViewersJoined = new ArrayList<>();

        PARTICIPANTS.forEach(participant -> futureViewersJoined.add(CompletableFuture.runAsync(() ->
                participant.joinConference(conference), executor)));
        CompletableFuture.allOf(futureViewersJoined.toArray(CompletableFuture[]::new))
                .thenRun(conference::startStreaming);

        executor.shutdown();
    }

    private static void createParticipants() {
        for (int i = 0; i < 30; i++) {
            PARTICIPANTS.add(new Participant());
        }
    }
}
