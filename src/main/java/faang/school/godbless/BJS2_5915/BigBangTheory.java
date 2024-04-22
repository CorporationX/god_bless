package faang.school.godbless.BJS2_5915;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
  public static void main(String[] args) {
    ExecutorService executors = Executors.newFixedThreadPool(4);
    Task sheldonTask = new Task("Шелдон", "подготовка теории");
    Task leoTask = new Task("Леонард", "моделирование эксперимента");
    Task goviTask = new Task("Говард", "разработка инструментов");
    Task rajTask = new Task("Раджеш", "анализ данных");

    executors.execute(sheldonTask);
    executors.execute(leoTask);
    executors.execute(goviTask);
    executors.execute(rajTask);

    executors.shutdown();

    try {
      while(!executors.awaitTermination(30, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("All tasks finished!");
  }
}
