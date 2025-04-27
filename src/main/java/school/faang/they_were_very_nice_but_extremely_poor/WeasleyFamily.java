package school.faang.they_were_very_nice_but_extremely_poor;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин", "выгулять собаку", "постирать белье"};
        ExecutorService executor = Executors.newCachedThreadPool();
        Arrays.stream(chores)
                .forEach(choreName -> {
                    Chore chore = new Chore(choreName);
                    executor.submit(chore); // Добавляем задачу в пул потоков
                });
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.err.println("Не все задачи завершились за 1 минуту!");
                executor.shutdownNow();
            } else {
                System.out.println("Все задачи успешно выполнены!");
            }
        } catch (InterruptedException e) {
            System.err.println("Прерывание при ожидании завершения задач.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}