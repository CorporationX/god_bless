package zoom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Conference conference = new Conference();
        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            participants.add(new Participant("Name " + i));
        }

        SERVICE.execute(conference::startStreaming);

        participants.forEach((participant -> SERVICE.execute(
                () -> {
                    participant.joinConference(conference);
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        )));

        SERVICE.shutdown();
    }
}
