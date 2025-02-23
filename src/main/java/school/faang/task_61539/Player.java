package school.faang.task_61539;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info(name + " сражается с боссом...");
            Thread.sleep(500); // Имитируем время боя
        } catch (InterruptedException e) {
            log.info(name + " был прерван во время сражения.");
            Thread.currentThread().interrupt(); // Восстанавливаем флаг прерывания
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
