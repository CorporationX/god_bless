package faang.school.godbless.heroes;

public abstract class Unit {
  private int power;

  public Unit(int power) {
    this.power = power;
  }

  public int getPower() {
    return power;
  }
}
