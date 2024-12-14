package faang.school.godbless.modul3.supercow;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers.size() <= maxPlayers) {
            currentPlayers.add(player);
            System.out.println("New player: " + player);
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void endPlaying(Player player) {
        currentPlayers.remove(player);
        System.out.println("Remove player: " + player);
        notify();
    }
}
