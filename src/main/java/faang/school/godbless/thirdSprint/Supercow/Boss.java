package faang.school.godbless.thirdSprint.Supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final Object lock = new Object();
    private final List<Player> players;
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();
        currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers < maxPlayers) {
                currentPlayers++;
                players.add(player);
                System.out.println("Player " + player.name() + " has entered the battle");
            } else {
                try {
                    lock.wait();
                    joinBattle(player);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (players.contains(player)) {
                System.out.println("Player " + player.name() + " has left the battle");
                currentPlayers--;
                players.remove(player);
                lock.notifyAll();
            }
        }
    }
}
