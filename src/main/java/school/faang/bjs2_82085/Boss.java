package school.faang.bjs2_82085;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        try {
            if (currentPlayers >= maxPlayers) {
                log.info("Все слоты заняты. Ожидаем");
                wait();
            }
            currentPlayers++;
            log.info("Игрок {} присоединился к битве", player.name());

        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Игрок {} покинул битву", player.name());
        notify();
    }
}
