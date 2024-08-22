package faang.school.godbless.sprint3.supercow;

import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class Boss {
    private final Set<Player> currentPlayers;
    private final int maxPlayers;

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (currentPlayers) {
            if (currentPlayers.size() == maxPlayers) {
                currentPlayers.wait();
            }
            currentPlayers.add(player);
        }
    }

    public void exitBattle(Player player) {
        synchronized (currentPlayers) {
            currentPlayers.remove(player);
            currentPlayers.notify();
        }
    }
}
