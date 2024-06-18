package faang.school.godbless.sprint2.bigBang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class BigBangTheory {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(4);
    List<Task> tasks = List.of(
        new Task("Шелдон", "Подготовка теории"),
        new Task("Леонард", "Моделирование эксперимента"),
        new Task("Говард", "Разработка инструментов"),
        new Task("Раджеш", "Анализ данных")
    );
    for (Task task : tasks) {
      executor.execute(task);
    }

    executor.shutdown();
    try {
      if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
        executor.shutdownNow();
      }
    } catch (InterruptedException e) {
      log.error(e.getMessage());
      executor.shutdownNow();
      Thread.currentThread().interrupt();
    }
    log.info("Все задачи выполнены");
  }
}
