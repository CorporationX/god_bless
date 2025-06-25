package school.faang.bjs2_82171;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(player.name() + " was interrupted while waiting to join the battle.");
                return;
            }
        }
        currentPlayers++;
        System.out.println(player.name() + " joined the battle. Current players: " + currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.name() + " left the battle. Current players: " + currentPlayers);
        notifyAll();
    }
}
