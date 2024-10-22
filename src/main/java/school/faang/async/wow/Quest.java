package school.faang.async.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Quest {

  private String name;
  private int difficulty;
  private int reward;

  @Override
  public String toString() {
    return name + " DIFFICULTY: " + difficulty + " XP: " + reward;
  }
}
