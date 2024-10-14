package school.faang.armyOfHeroes.heroes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Hero {
  protected String name;
  protected int power;
}
