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

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (currentPlayers.size() == maxPlayers) {
            currentPlayers.wait();
        }
        currentPlayers.add(player);
        System.out.println(player.getName() + " joined the battle");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers.remove(player);
        System.out.println(player.getName() + " finished the battle");
        currentPlayers.notify();
    }
}
