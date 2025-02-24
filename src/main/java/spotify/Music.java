package spotify;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Music {
    public static void main(String[] args) {
        List<String> playlist = List.of(
                "Brandy Kills - Space Police",
                "Editors - Sugar",
                "New Order - Crystal",
                "Brand New - At the Bottom",
                "Kill Shelter - Bodies"
        );

        Player player = new Player(playlist);

        List<Thread> threads = List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::previous),
                new Thread(player::skip)
        );

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Thread was interrupted: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
