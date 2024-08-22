package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final static int MAX_PLAYERS = 2;
    private final List<Player> currentPlayers = new ArrayList<>(MAX_PLAYERS);

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (this) {
            if (currentPlayers.size() >= MAX_PLAYERS) {
                System.out.println("Player " + player.name() + " cannot join battle, all slots are full.");
                this.wait();
            }
            currentPlayers.add(player);
            System.out.println("Player " + player.name() + " joined the battle!" +
                    " (" + currentPlayers.size() + " players are playing now)");
        }
        System.out.println("Player " + player.name() + " battling...");
        Thread.sleep(1000);
        endBattle(player);
    }

    public synchronized void endBattle(Player player) {
        currentPlayers.remove(player);
        this.notify();
        System.out.println("Player " + player.name() + " left the battle.");
    }
}
