package school.faang.bjs2_92299;

public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.printf("Player %s waits his turn\n", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.printf("Player %s interrupted while waiting\n", player.getName());
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            System.out.printf("Player %s fights again the boss!\n", player.getName());
            currentPlayers++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            System.out.printf("Player %s has left the batlle\n", player.getName());
            currentPlayers--;
            lock.notify();
        }
    }
}
