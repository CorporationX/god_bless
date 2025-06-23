package school.faang.bjs2_82171;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            wait();
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
