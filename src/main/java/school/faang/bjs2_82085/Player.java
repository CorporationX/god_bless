package school.faang.bjs2_82085;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {
    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(5000);
            boss.leaveBattle(this);

        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
        }
    }
}
