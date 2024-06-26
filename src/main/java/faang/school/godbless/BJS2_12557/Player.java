package faang.school.godbless.BJS2_12557;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
            boss.joinBattle(this);
            boss.leaveBattle(this);
    }
}
