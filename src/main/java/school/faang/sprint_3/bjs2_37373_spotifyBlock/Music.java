package school.faang.sprint_3.bjs2_37373_spotifyBlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        Player player = new Player();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(THREADS_COUNT);

        scheduler.scheduleAtFixedRate(player::play, 0, 4, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(player::pause, 0, 4, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(player::skip, 2, 6, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(player::previous, 2, 8, TimeUnit.SECONDS);
        scheduler.schedule(scheduler::shutdown, 30, TimeUnit.SECONDS);

        try {
            if (!scheduler.awaitTermination(80, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
                System.out.println("Что-то не так, дергаем стоп-кран!");
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван во время ожидания завершения другого потока.");
            throw new RuntimeException(e);
        }
    }
}