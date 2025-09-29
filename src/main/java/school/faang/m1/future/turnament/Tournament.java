package school.faang.m1.future.turnament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            return school;
        }, exec);
    }

    @Override
    public void close() {
        exec.shutdown();
    }
}
