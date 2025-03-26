package school.faang.task_61635;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final Object lock = new Object();
    private static final int MAX_PLAYERS = 8;
    private int currentPlayers;

    public void joinBattle(Player player) {

        synchronized (lock) {
            try {
                while (currentPlayers >= MAX_PLAYERS) {
                    lock.wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток прерван во время ожидания игрока {}", player.getName());
            }
            currentPlayers++;
            log.info("Игрок {} присоединился к бою с босом", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("Игрок {} завершил бой с босом", player.getName());
            lock.notify();
        }
    }
}
