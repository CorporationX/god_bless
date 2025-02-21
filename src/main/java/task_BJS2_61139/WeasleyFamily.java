package task_BJS2_61139;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            Arrays.stream(CHORES).forEach(chore -> executor.execute(new Chore(chore)));
        } catch (RejectedExecutionException exception) {
            System.out.println("Очередь пула заполнена");
        }

        executor.shutdown();

        try {
            boolean tasksFinished = executor.awaitTermination(3, TimeUnit.SECONDS);
            if (tasksFinished) {
                System.out.println("Все задачи завершены в течение времени ожидания.");
            } else {
                System.out.println("Таймаут истек до завершения всех задач.");
            }
        } catch (InterruptedException exception) {
            System.out.println("Await terminate прервано.");
            Thread.currentThread().interrupt();
        }
    }
}
