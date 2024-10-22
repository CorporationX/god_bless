package bjs2_37884;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        int millisToSleep = 1000;

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(millisToSleep);
            } catch (InterruptedException e) {
                System.out.println("обрабатываем ошибку");
            }
            school.getTeam().forEach(student -> student.getTaskReward(task));
            return school;
        });
    }
}
