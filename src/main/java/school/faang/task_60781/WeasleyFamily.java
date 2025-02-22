package school.faang.task_60781;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final List<String> chores = new ArrayList<>(
            List.of("помыть посуду", "подмести пол", "приготовить ужин")
    );

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        chores.forEach(chore -> executor.execute(new Chore(chore)));

        executor.shutdown();
    }
}
