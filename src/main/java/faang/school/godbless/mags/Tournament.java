package faang.school.godbless.mags;

import java.util.concurrent.CompletableFuture;

public class Tournament {
  public CompletableFuture<School> startTask(School school, Task task) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      school.getStudents().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
      return school;
    });
  }
}
