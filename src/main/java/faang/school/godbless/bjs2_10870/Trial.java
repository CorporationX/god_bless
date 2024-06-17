package faang.school.godbless.bjs2_10870;

import java.util.Random;
import lombok.SneakyThrows;

/**
 * Класс представления испытания
 * @param knightName Имя рыцаря
 * @param trialName название испытания
 */
public record Trial(String knightName, String trialName ) implements Runnable {
  private static final String START_TRIAL = " Рыцарь %s начал испытание \"%s\"";
  private static final long DEFAULT_TIME_TRIAL = 5000L;
  private static final int DIVISOR = 2;
  private static final int RESIDUE = 0;
  private static final int BOUND = 100;
  private static final String KNIGHT_PASSED_TRIAL = " Рыцарь %s прошел испытание \"%s\" ";
  private static final String KNIGHT_FAILED_TRIAL = " Рыцарь %s не прошел испытание \"%s\"";

  @SneakyThrows
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + String.format(START_TRIAL, knightName, trialName));
    Thread.sleep(DEFAULT_TIME_TRIAL);
    final int luck = new Random().nextInt(BOUND);
    if (luck % DIVISOR == RESIDUE) {
      System.out.println(Thread.currentThread().getName() + String.format(KNIGHT_PASSED_TRIAL, knightName, trialName));
    } else {
      System.out.println(Thread.currentThread().getName() + String.format(KNIGHT_FAILED_TRIAL, knightName, trialName));
    }
  }

}
