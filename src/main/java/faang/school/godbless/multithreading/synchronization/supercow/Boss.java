package faang.school.godbless.multithreading.synchronization.supercow;

import lombok.Data;

@Data
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers == maxPlayers) {
            try {
                System.out.println(player.getName() + " is waiting...");
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted while waiting queue");
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " joined to battle");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        this.notify();
        System.out.println(player.getName() + " finished battle");

    }
}
