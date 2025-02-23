package school.faang.task_60781;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final List<String> CHORES = new ArrayList<>(
            List.of("помыть посуду", "подмести пол", "приготовить ужин")
    );
    private static final int TERMINATION_AWAIT_TIME = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CHORES.forEach(chore -> executor.execute(new Chore(chore)));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_AWAIT_TIME, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершились за отведённое время");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Основной поток был прерван");
        }
    }
}
