package faang.school.godbless.sprint2.extremelyPoor;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@Slf4j
public class Chore implements Runnable {
  private String chore;
  @Override
  @SneakyThrows
  public void run() {
    log.info(String.format("№%s %s Выполняем работу", Thread.currentThread().getName(), chore));
    Thread.sleep(1000);
    log.info(String.format("№%s %s Завершили выполнение", Thread.currentThread().getName(), chore));
  }
}
