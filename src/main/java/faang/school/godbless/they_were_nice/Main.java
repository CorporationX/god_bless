package faang.school.godbless.they_were_nice;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Chore> tasks = List.of(
                new Chore("task_1"),
                new Chore("task_2"),
                new Chore("task_3"),
                new Chore("task_4"),
                new Chore("task_5"),
                new Chore("task_6")
        );
        for (Chore task : tasks) {
            executorService.execute(task);
        }
        executorService.shutdown();
    }
}