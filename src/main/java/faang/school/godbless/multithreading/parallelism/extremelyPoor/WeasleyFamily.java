package faang.school.godbless.multithreading.parallelism.extremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"task-1", "task-2", "task-3", "task-4", "task-5", "task-6", "task-7"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String str : chores) {
            executorService.execute(new Chore(str));
        }

        executorService.shutdown();
    }
}
