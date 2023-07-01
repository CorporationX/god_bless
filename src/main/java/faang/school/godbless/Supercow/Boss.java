package faang.school.godbless.Supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {

    private int maxPlayers;
    private Integer currentPlayers = 0;
    private List<Player> players = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {

        if (!players.contains(player)) {
            if (currentPlayers == maxPlayers) {
                try {
                    currentPlayers.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            addPlayer(player);
        }
    }

    private void addPlayer(Player player) {
        synchronized (currentPlayers) {
            currentPlayers++;
            players.add(player);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (currentPlayers) {

            players.remove(player);
            currentPlayers--;
            currentPlayers.notify();

        }
    }
}
