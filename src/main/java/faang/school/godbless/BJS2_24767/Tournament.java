package faang.school.godbless.BJS2_24767;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        Random rand = new Random();
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            int coef = rand.nextInt(1, 5);
            int totalReward = task.getReward() / coef + task.getDifficulty();
            school.getTeam().stream()
                    .forEach(student -> student.setPoints(student.getPoints() + totalReward / school.getTeam().size()));
        System.out.println("TH: "+Thread.currentThread().getName());
            return school;
        });
        try {
            Thread.sleep(new Random().nextInt(10000,30000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return future;
    }
}
