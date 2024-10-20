package school.BJS2_38902;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            return school;
        });
    }


}
