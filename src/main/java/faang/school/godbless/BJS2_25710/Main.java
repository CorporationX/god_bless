package faang.school.godbless.BJS2_25710;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Participant> participants = getParticipants();
        Conference conference = new Conference(10);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        participants.forEach(participant -> executor.execute(
                () -> conference.joinConference(participant)
        ));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static List<Participant> getParticipants() {
        return List.of(
                new Participant("Participant 1"),
                new Participant("Participant 2"),
                new Participant("Participant 3"),
                new Participant("Participant 4"),
                new Participant("Participant 5"),
                new Participant("Participant 6"),
                new Participant("Participant 7"),
                new Participant("Participant 8"),
                new Participant("Participant 9"),
                new Participant("Participant 10"),
                new Participant("Participant 11"),
                new Participant("Participant 12"),
                new Participant("Participant 13"),
                new Participant("Participant 14"),
                new Participant("Participant 15"),
                new Participant("Participant 16"),
                new Participant("Participant 17"),
                new Participant("Participant 18"),
                new Participant("Participant 19"),
                new Participant("Participant 20"),
                new Participant("Participant 21"),
                new Participant("Participant 22"),
                new Participant("Participant 23"),
                new Participant("Participant 24"),
                new Participant("Participant 25")
        );
    }
}
