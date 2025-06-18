package school.faang.module1.bjs2_82103;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {

    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("{} ждет свободного слота для сражения с боссом", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток был прерван во время ожидания", e);
                }

            }
            currentPlayers++;
            log.info("{} присоединился к сражению. Занято слотов: {}/{}", player.getName(), currentPlayers, maxPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers > 0) {
                currentPlayers--;
                log.info("{} вышел из игры. Занято слотов: {}/{}", player.getName(), currentPlayers, maxPlayers);
                lock.notify();
            }
        }
    }
}