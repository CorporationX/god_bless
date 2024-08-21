package faang.school.godbless.thirdsprint.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Player {
    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep((long) (Math.random() * 15000));
        } catch (InterruptedException e) {
            log.error("Interrupted exception: {}", e.getMessage());
        }
        boss.leaveBattle(this);
    }
}
