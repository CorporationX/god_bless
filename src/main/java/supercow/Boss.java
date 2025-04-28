package supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

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
        synchronized (this) {
            while (currentPlayers >= maxPlayers) {
                System.out.println(player.getName() + " is waiting to join battle...");
                wait();
            }
            currentPlayers++;
            System.out.println(player.getName() + " joined the battle! Current: " + currentPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (this) {
            currentPlayers--;
            System.out.println(player.getName() + " left the battle. Current: " + currentPlayers);
            notify();
        }
    }
}
