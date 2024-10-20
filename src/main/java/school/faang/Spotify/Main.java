package school.faang.Spotify;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(player::play));
        threads.add(new Thread(player::pause));
        threads.add(new Thread(player::play));
        threads.add(new Thread(player::previous));
        threads.add(new Thread(player::skip));

        threads.forEach(Thread::start);

        threads.forEach(e -> {
            try {
                e.join();
            } catch (InterruptedException ex) {
                throw new IllegalStateException("Thread interrupted", ex);
            }
        });
    }
}
