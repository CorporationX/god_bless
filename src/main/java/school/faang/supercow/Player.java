package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
  private String name;

  public void startBattle(Boss boss) {
    boss.joinPlayer(this);
  }

  public void leaveBattle(Boss boss) {
    boss.leavePlayer(this);
  }
}
