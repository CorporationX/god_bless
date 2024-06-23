package faang.school.godbless.BJS2_12557;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Boss {
    private final int maxPlayers = 3;
    private final List<Player> currentPlayers = new ArrayList<>();
    private final Object lock = new Object();

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayers.size() < maxPlayers) {
                currentPlayers.add(player);
                System.out.println("Игрок " + player.getName() + " присоединился к битве");
                lock.notifyAll();
            } else {
                lock.wait();
            }
        }
    }

    public void leaveBattle(Player player) throws InterruptedException {
        Thread.sleep(5000);
        synchronized (lock) {
            currentPlayers.remove(player);
            System.out.println("Игрок " + player.getName() + " закончил битву");
            lock.notifyAll();
        }
    }
}
