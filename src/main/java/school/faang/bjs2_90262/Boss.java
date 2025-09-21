package school.faang.bjs2_90262;

public class Boss {
    private final int maxPlayers = 2;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) {
        if (player == null) {
            System.out.println("Player cannot be null");
            return;
        }
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println("Players " + player.getName() + " wait to join the battle");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        currentPlayers++;
        System.out.println("Player " + player.getName() + " joined the battle");
    }

    public synchronized void leaveBattle(Player player) {
        if (player == null) {
            System.out.println("Player cannot be null");
            return;
        }
        if (currentPlayers > 0) {
            currentPlayers--;
            System.out.println("Player " + player.getName() + " leave in the battle");
            notifyAll();
        }
    }
}
