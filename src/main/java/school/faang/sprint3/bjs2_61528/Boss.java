package school.faang.sprint3.bjs2_61528;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Boss {
    private final int maxCapacity = 100;
    private final int minCapacity = 1;
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        if (maxPlayers < getMinCapacity() || maxPlayers > getMaxCapacity()) {
            log.error(String.format("Максимальное количество игроков не может быть меньше %d, или больше %d",
                    getMinCapacity(), getMaxCapacity()));
            throw new IllegalArgumentException("Введено неккоректное значение максимальных игроков");
        }
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(@NonNull Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info(String.format("Извините %s, на текущий момент нет мест для сражения с боссом: %d/%d",
                            player.getName(), getCurrentPlayers(), getMaxPlayers()));
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("Ожидание прервано{}", e.getMessage());
                    Thread.currentThread().interrupt();
                }

            }
            currentPlayers++;
            log.info(String.format("%s присоединился к битве с боссом", player.getName()));
        }
    }

    public void leaveBattle(@NonNull Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info(String.format("%s завершил сражение с боссом!", player.getName()));
            lock.notifyAll();
        }
    }
}
