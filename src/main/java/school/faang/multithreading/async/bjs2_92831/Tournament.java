package school.faang.multithreading.async.bjs2_92831;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final long ONE_SECOND_DELAY = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ONE_SECOND_DELAY * task.difficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Обновляем очки команды после выполнения задания
            for (Student student : school.students()) {
                student.addPoints(task.reward());
            }

            return school;
        });
    }
}
