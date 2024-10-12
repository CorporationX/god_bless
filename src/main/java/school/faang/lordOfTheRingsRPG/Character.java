package school.faang.lordOfTheRingsRPG;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Character extends school.faang.character.Character {
  private List<Item> inventory = new ArrayList<>();

  @Override
  public void attack(school.faang.character.Character character) {
    super.setHealth(character.getHealth() - super.power);
  }
}
