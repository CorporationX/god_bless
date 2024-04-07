package faang.school.godbless.BJS2_4697;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Battlefield {
  private Hero hero1;
  private Hero hero2;

  public Hero battle() {
    int hero1Damage = 0;
    for (Creature hero1Army : hero1.getArmy().keySet()) {
      hero1Damage += hero1Army.getDamage() * hero1.getArmy().get(hero1Army);
    }

    int hero2Damage = 0;
    for (Creature hero2Army : hero2.getArmy().keySet()) {
      hero2Damage += hero2Army.getDamage() * hero2.getArmy().get(hero2Army);
    }

    return hero1Damage >= hero2Damage ? hero1 : hero2;
  }
}
