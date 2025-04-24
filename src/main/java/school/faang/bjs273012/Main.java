package school.faang.bjs273012;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : WeasleyFamily.getChores()) {
            executor.execute(new Chore(task));
        }
        executor.shutdown();

        try {
            boolean allTasksCompleted = executor.awaitTermination(10, TimeUnit.SECONDS);

            if (allTasksCompleted) {
                System.out.println("Все задания выполнены");
            } else {
                System.out.println("Не все задания выполнены");
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка");
            executor.shutdownNow();
        }
    }
}
