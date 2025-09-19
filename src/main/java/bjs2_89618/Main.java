package bjs2_89618;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String[] CHORES = {
            "помыть посуду",
            "подмести пол",
            "приготовить ужин",
            "почистить камин",
            "накормить сову"
    };
    private static final int TIMEOUT = 1;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : CHORES) {
            executor.execute(new Chore(task));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("🎉 Все домашние дела выполнены!");
    }
}