package school.faang.bjs2_90002;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class WeasleyFamily {
    static long WAITING_TIME = 3;
    private static final String[] chores = {
            "Решить эту задачу.",
            "Решить еще 3 задачи по этой теме.",
            "Изучить Synchronized.",
            "Решить не менее 4 задач по Synchronized."
    };

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String task : chores) {
            executor.execute(new Chore(task));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(WAITING_TIME, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Поток main не смог должаться окончания, он был прерван.");
        }
    }
}
