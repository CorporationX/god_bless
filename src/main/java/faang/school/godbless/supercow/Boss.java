package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final List<Player> players;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
        this.players = new ArrayList<>();
    }

    Object lock = new Object();

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " is waiting for free slot");
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentPlayers++;
            players.add(player);
            System.out.println(player.getName() + " Joined the battle ");

            currentPlayers--;
            players.remove(player);
            System.out.println(player.getName() + " Finished the battle");
            lock.notify();

        }
    }
}
