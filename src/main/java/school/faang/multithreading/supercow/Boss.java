package school.faang.multithreading.supercow;

public class Boss {

  private final int maxPlayers;
  private int currentPlayers;

  public Boss(int maxPlayers) {
    this.maxPlayers = maxPlayers;
  }

  public synchronized void joinBattle(Player player) throws InterruptedException {
    if (!hasFreeSlots()) {
      System.out.println(player.getName() + " is waiting free slot");
      wait();
    }
    System.out.println("--> " + Thread.currentThread().getName() + " enter the fight");
    currentPlayers++;
  }

  public synchronized void fightAndLeave(Player player) {
    currentPlayers--;
    System.out.println("    " + player.getName() + " finished and left the battle -->");
    notify();
  }

  private boolean hasFreeSlots() {
    return maxPlayers - currentPlayers > 0;
  }

}
