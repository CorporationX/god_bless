package school.faang.bjs2_90410;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        try {
            Thread.sleep((int) (Math.random() * 4000));
            boss.joinBattle(this);
            Thread.sleep((int) (Math.random() * 8000));
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
