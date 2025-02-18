package school.faang.sprint3.task_60800;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        Arrays.stream(CHORES).forEach(chore -> EXECUTOR.submit(new Chore(chore)));
        EXECUTOR.shutdown();
        sleep();
        System.out.printf("%d задачи из %d выполнены", Chore.count - 1, CHORES.length);
    }

    private static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
