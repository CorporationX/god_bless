package faang.school.godbless.bjs2_13772;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
  private String name;
  private int level;
  private int experience;

  public Player getPlayerWithChangedExperience(int experience) {
    this.experience += experience;
    return this;
  }

}
