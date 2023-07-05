package faang.school.godbless.sprint3.supercow;

import lombok.Data;

@Data
public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers = 3;
    private int currentPlayers;

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayers < maxPlayers) {
                currentPlayers++;
            } else {
                lock.wait();
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            lock.notifyAll();
        }
    }
}
