package school.faang.spotify_block;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Player player = new Player();

        threads.add(new Thread(player::play));
        threads.add(new Thread(player::pause));
        threads.add(new Thread(player::skip));
        threads.add(new Thread(player::previous));

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + thread.getName());
                Thread.currentThread().interrupt();
            }
        });
    }
}
