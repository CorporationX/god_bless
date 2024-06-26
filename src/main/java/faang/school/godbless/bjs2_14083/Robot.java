package faang.school.godbless.bjs2_14083;

import lombok.Getter;

public class Robot {

  private static final int INCREMENT = 1;
  private static final int DIVIDER = 100;

  @Getter
  private String name;
  @Getter
  private double health;
  @Getter
  private int attackPower;
  private int defensePower;

  public Robot(String name, int attackPower, int defensePower, double health) {
    this.name = name;
    this.attackPower = attackPower;
    this.defensePower = defensePower;
    this.health = getAllDefence(health);
  }

  private double getAllDefence(double health) {
    return health * getPercentageMultiplier(this.defensePower);
  }

  private double getPercentageMultiplier(int number) {
    return ((double) number / DIVIDER) + INCREMENT;
  }

  public void changeHealth(double value) {
    this.health -= value;
  }

}
