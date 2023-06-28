package faang.school.godbless.bigBang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
  private static final int THREADS_COUNT = 4;

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
    List<Task> tasks = List.of(
        new Task("Sheldon", "Theory preparation"),
        new Task("Leonard","Experiment simulation"),
        new Task("Howard","tools development"),
        new Task("Rajesh","data analysis")
    );

    for (Task task : tasks) {
      executorService.execute(task);
    }

    executorService.shutdown();

    try {
      executorService.awaitTermination(1, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("All tasks done");
  }
}
