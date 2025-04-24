package school.faang.stream3.supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final List<Player> playerTeam;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.playerTeam = new ArrayList<>(maxPlayers);
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers || playerTeam.contains(player)) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            playerTeam.add(player);
            currentPlayers++;
            System.out.printf("%s entered the boss battle\n", player);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (playerTeam.contains(player)) {
                playerTeam.remove(player);
                currentPlayers--;
                System.out.printf("%s left the boss battle\n", player);
                lock.notify();
            }
        }
    }
}
