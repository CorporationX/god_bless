package school.faang.task_49648;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final int maxPlayers;
    private static int currentPlayers;
    private Object lock = new Object();
    private List<Player> players = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (maxPlayers > currentPlayers) {
                if (!players.contains(player)) {
                    players.add(player);
                    currentPlayers++;
                    System.out.println(String.format("Player %s has joined to battle", player.getName()));
                }
            }
        }
    }

    public void finishBattle(Player player) {
        synchronized (lock) {
            if (players.contains(player)) {
                players.remove(player);
                currentPlayers--;
                System.out.println(String.format("Player %s has finished to battle", player.getName()));
                lock.notify();
            }
        }
    }
}