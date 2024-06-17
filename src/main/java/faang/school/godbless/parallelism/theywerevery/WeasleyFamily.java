package faang.school.godbless.parallelism.theywerevery;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "task1",
                "task2",
                "task3"
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }

        executorService.shutdown();
        System.out.println("Конец основного потока");
    }
}
