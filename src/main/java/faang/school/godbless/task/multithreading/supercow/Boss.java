package faang.school.godbless.task.multithreading.supercow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final Set<Player> currentPlayers = new HashSet<>();
    private final int maxPlayer;

    public void joinBattle(Player player) {
        try {
            addPlayer(player);
            log.info("Игрок {} начал сражается с боссом", player.getName());
            Thread.sleep(5000);
            log.info("Игрок {} закончил сражение с боссом", player.getName());
            notifyPlayer(player);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void addPlayer(Player player) throws InterruptedException {
        synchronized (this) {
            while (currentPlayers.size() == maxPlayer) {
                this.wait();
            }
            currentPlayers.add(player);
        }
    }

    private void notifyPlayer(Player player) {
        synchronized (this) {
            currentPlayers.remove(player);
            this.notifyAll();
        }
    }
}
