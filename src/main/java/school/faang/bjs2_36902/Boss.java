package school.faang.bjs2_36902;

public class Boss {
    private final int maxPlayers;
    private int currentPlayer = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        try {
            while (currentPlayer >= maxPlayers) {
                System.out.println(player.getName() + " waiting all slots are occupied");
                wait();
            }
            currentPlayer++;
            System.out.println(player.getName() + " joined the battle. Now number of players: " + currentPlayer);

            Thread.sleep(1000);

            currentPlayer--;
            System.out.println(player.getName() + " battle ended. Empty slots: " + (maxPlayers - currentPlayer));

            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(player.getName() + " was interrupted.");
        }
    }
}