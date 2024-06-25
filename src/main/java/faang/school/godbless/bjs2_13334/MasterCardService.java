package faang.school.godbless.bjs2_13334;

public record MasterCardService() {

  private static final long PAYMENT_TIME = 10_000L;
  private static final long ANALYTICS_TIME = 1_000L;
  private static final String COLLECTION_PAYMENT_EXCEPTION = "Сбор платежа был прерван. ";
  private static final String SENDING_ANALYTICS_EXCEPTION = "Отправка аналитики была прервана. ";

  public int collectPayment() {
    try {
      Thread.sleep(PAYMENT_TIME);
      return (int) PAYMENT_TIME;
    } catch (InterruptedException e) {
      throw new RuntimeException(COLLECTION_PAYMENT_EXCEPTION + e);
    }
  }

  public int sendAnalytics() {
    try {
      Thread.sleep(ANALYTICS_TIME);
      return (int) ANALYTICS_TIME;
    } catch (InterruptedException e) {
      throw new RuntimeException(SENDING_ANALYTICS_EXCEPTION + e);
    }
  }

}
