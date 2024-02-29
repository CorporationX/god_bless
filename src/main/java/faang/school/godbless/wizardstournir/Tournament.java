package faang.school.godbless.wizardstournir;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    private final Random rnd = new Random();

    public CompletableFuture<School> startTask(School school, Task task) {
        int sleepTime = rnd.nextInt(15);
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.supplyAsync(() -> {
            Student playingStudent = school.getTeam().get(rnd.nextInt(school.getTeam().size()));
            playingStudent.setPoints(playingStudent.getPoints() + task.getReward());
            return school;
        });
    }
}
