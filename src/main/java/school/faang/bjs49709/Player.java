package school.faang.bjs49709;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {
    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        log.info("{} entered boss {}", name, boss);
        Thread.sleep(2000);
        boss.exitBattle(this);
        log.info("{} exited boss {}", name, boss);
    }
}
