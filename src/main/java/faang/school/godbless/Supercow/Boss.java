package faang.school.godbless.Supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (currentPlayers) {
            if (currentPlayers.size() == maxPlayers) {
                currentPlayers.wait();
            }
            currentPlayers.add(player);
            System.out.println(player.getName() + " joined the battle");
        }
    }

    public void leaveBattle(Player player) {
        synchronized (currentPlayers) {
            currentPlayers.remove(player);
            System.out.println(player.getName() + " finished the battle");
            currentPlayers.notify();
        }
    }
}
