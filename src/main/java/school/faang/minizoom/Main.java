package school.faang.minizoom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int PARTICIPANT_COUNT = 5;

    public static void main(String[] args) {
        Conference conference = new Conference(PARTICIPANT_COUNT);

        ExecutorService executorService = Executors.newFixedThreadPool(PARTICIPANT_COUNT);

        for (int i = 1; i <= PARTICIPANT_COUNT; i++) {
            Participant participant = new Participant(conference, "Participant " + i);
            executorService.submit(participant);
        }

        executorService.shutdown();
    }
}

