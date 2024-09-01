package faang.school.godbless.BJS224316;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@ToString
@Slf4j
public class Player {
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        boss.leaveBattle(this);
    }
}
