package school.faang.async.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {

  private String name;
  private int level;
  private int experience;

  public void experienceUp(int reward) {
    experience += reward;
    level++;
  }

  @Override
  public String toString() {
    return name + " L" + level + " XP" + experience;
  }
}
