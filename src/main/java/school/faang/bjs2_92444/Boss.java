package school.faang.bjs2_92444;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Boss {
    private static final int MAX_PLAYER_COUNT = 3;
    private final Object lock = new Object();
    private final int maxPlayers = MAX_PLAYER_COUNT;
    private final List<Player> currentPlayers = new ArrayList<>();

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers.size() >= maxPlayers) {
                log.info("{} - ждет очереди на вход в логово босса", player.getName());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.info("Ошибка при подключении к битве");
                    return;
                }
            }
            currentPlayers.add(player);
            log.info("{} - Присоединяется к битве, его сопровождал {}",
                    player.getName(), Thread.currentThread().getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            log.info("{} - покинул битву, присоединяйтесь!", player.getName());
            currentPlayers.remove(player);
            lock.notifyAll();
        }
    }

}
