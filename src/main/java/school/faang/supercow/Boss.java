package school.faang.supercow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Boss {

    private final int maxPlayers;
    private int currentPlayers;
    private final String bossName;

    public Boss(int maxPlayers, String bossName) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
        this.bossName = bossName;
    }

    public synchronized void joinBattle(Player player) {
        try {
            while (currentPlayers >= maxPlayers) {
                log.info("{}, ждет присоединения к битве с {}. Нет свободных слотов. Текущее количество игроков: {}. Максимальное: {}",
                        player.getName(), bossName, currentPlayers, maxPlayers);
                wait();
            }
            currentPlayers++;
            log.info("{}, присоединился к битве с {}! Текущее количество игроков: {}", player.getName(), bossName, currentPlayers);
        } catch (InterruptedException e) {
            log.warn("{}, был прерван во время ожидания битвы с {}", player.getName(), bossName);
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers > 0) {
            currentPlayers--;
            log.info("{}, покинул битву с {}. Текущее количество игроков: {}", player.getName(), bossName, currentPlayers);
            notifyAll();
        }
    }
}