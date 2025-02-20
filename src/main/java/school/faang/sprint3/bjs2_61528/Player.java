package school.faang.sprint3.bjs2_61528;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Player {
    private final String name;

    public Player(@NonNull String name) {
        if (name.isBlank()) {
            log.error("Введено пустое имя");
            throw new IllegalArgumentException("Введено пустое имя");
        }
        this.name = name;
    }

    public void doBattle(@NonNull Boss boss) {
        try {
            boss.joinBattle(this);
            log.info(String.format("%s: пиу пиу", getName()));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(String.format("Ошибка %s во время сражения игрока %s", e.getMessage(), getName()));
            Thread.currentThread().interrupt();
        } finally {
            if (boss.getCurrentPlayers() > 0) {
                boss.leaveBattle(this);
            }
        }
    }
}
