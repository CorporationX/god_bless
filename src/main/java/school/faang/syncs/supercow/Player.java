package school.faang.syncs.supercow;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j
@AllArgsConstructor
public class Player {

    private static final int FIGHT_TIME_MS = 10000;

    private final String name;

    public void doBattle(Boss boss) throws InterruptedException {
        try {
            boss.joinBattle(this);
            log.info("Participating in a boss fight for 10 sec");
            Thread.sleep(FIGHT_TIME_MS);
            boss.leaveBattle(this);
        } catch (InterruptedException exception) {
            log.info("Player fight was interrupted!");
            Thread.currentThread().interrupt();
        }
    }
}
