package school.faang.module3.supercow;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private List<Player> currentPlayers = new ArrayList<>();

    public void joinBattle(Player player) {
        synchronized (currentPlayers) {
            if (currentPlayers.size() == maxPlayers) {
                System.out.println("wait for a spot in the battle to be vacated.");
                try {
                    currentPlayers.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }

            currentPlayers.add(player);
            System.out.printf("player \"%s\" joined to the battle\n", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (currentPlayers) {
            currentPlayers.remove(player);
            currentPlayers.notify();
            System.out.printf("player \"%s\" leaved the battle\n", player.getName());
        }
    }
}
