package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PigThread> pigThreads = List.of(new Pig1Thread(), new Pig2Thread(), new Pig3Thread());
        for (PigThread pigThread : pigThreads) {
            pigThread.start();
        }
        for (PigThread pigThread : pigThreads) {
            try {
                pigThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
