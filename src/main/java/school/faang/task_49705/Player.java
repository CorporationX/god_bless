package school.faang.task_49705;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Player {

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(1000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            log.error("Ошибка в сражении: {}", e.getMessage(), e);
        }
    }
}