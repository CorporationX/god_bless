package faang.school.godbless.heroes;

public class PowerThread extends Thread {
  int power;

  public PowerThread(int power) {
    this.power = power;
  }

  public int getPower() {
    return power;
  }
}
