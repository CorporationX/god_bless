package school.faang.armyOfHeroes.heroes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Mage extends Hero {
  public Mage(String name, int power) {
    super(name, power);
  }
}
