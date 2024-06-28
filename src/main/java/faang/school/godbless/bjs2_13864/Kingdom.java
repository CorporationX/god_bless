package faang.school.godbless.bjs2_13864;

import static faang.school.godbless.bjs2_13864.Util.getRandomNumber;

public record Kingdom(String name, int distance) {

  private static final int DIVISIBLE = 2;
  private static final int DIVIDER = 2;
  private static final int REMAINDER = 0;
  private static final long DEFAULT_DELIVERY_TIME = 1_000L;
  private static final String DELIVERY_INTERRUPTED_EXCEPTION = "Выполнение доставки было прервано. ";
  private static final String MESSAGE_DELIVERY = "%s Ворон из %s доставил послание в %s.";
  private static final String UNDELIVERABLE = "%s Ворон из %s не смог доставить послание в %s.";

  public String sendMessage(Kingdom kingdom) {
    if (getRandomNumber(DIVISIBLE) % DIVIDER != REMAINDER && !this.name.equals(kingdom.name)) {
      throw new RuntimeException(getMessage(UNDELIVERABLE, kingdom.name));
    }
    delivery(kingdom);
    return getMessage(MESSAGE_DELIVERY, kingdom.name);
  }

  private String getMessage(String message, String value) {
    return String.format(message, Thread.currentThread().getName(), this.name, value);
  }

  private void delivery(Kingdom kingdom) {
    try {
      Thread.sleep(DEFAULT_DELIVERY_TIME * kingdom.distance);
    } catch (InterruptedException e) {
      throw new RuntimeException(DELIVERY_INTERRUPTED_EXCEPTION + e);
    }
  }

}
