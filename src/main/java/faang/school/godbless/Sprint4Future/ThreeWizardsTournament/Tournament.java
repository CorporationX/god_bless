package faang.school.godbless.Sprint4Future.ThreeWizardsTournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task){
        List<Student> students = school.getTeam();
        return CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            students.forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            return school;
        });

    }
}
