package school.faang.task_61288;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<String> scientists = List.of("Sheldon", "Leonard", "Howard", "Rajesh");
        List<String> tasks = List.of(
                "preparation of theory", "modeling of experiment",
                "development of tools", "data analysis");

        for (int i = 0; i < tasks.size(); i++) {
            Task task = new Task(scientists.get(i), tasks.get(i));
            executorService.execute(task);
        }
        executorService.shutdown();
    }
}
