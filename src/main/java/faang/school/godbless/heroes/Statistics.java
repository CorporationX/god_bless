package faang.school.godbless.heroes;

public class Statistics {
  private static int totalPower = 0;

  public static int getTotalPower() {
    return totalPower;
  }

  public static void setTotalPower(int totalPower) {
    if (totalPower >= 0) {
      Statistics.totalPower = totalPower;
    }
  }
}