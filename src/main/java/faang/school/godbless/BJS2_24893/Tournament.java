package faang.school.godbless.BJS2_24893;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> completableFuture = CompletableFuture.supplyAsync(() -> {
            for (Student student : school.getTeam()) {
                boolean isWin = new Random().nextBoolean();
                if (isWin) {
                    student.setPoints(student.getPoints() + task.getReward());
                } else {
                    System.out.println(student.getName() + " lost!");
                }
            }

            return school;
        });

        return completableFuture;
    }

}
