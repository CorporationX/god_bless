package school.faang.bjs2_82125;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {
    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("але {}, дерись тварь раз уж на арену вышел", name);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.info("поток прерван во время файта");
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}
