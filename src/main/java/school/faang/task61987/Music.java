package school.faang.task61987;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous)
        );

        threads.forEach(Thread::start);

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error threads join", e);
        }
    }
}
