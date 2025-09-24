package school.faang.module3.spotify;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Music {

    public static void main(String[] args) {
        Player player = new Player();
        List<Runnable> runnableList = List.of(player::play, player::pause, player::previous, player::skip);
        List<Thread> threads = new ArrayList<>();

        for (Runnable runnable : runnableList) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("InterruptedException", e);
            }
        });
    }
}
