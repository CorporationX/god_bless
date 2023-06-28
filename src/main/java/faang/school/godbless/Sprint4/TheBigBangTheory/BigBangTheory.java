package faang.school.godbless.Sprint4.TheBigBangTheory;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(4);
        List<Task> tasks = new LinkedList<>();

        int amountTask = 4;
        for (int i = 0; i < amountTask; i++) {
            int finalI = i;
            tasks.add(new Task("task - " + i, () -> System.out.printf("Task %d is finished\n", finalI)));
            executors.execute(tasks.get(i));
        }

        executors.shutdown();
        executors.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("END");
    }
}
