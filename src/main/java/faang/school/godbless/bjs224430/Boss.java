package faang.school.godbless.bjs224430;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final int maxPlayers = 4;
    private final List<Player> currentPlayers = new ArrayList<>();

    public synchronized void joinBattle(Player player) {
        while (this.currentPlayers.size() >= this.maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.currentPlayers.add(player);
    }

    public synchronized void endBattle(Player player) {
        currentPlayers.remove(player);
        notifyAll();
    }
}
