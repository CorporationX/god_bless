package school.faang.bjs2_92813;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (school) {
                try {
                    Thread.sleep(task.getDifficulty() * 1000L);
                    List<Student> students = school.getTeam();
                    for (Student student : students) {
                        student.setPoints(student.getPoints() + task.getReward());
                    }
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            return school;
        });
    }
}
