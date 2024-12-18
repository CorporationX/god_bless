package school.faang.task_48307;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<String> tasks = List.of(
                "помыть посуду",
                "подмести пол",
                "приготовить ужин"
        );

        tasks.forEach(task -> executor.submit(new Chore(task)));

        executor.shutdown();
    }
}
