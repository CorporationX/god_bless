package faang.school.godbless.multi_con.task3zoom;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        int participantCount = 10;
        Conference conference = new Conference(participantCount);

        CompletableFuture<Void>[] futures = new CompletableFuture[participantCount];
        for (int i = 0; i < participantCount; i++) {
            int finalI = i;
            futures[i] = CompletableFuture.runAsync(() ->
                    new Participant("Участник " + finalI).joinConference(conference));
        }

        CompletableFuture.allOf(futures).join();
    }
}
