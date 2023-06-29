package faang.school.godbless.heroes;

public class PowerThread extends Thread {
  int power;

  public PowerThread(int power) {
    this.power = power;
  }

  @Override
  public void run() {
    Statistics.setTotalPower(power);
  }
}
