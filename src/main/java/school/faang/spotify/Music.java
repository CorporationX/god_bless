package school.faang.spotify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(() -> player.play()));
        }

        threads.add(new Thread(() -> player.pause()));
        threads.add(new Thread(() -> player.skip()));
        threads.add(new Thread(() -> player.previous()));

        Collections.shuffle(threads);

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
