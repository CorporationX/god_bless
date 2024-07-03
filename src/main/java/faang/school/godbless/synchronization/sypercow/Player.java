package faang.school.godbless.synchronization.sypercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private final int TIME_ATTACK = 1000;

    public void startBattle(Boss boss) {
        boss.addPlayerToBattle(this);
        try {
            Thread.sleep(TIME_ATTACK);
        } catch (InterruptedException e) {
            log.info(String.format("Player:%s disconnect!", this.name));
        }
        boss.removePlayerFromBattle(this);
    }
}
