package school.faang.sprint3multythreading.supercow;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Player {
    private static final int THREAD_SLEEP = 2000;

    private final String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            log.info("{} сражается с боссом....", name);
            Thread.sleep(THREAD_SLEEP);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка во время битвы {}: \n {}", name, e.getMessage());
        } finally {
            boss.leaveBattle(this);
        }
    }
}