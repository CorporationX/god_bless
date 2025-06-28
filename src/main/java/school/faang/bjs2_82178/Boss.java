package school.faang.bjs2_82178;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                lock.wait();
            }
            currentPlayers++;
            System.out.printf("Player: %s join the battle%n", player.name());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.printf("Player: %s leave the battle%n", player.name());
            lock.notify();
        }
    }
}