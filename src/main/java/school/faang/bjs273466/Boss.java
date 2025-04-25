package school.faang.bjs273466;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (this) {
            while (currentPlayers.size() == maxPlayers) {
                try {
                    System.out.printf(" %s is waiting his turn %s%n",
                            player.getName(), Thread.currentThread().getName());
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers.add(player);
            System.out.printf(" %s has been joined to battle %s%n",
                    player.getName(), Thread.currentThread().getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (this) {
            currentPlayers.remove(player);
            System.out.printf(" %s left the battle %s%n",
                    player.getName(), Thread.currentThread().getName());
            this.notifyAll();
        }
    }
}
