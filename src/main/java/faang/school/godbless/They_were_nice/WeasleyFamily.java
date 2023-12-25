package faang.school.godbless.They_were_nice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String... args) {
        String[] chores = {"task1", "task2", "task3", "task4", "task5", "task6"};
        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            for (String task : chores) {
                Chore chore = new Chore(task);
                executor.submit(chore);
            }
            executor.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
