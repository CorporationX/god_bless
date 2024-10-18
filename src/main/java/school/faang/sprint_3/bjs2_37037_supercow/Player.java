package school.faang.sprint_3.bjs2_37037_supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("{} сражается с боссом", this.getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("Произошла ошибка во время сражения с боссом!");
            throw new RuntimeException(e);
        }
        boss.leaveBattle(this);
    }
}
