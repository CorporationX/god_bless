package school.faang.bjs274980;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("School team " + school.getName() + " are doing task " + task.getName());
                TimeUnit.SECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam()
                    .forEach(student ->
                            student.setPoints(student.getPoints() + task.getReward() / school.getTeam().size()));
            System.out.println("School team " + school.getName() +
                    " finished a task " + task.getName() +
                    " Earned points " + school.getTotalPoints());
            return school;
        });
    }
}
