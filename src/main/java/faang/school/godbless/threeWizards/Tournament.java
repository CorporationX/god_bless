package faang.school.godbless.threeWizards;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, List<Task> tasks){
        return CompletableFuture.supplyAsync(() -> {
            for (Task task : tasks) {
                school.getTeam().stream()
                        .filter(student -> student.getYear() >= task.getDifficulty())
                        .forEach(student -> {
                            student.setPoints(student.getPoints() + task.getReward());
                            System.out.println(student.getName() + " прошёл испытание " + task.getName() + " и заработал " +
                                    task.getReward() + " очков.");
                        });
            }
                return school;
        });
    }
}
