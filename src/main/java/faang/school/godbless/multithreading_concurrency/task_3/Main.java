package faang.school.godbless.multithreading_concurrency.task_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(Conference.getNUMBER_OF_MEMBERS());
        Conference conference = new Conference();
        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i < Conference.getNUMBER_OF_MEMBERS(); i++) {
            participants.add(new Participant(String.format("Participant: %s", i), Conference.getBARRIER()));
        }
        participants.forEach(participant -> executor.submit(participant::joinConference));
        conference.startStreaming();
        executor.shutdown();
    }
}
