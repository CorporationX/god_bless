package school.faang.supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    private final List<Player> activePlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
        this.activePlayers = new ArrayList<>();
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            wait();
        }
        currentPlayers++;
        activePlayers.add(player);
        System.out.println(player.name() + " has joined the battle. Current players: " + currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        activePlayers.remove(player);
        System.out.println(player.name() + " has left the battle. Current players: " + currentPlayers);
        notify();
    }
}
