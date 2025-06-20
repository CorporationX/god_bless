package school.faang.bjs2_82111;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {
    private final long id;
    private String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            TimeUnit.SECONDS.sleep(5);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            log.error("Battle was interrupted for player {}", name);
        }

    }
}
