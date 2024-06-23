package faang.school.godbless.bjs2_12541;

public class Boss {

  private static final long DEFAULT_TIME_FIGHT_BOSS = 1000L;
  private static final int MIN_CURRENT_PLAYER = 0;
  private static final String PLAYER_FIGHTS_BOSS  = " Игрок \"%s\" вступил в битву с боссом \"%s\"";
  private static final String PLAYER_FINISH_FIGHT_BOSS  = " Игрок \"%s\" завершил битву с боссом \"%s\"";
  private static final String QUEUING = " Игрок \"%s\" ожидает своей очереди для битвы с боссом \"%s\"";

  private String name;
  private int maxPlayer;
  private int currentPlayer;

  public Boss(String name, int maxPlayer) {
    this.name = name;
    this.maxPlayer = maxPlayer;
    currentPlayer = MIN_CURRENT_PLAYER;
  }

  public void joinBattle(Player player) {
    addPlayer(player);
    System.out.println(Thread.currentThread().getName() +
        String.format(PLAYER_FIGHTS_BOSS, player.name(), name));
    try {
      Thread.sleep(player.power() * DEFAULT_TIME_FIGHT_BOSS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    removePlayer(player);
  }

  private void addPlayer(Player player) {
    synchronized (this) {
      while (currentPlayer == maxPlayer) {
        System.out.println(Thread.currentThread().getName() +
            String.format(QUEUING, player.name(), name));
        try {
          wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      currentPlayer++;
    }
  }

  private void removePlayer(Player player) {
    synchronized (this) {
      currentPlayer--;
      notify();
      System.out.println(Thread.currentThread().getName() +
          String.format(PLAYER_FINISH_FIGHT_BOSS, player.name(), name));
    }
  }
}
