package school.faang.sprint_3.task_48725;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<String> chores = List.of(
                "помыть посуду",
                "подмести пол",
                "подмести пол",
                "подмести пол",
                "подмести пол",
                "приготовить ужин"
        );

        ExecutorService executor = Executors.newCachedThreadPool();

        chores.stream()
                .map(Chore::new)
                .forEach(executor::submit);
        executor.shutdown();
    }
}


