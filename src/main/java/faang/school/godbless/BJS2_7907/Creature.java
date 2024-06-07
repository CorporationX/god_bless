package faang.school.godbless.BJS2_7907;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
  private String name;
  private int level;
  private int damage;
  private int protection;
  private int speed;
  private int quantity;
}
