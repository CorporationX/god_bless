package faang.school.godbless.synchronizationWaitNotify.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void completeBattle(Boss boss) {
        try {
            boss.completeBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
