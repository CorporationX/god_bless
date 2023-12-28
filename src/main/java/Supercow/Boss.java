package Supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private static final int maxPlayers = 3;
    private final List<Player> currentPlayers = new ArrayList<>();

    public synchronized void joinBattle(Player player) {

        while (maxPlayers == currentPlayers.size()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        addPlayer(player);
        System.out.println("Игрок " + player.getPlayerName() + " присоединился");

    }

    public synchronized void endBattle(Player player) {
        System.out.println("Игрок " + player.getPlayerName() + " закончил сражение");
        currentPlayers.remove(player);
        notify();
    }

    private void addPlayer(Player player) {
        currentPlayers.add(player);
    }

}
