package faang.school.godbless.multithreading_2.zoom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        final int amountParticipant = 10;
        Conference conference = new Conference("Конференция", amountParticipant);

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < amountParticipant; i++) {
            final int num = i;
            futures.add(
                CompletableFuture.runAsync(() -> new Participant("Участник_" + num).joinConference(conference))
            );
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(conference::startStreaming)
                .join();

        conference.showParticipants();
    }
}
