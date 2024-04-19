package Supercow;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private final Object LOCK = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= maxPlayers) {
            System.out.println("Player wait game " + player.getName());
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " join the game.");
    }

    public synchronized void finishGame(Player player) {
        currentPlayers--;
        notify();
        System.out.println(player.getName() + " finish battle.");
    }
}
