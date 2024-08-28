package faang.school.godbless.BJS2_24258;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();

    public synchronized void joinBattle(Player player) {
        while (currentPlayers.size() == maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Wait error");
            }
        }
        currentPlayers.add(player);
        System.out.println("Player " + player.getName() + " join to the battle");
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers.contains(player)) {
            currentPlayers.remove(player);
            System.out.println("Player " + player.getName() + " leave the battle");
            notifyAll();
        }
    }
}
