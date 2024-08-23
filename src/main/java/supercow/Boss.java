package supercow;

import java.util.ArrayList;
import java.util.List;


public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();

    Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if (this.currentPlayers.size() >= maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.currentPlayers.add(player);
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers.get(currentPlayers.indexOf(player)) != null) {
            currentPlayers.remove(player);
            System.out.printf(
                "%s покинул бой с боссом. Текущее количество игроков: %s\n",
                player.getName(),
                this.currentPlayers.size()
            );
            notify();
        }
    }
}
