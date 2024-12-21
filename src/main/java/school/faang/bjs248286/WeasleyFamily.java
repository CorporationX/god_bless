package school.faang.bjs248286;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final List<String> tasks = List.of("помыть посуду", "подмести пол", "приготовить ужин", "станцевать");

    public static void main(String[] args) {
        ExecutorService executors = Executors.newCachedThreadPool();
        tasks.forEach(task -> {
            Chore chore = new Chore(task);
            executors.execute(chore);
        });
        executors.shutdown();
        try {
            if (!executors.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Executors processing...");
            }
        } catch (InterruptedException e) {
            System.out.println("Process crashed: " + e.getMessage());
            executors.shutdownNow();
        }
        System.out.println("Main thread complete");
    }
}
