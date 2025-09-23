package school.faang.bjs2_90281;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private static final int MAX_PLAYERS = 3;
    private int currentPlayers;
    private final Object lock = new Object();

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= MAX_PLAYERS) {
            try {
                log.info("{} Ждёт свободный слот, чтобы присоединиться к бою", player.name());
                lock.wait();
            } catch (InterruptedException e) {
                log.info("Меня прервали в процессе ожидания");
                Thread.currentThread().interrupt();
            }
        }
        currentPlayers++;
    }

    public synchronized void leaveBattle(Player player) {
        log.info("{} Выходит из боя и освобождает слот", player.name());
        currentPlayers--;
        lock.notifyAll();
    }
}