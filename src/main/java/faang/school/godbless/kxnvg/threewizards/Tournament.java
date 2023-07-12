package faang.school.godbless.kxnvg.threewizards;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student -> student.takeReward(task.getReward()));
            return school;
        });
    }
}
