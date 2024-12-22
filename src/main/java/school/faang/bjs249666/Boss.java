package school.faang.bjs249666;

public class Boss {

    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        try {
            while (currentPlayers >= maxPlayers) {
                this.wait();
            }
            currentPlayers++;
            System.out.println(player.getName() + " joined the battle!");
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " left the battle!");
        notifyAll();
    }
}
