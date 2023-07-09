package faang.school.godbless;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private ExecutorService executor;

    public Tournament() {
        executor = Executors.newCachedThreadPool();
    }

    public CompletableFuture<School> startTask(School school, Task task){
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            for(Student student : school.getTeam()){
                performTask(student, task);
            }
            return school;
        }, executor);
        return future;
    }

    private void performTask(Student student, Task task) {
        try {
            Thread.sleep(task.getDifficulty() * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        student.addPoints(task.getReward());
    }

}
