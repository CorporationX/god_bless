package faang.school.godbless.asyncFuture;

public class MasterCardService {
  static int collectPayment() {
    try {
      Thread.sleep(10_000);
      return 10_000;
    } catch (InterruptedException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

  static int sendAnalytics() {
    try {
      Thread.sleep(1_000);
      return 1_000;
    } catch (InterruptedException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }
}
