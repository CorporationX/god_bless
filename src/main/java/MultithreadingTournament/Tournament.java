package MultithreadingTournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Student s : school.getStudents()) {
                s.addReward(task.getReward());
            }
            return school;
        });
    }
}
