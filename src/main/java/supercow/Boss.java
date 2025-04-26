package supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void maxPlayers() {
        System.out.println("Maximum players allowed is " + maxPlayers);
    }

    public int getCurrentPlayers() {
        return currentPlayers;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                System.out.println(player.getName() + " is waiting to join battle...");
                lock.wait();
            }
            currentPlayers++;
            System.out.println(player.getName() + " joined the battle! Current: " + currentPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.getName() + " left the battle. Current: " + currentPlayers);
            lock.notify();
        }
    }
}
