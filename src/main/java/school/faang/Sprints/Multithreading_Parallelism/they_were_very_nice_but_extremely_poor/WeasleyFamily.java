package school.faang.Sprints.Multithreading_Parallelism.they_were_very_nice_but_extremely_poor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        List<String> chores = List.of(
                "помыть посуду",
                "подмести пол",
                "приготовить ужин"
        );
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < chores.size(); i++) {
            int choreI = i;
            executor.submit(() -> {
                new Chore(chores.get(choreI)).run();
            });
        }
        executor.shutdown();
    }
}