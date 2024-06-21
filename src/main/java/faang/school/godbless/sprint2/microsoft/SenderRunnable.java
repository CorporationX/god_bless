package faang.school.godbless.sprint2.microsoft;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@Slf4j
public class SenderRunnable implements Runnable{

  private int startIndex;
  private int endIndex;

  @Override
  public void run() {
    for (int i = startIndex; i < endIndex; i++ ) {
      log.info(String.format("%s письмо отправлено. Пачка %s - %s.%n", i, startIndex, endIndex));
    }
  }
}
