package faang.school.godbless.BJS2_24991;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task){
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(school.getName() + " starting the " + task.getName() + " with difficulty " + task.getDifficulty());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            return school;
        });
    }
}