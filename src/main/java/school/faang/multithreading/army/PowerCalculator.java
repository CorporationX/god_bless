package school.faang.multithreading.army;

public class PowerCalculator implements Runnable {

  private final Powerable man;
  public static int totalPower;

  public PowerCalculator(Powerable man) {
    this.man = man;
  }

  @Override
  public void run() {
    totalPower += man.getPower();
  }
}
