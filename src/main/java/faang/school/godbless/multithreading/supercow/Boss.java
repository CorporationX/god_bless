package faang.school.godbless.multithreading.supercow;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Boss {
    private final Object lock;
    private final int maxPlayers;
    private int currentPlayers;
    private final List<Player> players;
    private boolean isGameOver;


    public Boss(int maxPlayers) {
        lock = new Object();
        players = new ArrayList<>();
        currentPlayers = 0;
        isGameOver = false;
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (!isGameOver) {
            if (currentPlayers < maxPlayers) {
                System.out.println(Thread.currentThread().getName() + " joined the battle");
                players.add(player);
                currentPlayers++;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    public synchronized void leaveBattle(Player player) {
        System.out.println(player.getName() + " left the battle");
        players.remove(player);
        currentPlayers--;
        notifyAll();
    }

    public synchronized void stopGame() {
        isGameOver = true;
        notifyAll();
    }
}
