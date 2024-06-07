package faang.school.godbless.BJS2_4697;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Hero {
  private String name;
  private String fraction;
  private int exp;
  private int level;
  private Map<Creature, Integer> army = new HashMap<>();

  public Hero(String name, String fraction, int level) {
    this.name = name;
    this.fraction = fraction;
  }

  public void addCreature(Creature creature, int quality) {
    army.put(creature, quality);
  }
  public void removeCreature(Creature creature, int quantity) {
    if (army.containsKey(creature)) {
      army.put(creature, army.get(creature) - quantity);
      if (army.get(creature) <= 0) {
        army.remove(creature);
      }
    }
  }
  public Map<Creature, Integer> getArmy() {
    return army;
  }
}
