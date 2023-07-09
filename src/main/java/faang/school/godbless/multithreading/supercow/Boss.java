package faang.school.godbless.multithreading.supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private String name;
    private final int maxPlayers;
    private static final Object LOCK = new Object();
    private List<Player> currentPlayers;

    public Boss(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        currentPlayers = new ArrayList<>(maxPlayers);
    }

    public void joinBattle(Player player) {
        synchronized (LOCK) {
            if (currentPlayers.size() >= maxPlayers) {
                try {
                    LOCK.wait();
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
        synchronized (LOCK) {
            if (currentPlayers.size() < 1) {
                System.out.println("There are no players here");
            } else {
                currentPlayers.remove(player);
                System.out.printf("PLayer %s left | Current players %s | %s (%s)\n",
                        player.getName(), currentPlayers.size(), name, Thread.currentThread().getName());
                LOCK.notifyAll();
            }
        }
    }

}
