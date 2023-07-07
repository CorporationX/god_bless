package faang.school.godbless.multithreading.supercow;

import lombok.Getter;

@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        currentPlayers = 0;
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println(player.getName() + " joined the battle");
        currentPlayers++;
    }

    public synchronized void leaveBattle(Player player) {
        System.out.println(player.getName() + " left the battle");
        currentPlayers--;
        notifyAll();
    }
}
