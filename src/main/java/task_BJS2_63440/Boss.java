package task_BJS2_63440;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.printf("Игрок \"%s\" пока не может участвовать в сражении с боссом\n", player.getName());
                    lock.wait();
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    log.info("Thread: {} was interrupted", Thread.currentThread().getName());
                }
            }
            currentPlayers++;
            System.out.printf("Игрок \"%s\" присоединился к сражению с боссом\n", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.printf("Игрок \"%s\" вышел из сражения с боссом\n", player.getName());
            lock.notify();
        }
    }

}
