package faang.school.godbless.superCar;

public class Boss {
  private int maxPlayers;
  private int currentPlayers;

  public Boss(int maxPlayers) {
    this.maxPlayers = maxPlayers;
  }

  public synchronized void joinBattle(Player player) throws InterruptedException {
    while (currentPlayers >= maxPlayers) {
      System.out.println(player.getName() + " waiting battle");
      wait();
    }

    currentPlayers++;
    System.out.println(player.getName() + " joined to the game. Total player count: " + currentPlayers);
  }

  public synchronized void leaveBattle(Player player) {
      currentPlayers--;
      System.out.println(player.getName() + " finished playing with boss");
      notify();
  }
}
