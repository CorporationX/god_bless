package bjs290245;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    Object lock = new Object();

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                System.out.printf("%s is waiting to join to the battle!\n", player.name());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.printf("%s was interrupted during waiting!\n", player.name());
                    Thread.currentThread().interrupt();
                }
            }
            currentPlayers++;
            System.out.printf("%s joined to the battle!\n", player.name());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.printf("%s left to the battle!\n", player.name());
            lock.notifyAll();
        }
    }
}
