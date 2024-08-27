package faang.school.godbless.asynchronism.task5;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("Ученики школы " + school.getName() + " выполняют задачу");
            try {
                Thread.sleep(1000L * (task.getDifficulty().ordinal() + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            school.getTeam()
                    .forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            return school;
        });
    }
}
