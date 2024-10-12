package school.faang.character;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public abstract class Character implements Attackable{
  protected String name;
  protected int power;
  protected int agility;
  protected int intellect;
  protected int health = 100;

  Character(String name) {
    this.name = name;
  }

  Character(String name, int power, int agility, int intellect) {
    this.name = name;
    this.power = power;
    this.agility = agility;
    this.intellect = intellect;
  }
}
