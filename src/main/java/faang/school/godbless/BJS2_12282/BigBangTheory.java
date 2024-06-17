package faang.school.godbless.BJS2_12282;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
  private static final int THREADS = 4;

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(THREADS);

    executor.execute(new Task("name1", "task1"));
    executor.execute(new Task("name2", "task2"));
    executor.execute(new Task("name3", "task3"));
    executor.execute(new Task("name4", "task4"));

    executor.shutdown();
  }
}
