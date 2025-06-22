package school.faang.bjs2_82156;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("{} fighting with boss", name);
            Thread.sleep(5000);
        }  catch (InterruptedException e) {
            log.warn("{} fight was interrupted", name);
            Thread.currentThread().interrupt();
            throw  new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
