package school.faang.bjs2_62466;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    private static final int TIMEOUTE_IN_MS = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("Команда школы - %s начала выполнение задания \n", school.getName());
                Thread.sleep((long) task.getDifficulty() * TIMEOUTE_IN_MS);
                System.out.printf("Команда школы - %s выполнила задание: %s \n", school.getName(), task.getName());
            } catch (InterruptedException e) {
                System.out.println("Ошибка: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
            school.getStudents()
                    .forEach(student -> {
                        student.addPoints(task.getReward() / school.getStudents().size());
                    });
            return school;
        });
        return future;
    }

}
