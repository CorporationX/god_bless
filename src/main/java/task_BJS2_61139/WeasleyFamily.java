package task_BJS2_61139;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Arrays.stream(CHORES).forEach(chore -> executor.execute(new Chore(chore)));
        executor.shutdown();
    }
}
