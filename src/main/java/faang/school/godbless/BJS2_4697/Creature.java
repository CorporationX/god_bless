package faang.school.godbless.BJS2_4697;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
  private String name;
  private int level;
  private int attack;
  private int protection;
  private int speed;
  private int amount;

  public Creature(String name, int level, int attack, int protection, int speed) {
    this.name = name;
    this.level = level;
    this.attack = attack;
    this.protection = protection;
    this.speed = speed;
  }

  public abstract int getDamage();
}
