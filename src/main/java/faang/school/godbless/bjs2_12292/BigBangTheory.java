package faang.school.godbless.bjs2_12292;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;

public class BigBangTheory {

  private static final int POOL_SIZE = 4;
  private static final int TIME_OUT = 30;
  private static final String ALL_TASKS_ENDED = "Все задачи выполнены!";

  @SneakyThrows
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
    final var tasks = List.of(new Task("Шелдон", "Подготовка теории", 10_000L),
        new Task("Леонард", "Моделирование эксперимента.", 8000L),
        new Task("Говард", "Разработка инструментов.", 5000L),
        new Task("Раджеш", "Анализ данных.", 3000L));

    tasks.forEach(task -> {
      Thread thread = new Thread(task);
      executorService.execute(thread);
    });

    executorService.shutdown();

    executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);

    System.out.println(ALL_TASKS_ENDED);

  }
}
