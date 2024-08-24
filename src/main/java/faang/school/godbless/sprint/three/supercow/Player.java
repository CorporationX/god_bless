package faang.school.godbless.sprint.three.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(3000);
            boss.finishBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
