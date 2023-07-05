package faang.school.godbless.starWars;

import java.util.concurrent.Future;

public class Robot {
  private String name;
  private int attackPower;
  private int defensePower;

  public Robot(String name, int attackPower, int defensePower) {
    this.name = name;
    this.attackPower = attackPower;
    this.defensePower = defensePower;
  }

  public String getName() {
    return name;
  }

  public int getAttackPower() {
    return attackPower;
  }

  public int getDefensePower() {
    return defensePower;
  }

  public void setDefensePower(int defensePower) {
    this.defensePower = defensePower;
  }
}
