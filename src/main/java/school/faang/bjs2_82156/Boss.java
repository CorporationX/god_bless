package school.faang.bjs2_82156;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    @Getter
    private final int maxPlayer;
    private int currentPlayer;
    private final Object lock = new Object();

    public Boss(int maxPlayer) {
        this.maxPlayer = maxPlayer;
        this.currentPlayer = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            try {
                if (currentPlayer >= maxPlayer) {
                    System.out.println("Maximum player reached");
                    lock.wait();
                }
            } catch (InterruptedException e) {
                log.warn(e.toString());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            currentPlayer++;
            log.info("Player " + player.getName() + " joined the battle");
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayer--;
            log.info("Player " + player.getName() + " left the battle");
            lock.notify();
        }
    }
}
