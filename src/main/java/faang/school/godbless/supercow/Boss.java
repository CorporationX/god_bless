package faang.school.godbless.supercow;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private final Lock lock = new ReentrantLock();

    public Boss(int maxPlayers, int currentPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers < maxPlayers) {
                currentPlayers++;
            } else {
                try {
                    System.out.println("No places anymore for " + player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void finishBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println("Player " + player.getName() + " ended fight with boss");
            System.out.println("There is a place for another player!");
            lock.notify();
        }
    }
}
