package school.faang.m3_2_synchronized.supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@RequiredArgsConstructor
public class Player {
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("{} сражается с боссом", this.name);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        } finally {
            boss.leaveBattle(this);
        }
    }
}
