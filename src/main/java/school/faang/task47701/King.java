package school.faang.task47701;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Джеймс  ");
        Knight knight2 = new Knight("Лорес   ");


        knight1.addTrail(new Trail(knight1.getName(), " Сражение с драконом "));
        knight1.addTrail(new Trail(knight1.getName(), " Поединок с Макгрегором "));
        knight2.addTrail(new Trail(knight2.getName(), " Бой с Тайсоном "));
        knight2.addTrail(new Trail(knight2.getName(), " Битва за честь "));

        ExecutorService executorService = Executors.newFixedThreadPool(2);


        knight1.startTrails(executorService);
        knight2.startTrails(executorService);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executorService.shutdownNow();
        }
    }
}
