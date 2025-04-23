package school.faang.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        Player player = new Player();
        service.submit(() -> {
            try {
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                player.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                player.previous();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                player.skip();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Еще есть задачи ожидающие выполнения");
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
