package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Player {
    private static final int MAX_TIME_BATTLE = 7000;
    private static final int MIN_TIME_BATTLE = 3000;

    private String name;

    public void doBattle(Boss boss) throws InterruptedException {
        Objects.requireNonNull(boss, "Boss doesn't exist");
        boss.joinBattle(this);
        Thread.sleep((long) (Math.random() * MAX_TIME_BATTLE + MIN_TIME_BATTLE));
        boss.leaveBattle(this);
    }
}
