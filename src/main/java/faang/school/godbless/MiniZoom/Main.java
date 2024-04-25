package faang.school.godbless.MiniZoom;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_USERS_TO_START = 10;
    private static final int NUM_USERS = 10;
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        Conference conference = new Conference("System design", NUM_USERS_TO_START);
        List<Participant> participants = getParticipants();
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        participants.forEach(participant -> pool.execute(() -> participant.joinConference(conference)));
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
        log.info("conference participants -> {}", conference.getParticipants().size());
        log.info("conference isStarted -> {}", conference.isStarted());
    }

    private static List<Participant> getParticipants() {
        List<Participant> participants = new ArrayList<>();
        for (int i = 1; i <= NUM_USERS; i++) {
            participants.add(new Participant("ID:" + i));
        }
        return participants;
    }
}
