package school.faang.supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final List<Player> players = new ArrayList<>();

    public synchronized void joinBattle(Player player) {
        if (currentPlayers == maxPlayers) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        players.add(player);
    }

    public synchronized void leaveBattle(Player player) {
        players.remove(player);
        currentPlayers--;
        this.notifyAll();
    }
}
