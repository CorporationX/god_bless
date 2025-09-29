package school.faang.bjs2_90419;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class Player {
    private String name;

    public void doBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        log.info("Player {} is fighting..", name);
        Thread.sleep(3000);
        boss.leaveBattle(this);
    }
}
