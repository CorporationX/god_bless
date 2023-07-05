package faang.school.godbless.supercow;

import lombok.Getter;

@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers == maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Interrupted while waiting to join the battle: " + e.getMessage());
            }
        }
        currentPlayers++;
        System.out.println(player.name() + " joined the battle");
    }

    public synchronized void finishBattle() {
        currentPlayers--;
        notifyAll();
    }
}
