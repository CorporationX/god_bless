package school.faang.task_49696;

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
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " is waiting "
                        + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " joined to the battle "
                + Thread.currentThread().getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " ended the battle " + Thread.currentThread().getName());
        notify();
    }
}