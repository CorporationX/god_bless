package school.faang.supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;

@RequiredArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    @Synchronized("lock")
    public void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.printf("%s waiting for an empty seat...", player.getName());
                System.out.println();
                lock.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.printf("%s joined the battle", player.getName());
        System.out.println();
    }

    @Synchronized("lock")
    public void leaveBattle(Player player) {
        currentPlayers--;
        System.out.printf("%s completed the battle", player.getName());
        System.out.println();
        lock.notify();
    }
}
