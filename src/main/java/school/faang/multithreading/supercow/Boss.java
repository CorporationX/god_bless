package school.faang.multithreading.supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        synchronized (this) {
            while (currentPlayers >= maxPlayers) {
                System.out.println(player.getName() + " is waiting for a free slot");
                wait();
            }
            currentPlayers++;
            System.out.println("Player " + player.getName() + " joined the battle");
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " is leaving the battle");
        notify();
    }
}

