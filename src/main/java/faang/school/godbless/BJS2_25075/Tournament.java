package faang.school.godbless.BJS2_25075;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> updatedPSchool = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getStudents().forEach(student
                    -> student.setPoints(student.getPoints() + task.getReward()));

            return school;
        });

        return updatedPSchool;
    }
}
