package faang.school.godbless.sprint2.bigBang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
@Getter
@AllArgsConstructor
public class Task implements Runnable {
  private String name;
  private String task;

  @Override
  public void run() {
    log.info(String.format("%s начал выполнять задание: %s", name, task));
    try {
      Thread.sleep(1000);
    }
    catch (InterruptedException e) {
      throw new RuntimeException("Упс... возникла ошибка во время выполнения задания " + task, e);
    }
    log.info(String.format("%s выполнил задание: %s", name, task));
  }
}
