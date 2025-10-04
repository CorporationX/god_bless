package school.faang.m1.future.tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tournament implements AutoCloseable {

    private final ExecutorService exec;

    public Tournament() {
        int threads = Math.max(2, Runtime.getRuntime().availableProcessors() / 2);
        this.exec = Executors.newFixedThreadPool(
                threads,
                r -> {
                    Thread t = new Thread(r, "tournament-exec");
                    t.setDaemon(true);
                    return t;
                }
        );
    }

    CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.getTeam().forEach(student -> student.addPoints(task.reward()));
            return school;
        }, exec);
    }

    @Override
    public void close() {
        exec.shutdown();
        try {
            if (!exec.awaitTermination(5, TimeUnit.SECONDS)) {
                exec.shutdownNow();
            }
        } catch (InterruptedException e) {
            exec.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
