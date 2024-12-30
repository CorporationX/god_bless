package school.faang.sprint4.task51042turnir;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task){
        CompletableFuture<School> taskFuture = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(1000 * task.getDifficult());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (Student student: school.getTeam()){
                student.addPoints(task.getReward());
            }
            return school;
        }
        );
        return taskFuture;
    }
}
