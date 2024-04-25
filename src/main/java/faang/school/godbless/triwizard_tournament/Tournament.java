package faang.school.godbless.triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@AllArgsConstructor
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CompletableFuture<School> result = CompletableFuture.supplyAsync(() -> {
            System.out.println("Школа " + school.getName() + " приступила к заданию " + task.getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            school.getTeam().forEach(student -> student.setPoints(task.getReward()));
            return school;
        }, executorService);
        executorService.shutdown();

        return result;
    }
}
