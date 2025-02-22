package school.faang.bjs2_61728;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = new ArrayList<>();

        threads.add(new Thread(player::play));
        threads.add(new Thread(player::pause));
        threads.add(new Thread(() -> {
            try {
                player.skip();
            } catch (InterruptedException e) {
                log.error("Error skipping track", e);
            }
        }));
        threads.add(new Thread(() -> {
            try {
                player.previous();
            } catch (InterruptedException e) {
                log.error("Error going to previous track", e);
            }
        }));

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Thread interrupted", e);
            }
        }
        log.info("All actions are completed.");
    }
}
