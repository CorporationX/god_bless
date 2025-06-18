package school.faang.module1.bjs2_81747;

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
                new Thread(player::previous),
                new Thread(player::play),
                new Thread(player::pause)
        );
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток был прерван", e);
            }
        }
    }
}