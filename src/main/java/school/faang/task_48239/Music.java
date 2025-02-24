package school.faang.task_48239;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Player player = new Player();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int action = random.nextInt(4);
            executorService.submit(() -> {
                switch (action) {
                  case 0 -> player.play();
                  case 1 -> player.pause();
                  case 2 -> player.skip();
                  case 3 -> player.previous();
                  default -> throw new IllegalArgumentException("Something went wrong in testing!");
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                }
            });
        }

        executorService.shutdown();
    }
}