package faang.school.godbless.concur3;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int MINIMUM_PARTICIPANTS_FOR_START = 5;
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        Conference conference = new Conference(MINIMUM_PARTICIPANTS_FOR_START);
        List<Participant> participants = getParticipants();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        participants.forEach(participant -> executor.execute(participant::joinConference));
        executor.shutdown();
    }

    private static List<Participant> getParticipants() {
        return List.of(
                new Participant("Oleg"),
                new Participant("Semen"),
                new Participant("Max"),
                new Participant("Dmitry"),
                new Participant("Misha"));
    }
}
