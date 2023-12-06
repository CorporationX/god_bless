package faang.school.godbless.synchronize.superCow;

import lombok.Getter;

@Getter
public class Boss {
    private int currentPlayers = 0;
    private final int maxPlayers = 3;
    private final Object lock = new Object();

    public void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            waiting();
        }
        synchronized (lock) {
            currentPlayers++;
            System.out.println(player.getName() + " has joined the battle");
        }
    }

    private void waiting() {
        synchronized (lock) {
            System.out.println("Waiting for players to cansel battle...");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void finishBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.getName() + " has finished the battle");
            lock.notifyAll();
        }
    }
}
