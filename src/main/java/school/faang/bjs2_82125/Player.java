package school.faang.bjs2_82125;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("але {}, дерись тварь раз уж на арену вышел", name);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.info("поток прерван во время файта");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
