package school.faang.sprint4.tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(task.getDifficulty()*1000L);
            } catch (InterruptedException e) {
                System.out.println("Invalid async");;
            }

            School updateSchool = new School(school.getName(),school.getTeam());
            updateSchool.getTeam()
                    .stream()
                    .peek(student -> student.setPoints(task.getReward()))
                    .toList();
            return updateSchool;
        });
    }
}
