package school.faang.bjs2_92444;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Player {
    private static final int TIME_SLEEP = 1000;
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(TIME_SLEEP);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Ошибка в имитации битвы");
        }
        boss.leaveBattle(this);
    }
}
