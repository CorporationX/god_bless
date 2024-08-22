package faang.school.godbless.task24226;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"task 1", "task 2", "task 3", "task 4", "task 5"};

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String task : chores) {
            executorService.execute(new Chore(task));
        }
        executorService.shutdown();
    }
}
