package faang.school.godbless.BJS2_4697;

import faang.school.godbless.BJS2_4697.Creature;

public class Angel extends Creature {
  public Angel(String name, int lvl) {
    super(name, lvl, 4, 4, 4);
  }
  @Override public int getDamage() {
    return 0;
  }
}
