package school.faang.bjs2_90395;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("игрок {} сражается с боссом...", name);
            Thread.sleep(5000);
            log.info("игрок {} выполнил квест", name);
        } catch (InterruptedException e) {
            log.info("игрок был прерван во время сражения");
            Thread.currentThread().interrupt();
        }
        boss.leaveBattle(this);
    }
}
