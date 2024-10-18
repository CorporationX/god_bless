package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Player {

    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("Caught exception", e);
            throw new IllegalStateException(
                    String.format("Thread %s interrupted", Thread.currentThread().getName()), e
            );
        }
        boss.leaveBattle(this);
    }
}
