package faang.school.godbless.Supercow;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Slf4j
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        if (boss.joinBattle(this)) {
            log.info("Player {} is fighting.", name);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(e.getMessage());
            } finally {
                boss.leaveBattle(this);
            }
        }
    }
}