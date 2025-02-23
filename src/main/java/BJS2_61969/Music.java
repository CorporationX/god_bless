package BJS2_61969;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
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
            log.error("Task was interrupted because: {}", e.getMessage());
        }
    }
}
