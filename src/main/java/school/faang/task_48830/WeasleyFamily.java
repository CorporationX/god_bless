package school.faang.task_48830;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> chores = List.of(
                new Chore("Wash the dishes"),
                new Chore("Sweep the floor"),
                new Chore("Cook dinner"),
                new Chore("Clean the windows"),
                new Chore("Take out the trash")
        );

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executorService.submit(chore);
        }

        executorService.shutdown();
    }
}
