package school.faang.bjs273505;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            log.info("Battle started: \"{}\" vs \"{}\"", this.name, boss.getName());
            Thread.sleep(2000);
            log.info("Battle ended: \"{}\" vs \"{}\"", this.name, boss.getName());
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            log.error("Thread interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
