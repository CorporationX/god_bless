package school.faang.task_49701;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final Integer maxPlayers;
    private Integer currentPlayers;

    public Boss(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers == maxPlayers) {
            try {
                log.info("В битве максимальное количество игроков, ожидаем свободное место...");
                wait();
            } catch (InterruptedException e) {
                log.error("Поток был прерван во время выполнения метода wait()", e);
            }
        }
        currentPlayers++;
        log.info("Игрок {} присоединился к битве", player.getName());
    }

    public synchronized void leaveFromBattle(Player player) {
        currentPlayers--;
        log.info("Игрок {} покинул битву", player.getName());
        notify();
    }
}
