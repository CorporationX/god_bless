package school.faang.godbless.bjs2_32851;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hero {

  private String name;
  private String faction;
  private int xp;
  private int level;
  private final Map<Creature, Integer> army = new HashMap<>();

  public void addCreature(Creature creature, int quantity) {
    army.put(creature, quantity);
  }

  public void removeCreature(Creature creature, int quantity) {
    if (!army.containsKey(creature) || army.get(creature) < quantity) {
      throw new IllegalArgumentException("No such creature or quantity is too big");
    }
    army.put(creature, army.get(creature) - quantity);
  }

  public List<Creature> getArmy() {
    return army.keySet().stream().toList();
  }

  public int getCreatureQuantity(Creature creature) {
    if (!army.containsKey(creature)) {
      throw new IllegalArgumentException();
    }
    return army.get(creature);
  }

  public boolean hasCreature(Creature creature) {
    return army.containsKey(creature);
  }
}
