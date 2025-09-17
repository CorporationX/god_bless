package bjs2_89618;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Список домашних дел
        String[] chores = {
                "помыть посуду",
                "подмести пол",
                "приготовить ужин",
                "почистить камин",
                "накормить сову"
        };

        // Создаём пул потоков
        ExecutorService executor = Executors.newCachedThreadPool();

        // Добавляем задачи в пул
        for (String task : chores) {
            executor.execute(new Chore(task));
        }

        // Завершаем работу пула
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("🎉 Все домашние дела выполнены!");
    }
}