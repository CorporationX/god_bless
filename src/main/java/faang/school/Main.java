package faang.school;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Main {
    private static final int NUMBER_OF_PARTICIPANTS = 3;
    private static final CyclicBarrier BARRIER = new CyclicBarrier(NUMBER_OF_PARTICIPANTS);

    public static void main(String[] args) {
        Conference testStream = new Conference(BARRIER);
        var participants = new ArrayList<>(List.of(
                new Participant(testStream),
                new Participant(testStream),
                new Participant(testStream)
        ));
        var threads = participants.stream().map(Thread::new).toList();
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
