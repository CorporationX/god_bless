package school.faang.supercow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Boss {

    private final String name;
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayers >= maxPlayers) {
                log.info("Мест для сражения с боссом {} нет, игрок {} ожидает", this.getName(), player.name());
                lock.wait();
            }
            currentPlayers++;
            log.info("Добавляем игрока {} для сражения с боссом {}", player.name(), this.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers > 0) {
                log.info("Проверка на наличие игроков пройдена");
                currentPlayers--;
            }
            log.info("Игрок {} освобождает место у босса {}", player.name(), this.getName());
            lock.notify();
        }
    }
}