package supercow;

import lombok.SneakyThrows;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    @SneakyThrows
    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= maxPlayers) {
            System.out.println(player.name() + " is waiting for a free slot.");
            this.wait();
        }
        currentPlayers++;
        System.out.println(player.name() + " joined the boss battle.");
    }

    public synchronized void playerFinishedBattle() {
        currentPlayers--;
        System.out.println("A player finished the boss battle");
        notifyAll();
    }
}
