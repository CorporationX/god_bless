package faang.school.godbless.sprint_3.multithreading_parallelism_thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static final String MSG_FINISH = "Работа завешена.";
    public static final String MSG_ERROR = "Работа прервана.";
    public static final int TIME_OUT = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<String> chores = List.of("task_1", "task_2", "task_3", "task_4", "task_5", "task_6",
                "task_7", "task_8", "task_9", "task_10", "task_11", "task_12");

        for (String string : chores) {
            Chore chore = new Chore(string);

            executorService.submit(chore);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(MSG_ERROR);
        }

        System.out.println(MSG_FINISH);
    }
}
