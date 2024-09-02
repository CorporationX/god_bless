package faang.school.godbless.Supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(2000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
