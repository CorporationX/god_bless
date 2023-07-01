package faang.school.godbless.multithreading.supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private String name;
    private final int MAX_PLAYERS;
    private static final Object lock = new Object();
    private List<Player> currentPlayers;

    public Boss(String name, int MAX_PLAYERS) {
        this.name = name;
        this.MAX_PLAYERS = MAX_PLAYERS;
        currentPlayers = new ArrayList<>(MAX_PLAYERS);
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers.size() >= MAX_PLAYERS) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers.add(player);
            System.out.printf("PLayer %s joined | Current players %s | %s (%s)\n",
                    player.getName(), currentPlayers.size(), name, Thread.currentThread().getName());

        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers.size() < 1) {
                System.out.println("There are no players here");
            } else {
                currentPlayers.remove(player);
                System.out.printf("PLayer %s left | Current players %s | %s (%s)\n",
                        player.getName(), currentPlayers.size(), name, Thread.currentThread().getName());
                lock.notify();
            }
        }
    }

}
