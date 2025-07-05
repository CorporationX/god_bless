package school.faang.bjs2_82905;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class Tournament {

    public CompletableFuture<School> startTask(School school, Task task, Student student, int customReward) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String startMessage = String.format(
                        "Школа '%s | Общие очки: %d' начала задание '%s [Сложность: %d, Награда: %d]' (время: %dмс)",
                        school.getName(),
                        school.getTotalPoints(),
                        task.getName(),
                        task.getDifficulty(),
                        customReward,
                        task.getDifficulty() * 1000
                );
                System.out.println(startMessage);

                TimeUnit.MILLISECONDS.sleep(task.getDifficulty() * 1000L);

                student.addPoints(customReward);

                String completeMessage = String.format(
                        "Школа '%s | Общие очки: %d' выполнила задание! +%d очков студенту %s (Год: %d, Очки: %d)",
                        school.getName(),
                        school.getTotalPoints(),
                        customReward,
                        student.getName(),
                        student.getYear(),
                        student.getPoints()
                );
                System.out.println(completeMessage);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return school;
        });
    }
}

