package school.faang.spotify;

import java.util.List;


public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        List<Thread> threads = List.of(
                new Thread(player::skip, "Skip"),
                new Thread(player::previous, "Previous"),
                new Thread(player::play, "Play"),
                new Thread(player::pause, "Pause")
        );

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }
    }
}