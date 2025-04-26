package school.faang.spotify;

import java.util.List;

public class Music {
    private final Player player = new Player();
    private final List<Thread> threads = List.of(
            new Thread(player::play),
            new Thread(player::pause),
            new Thread(player::skip),
            new Thread(player::previous)
    );

    public void startAll() {
        for (Thread thread : threads) {
            thread.start();
        }
    }
}