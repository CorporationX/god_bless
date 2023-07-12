package Sprint_4_1_Task7;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {

        return CompletableFuture.supplyAsync(() -> {
            school.getTeam().forEach(student -> {
                try {
                    Thread.sleep(1000L *task.getDifficulty());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(new Random().nextInt(2) + " " + student.getName());
                if (new Random().nextInt(2) ==1) {
                    student.setPoints(student.getPoints() + task.getReward());
                }
            });
            return school;
        });
    }
}
