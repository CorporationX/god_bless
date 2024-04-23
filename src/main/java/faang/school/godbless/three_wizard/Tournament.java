package faang.school.godbless.three_wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

        CompletableFuture<School> futureSchool = CompletableFuture.supplyAsync(() -> {
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            ExecutorService executor = Executors.newFixedThreadPool(school.getTeam().size());
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student -> {
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> student.solveTask(task), executor);
                futures.add(future);
            });

            executor.shutdown();
            try {
                while (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                    System.out.println("bad");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
            return school;
        }, newSingleThreadExecutor);

        newSingleThreadExecutor.shutdown();
        try {
            while (!newSingleThreadExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("bad");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return futureSchool;
    }
}
