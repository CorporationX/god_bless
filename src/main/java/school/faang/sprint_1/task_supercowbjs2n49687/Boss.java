package school.faang.sprint_1.task_supercowbjs2n49687;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final int maxPlayers;
    private final Object lock = new Object();
    List<Player> currentPlayersInAction = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while ((currentPlayersInAction.size() < maxPlayers) && (!currentPlayersInAction.contains(player))) {
                currentPlayersInAction.add(player);
                System.out.printf("+ %s has joined battle. Now in battle: %s\n",
                                    player.getName(), currentPlayersInAction);
            }
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            while ((currentPlayersInAction.contains(player))) {
                currentPlayersInAction.remove(player);
                System.out.printf("- %s has  left  battle. Now in battle: %s\n",
                                    player.getName(), currentPlayersInAction);
            }
            if (currentPlayersInAction.size() < maxPlayers) {
                lock.notify();
            }
        }
    }
}

