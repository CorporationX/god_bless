package faang.school.godbless.the.big.bang.theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Task> tasks = List.of(
                new Task("Sheldon", "theory preparation"),
                new Task("Leonard", "experiment simulation"),
                new Task("Howard", "tool development"),
                new Task("Rajesh", "data analysis")
        );

        for (Task task : tasks) {
            executorService.submit(task);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Задания еще выполняются");
            } else {
                System.out.println("Все задания сделаны");
            }
        } catch (InterruptedException ex) {
            throw new RuntimeException();
        }
    }
}
