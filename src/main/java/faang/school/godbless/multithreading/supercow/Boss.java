package faang.school.godbless.multithreading.supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

@RequiredArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers;
    private final Queue<Player> currentPlayers = new LinkedList<>();

    public void joinBattle(Player player) {
        synchronized (this) {
            while (currentPlayers.size() >= maxPlayers) {
                System.out.printf("All slots are occupied. %s is waiting...\n", player.name());
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            currentPlayers.add(player);
            System.out.printf("%s is fighting with boss.\n", player.name());
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        synchronized (this) {
            currentPlayers.remove(player);
            System.out.printf("%s left the fight.\n", player.name());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.notifyAll();
        }
    }
}
