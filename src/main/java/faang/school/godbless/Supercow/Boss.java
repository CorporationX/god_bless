package faang.school.godbless.Supercow;

import java.util.*;

public class Boss {
    private final int maxPlayer;
    private List<Player> currentPlayer;
    private Object lock = new Object();

    public Boss(int maxPlayer) {
        this.maxPlayer = maxPlayer;
        this.currentPlayer = new ArrayList<>();
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayer.size() >= maxPlayer) {
                lock.wait();
            }
            currentPlayer.add(player);
            System.out.println("Добавлен " + player);
        }
    }

    public void endPlaying(Player player) {
        synchronized (lock) {
            currentPlayer.remove(player);
            System.out.println("Удален " + player);
            lock.notify();
        }
    }
}
