package school.faang.armyOfHeroes.heroes;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Archer extends Hero {
  public Archer(String name, int power) {
    super(name, power);
  }
}
