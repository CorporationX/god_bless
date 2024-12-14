package school.faang.godbless.bjs2_32851;

import lombok.Data;

@Data
public abstract class Creature {

  private String name;
  private int level;
  private int attack;
  private int defence;
  private int speed;

  public abstract int getDamange();
}
