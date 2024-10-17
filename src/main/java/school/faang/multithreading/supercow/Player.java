package school.faang.multithreading.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {

  private final String name;

  public void startBattle(Boss boss) throws InterruptedException {
    boss.joinBattle(this);
    Thread.sleep(2000);
    boss.fightAndLeave(this);
  }
}
