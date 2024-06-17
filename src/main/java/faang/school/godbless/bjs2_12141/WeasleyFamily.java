package faang.school.godbless.bjs2_12141;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
  private static final int TIME_OUT = 10;
  private static final String ALL_TASKS_COMPLETED = "Все задачи выполнены!";

  public static void main(String[] args) {
    String[] chores = {"Учить многопоточку", "Учить Java", "Учить Spring", "Учить Kafka", "Учить Redis"};

    ExecutorService executorService = Executors.newCachedThreadPool();

    for (int i = 0; i < chores.length; i++) {
      executorService.submit(new Chore(chores[i]));
    }

    executorService.shutdown();
    try {
      executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println(ALL_TASKS_COMPLETED);
  }

}
