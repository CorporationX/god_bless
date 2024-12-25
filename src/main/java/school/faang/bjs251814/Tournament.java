package school.faang.bjs251814;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            school.getTeam()
                    .forEach(s -> s.addPoints(task.getReward()));
            return school;
        });
    }

}
