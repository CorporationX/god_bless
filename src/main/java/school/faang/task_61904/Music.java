package school.faang.task_61904;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Music {

    public static void main(String[] args) {
        Player player = new Player();

        final List<Thread> threads = new ArrayList<>();

        threads.add(new Thread(player::play));
        threads.add(new Thread(player::pause));
        threads.add(new Thread(player::skip));
        threads.add(new Thread(player::previous));

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван. Причина: {}", e.getMessage());
        }
    }
}
