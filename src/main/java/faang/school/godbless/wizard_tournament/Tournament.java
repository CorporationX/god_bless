package faang.school.godbless.wizard_tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            int pointsEarned = task.getReward() - task.getDifficulty();
            school.getTeam().forEach(student -> student.addPoints(pointsEarned));
            return school;
        });
    }
}
