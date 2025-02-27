package school.faang.task_62390;


import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            return school;
        });

    }
}
