package faang.school.godbless.modul4.wizards;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService service = Executors.newCachedThreadPool(Thread::new);

        var schoolAfterFinishedTask = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam()
                    .forEach((student ->
                            student.setPoints(student.getPoints() + task.getReward())
                    ));
            return school;
        });

        service.shutdown();
        return schoolAfterFinishedTask;
    }
}
