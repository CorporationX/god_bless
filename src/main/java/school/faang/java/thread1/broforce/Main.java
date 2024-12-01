package school.faang.java.thread1.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Game game = new Game();
        for (int i=0; i < 10 ; i++){
            User user = new User("User"+i);
            Runnable runnable = () -> {
                boolean earnedPoints = Math.random() > 0.5; // 50% шанс заработать очки
                boolean lostLife = Math.random() > 0.7;
                while (game.update(earnedPoints, lostLife, user, executorService)) {
                    earnedPoints = Math.random() > 0.5; // 50% шанс заработать очки
                    lostLife = Math.random() > 0.7;
                }
            };
            executorService.submit(runnable);

        }
        executorService.shutdown();
    }
}