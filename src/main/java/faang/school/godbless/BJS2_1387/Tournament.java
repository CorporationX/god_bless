package faang.school.godbless.BJS2_1387;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask (School school, Task task) {
         CompletableFuture<School> result = CompletableFuture.supplyAsync(() -> {
            System.out.println(school.getName()+" has start the task "+task.getName());
            try {
                Thread.sleep(1000L * task.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted exception");
            }
            System.out.println(school.getName()+" has completed the task "+task.getName());

            school.getTeam().forEach(student -> student.setPoints(task.getReward()/10));
            return school;
        });
         return result;
    }
}
