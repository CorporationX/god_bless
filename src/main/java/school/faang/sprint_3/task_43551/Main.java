package school.faang.sprint_3.task_43551;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int POOL_SIZE = 2;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        Knight jorah = new Knight("Jorah Mormont");
        Knight jaime = new Knight("Jaime Lannister");

        jorah.addTrial(new Trial(jorah.getName(), "Сражение с драконом"));
        jorah.addTrial(new Trial(jorah.getName(), "Поединок с великаном"));
        jaime.addTrial(new Trial(jaime.getName(), "Испытание верности"));
        jaime.addTrial(new Trial(jaime.getName(), "Битва за честь"));

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        jorah.startTrials(executor);
        jaime.startTrials(executor);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за " + TIMEOUT + " минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
