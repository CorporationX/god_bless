package school.faang.bjs2_73192;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {

    public static void main(String[] args) {
        Player player = new Player();

        Runnable play = player::play;
        Runnable pause = player::pause;
        Runnable skip = player::skip;
        Runnable previous = player::previous;

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(play);
        executor.execute(pause);
        executor.execute(skip);
        executor.execute(previous);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
