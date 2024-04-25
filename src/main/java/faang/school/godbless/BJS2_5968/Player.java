package faang.school.godbless.BJS2_5968;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
  private String name;

  public void startBattle(Boss boss) {
    try {
      boss.joinBattle(this);
      Thread.sleep(5000);
      boss.finishBattle();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
