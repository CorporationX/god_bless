package faang.school.godbless.BJS2_7907;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Hero {
  private String name;
  private String fraction;
  private int experience;
  private int level;
  private List<Creature> army;

  public void addCreature(Creature creature, int quantity) {
    army.add(creature);
  }

  public void removeCreature(Creature creature, int quantity) {
    for (Creature arm : army) {
      if (arm.equals(creature)) creature.setQuantity(creature.getQuantity() - quantity);
    }
  }

}
