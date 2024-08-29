package faang.school.godbless.BJS2_25120;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());

                school.getTeam().forEach(student ->
                        student.addPoints(ThreadLocalRandom.current().nextInt(task.getReward())));

                System.out.println("Задание - " + task.getName() + " - завершено школой " + school.getName() +
                        ". Общие очки: " + school.getTotalPoints());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return school;
        });
    }
}
