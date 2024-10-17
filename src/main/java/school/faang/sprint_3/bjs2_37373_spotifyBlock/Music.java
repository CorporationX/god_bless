package school.faang.sprint_3.bjs2_37373_spotifyBlock;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
            e.printStackTrace();
            throw new RuntimeException("Текущий поток был прерван во время ожидания завершения другого потока", e);
        }
    }
}