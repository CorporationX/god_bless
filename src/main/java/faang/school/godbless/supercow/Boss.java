package faang.school.godbless.supercow;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private Object lock = new Object();

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayers == maxPlayers) {
                lock.wait();
            }
            currentPlayers++;
            System.out.println("Player " + player.getName() + " join battle");
        }
    }

    public void finishBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            currentPlayers--;
            lock.notify();
            System.out.println("Player " + player.getName() + " finish battle");
        }
    }
}
