package school.faang.supercow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            log.info("{} сражается с боссом ", name);
            Thread.sleep(2000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("{} был прерван", name);
        }
    }
}