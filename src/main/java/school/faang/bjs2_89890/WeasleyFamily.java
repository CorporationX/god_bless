package school.faang.bjs2_89890;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Chore[] chores = new Chore[]{
                new Chore("Помыть посуду"),
                new Chore("Подмести пол"),
                new Chore("Приготовить ужин"),
                new Chore("Полить цветы"),
                new Chore("Покормить сову")
        };
        for (Chore chore : chores) {
            executorService.submit(chore);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи успели завершиться!");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван!");
            executorService.shutdownNow();
        }
    }
}
