package faang.school.godbless.BJS2_5968;

import lombok.Data;

@Data
public class Boss {
  private static final Object LOCK = new Object();
  private int maxPlayers;
  private int currentPlayers = 0;

  public Boss(int maxPlayers) {
    this.maxPlayers = maxPlayers;
  }

  public void joinBattle(Player player) {
    synchronized (LOCK) {
      while (currentPlayers >= maxPlayers) {
        try {
          System.out.println("Wait");
          LOCK.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      currentPlayers++;
      System.out.println(player.getName() + " joined");
    }
  }

  public void finishBattle() {
    synchronized (LOCK) {
      currentPlayers--;
      System.out.println("player left");
      LOCK.notify();
    }
  }
}
