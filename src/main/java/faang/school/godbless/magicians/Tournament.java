package faang.school.godbless.magicians;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("The " + task.getName() + " is ongoing");
                Thread.sleep(task.getDifficulty() * 100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student -> student.changePoints(task.getReward()));
            return school;
        });
    }
}
