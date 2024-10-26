package school.faang.bjs2_39094;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty().getTime());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (Student student : school.students()) {
                student.addPoints(task.reward());
            }

            log.info(String.format("School '%s' has %d points", school.name(), school.getTotalPoints()));

            return school;
        });
    }
}
