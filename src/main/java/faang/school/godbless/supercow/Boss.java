package faang.school.godbless.supercow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers == maxPlayers) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
            currentPlayers++;
        }
        System.out.println("Player " + player.getName() + " ready to battle...");
        inBattle(player);
        synchronized (lock) {
            currentPlayers--;
            System.out.println("Player " + player.getName() + " end battle");
            lock.notify();
        }

    }

    private void inBattle(Player player) {
        System.out.println("Player " + player.getName() + " in battle");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
