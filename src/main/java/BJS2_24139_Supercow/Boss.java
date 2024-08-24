package BJS2_24139_Supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers, int currentPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (this) {
            while (currentPlayers == maxPlayers) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            currentPlayers++;
            System.out.println(player.name() + " joined the battle! Current players are fighting boss: " +
                    currentPlayers);
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        synchronized (this) {
            currentPlayers--;
            System.out.println(player.name() + " has left the battle! Current open slots: " +
                    (maxPlayers - currentPlayers));
            this.notifyAll();
        }
    }
}
