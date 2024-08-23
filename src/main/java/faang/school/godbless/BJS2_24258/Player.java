package faang.school.godbless.BJS2_24258;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private final Boss boss;

    public void startBattle() {
        boss.joinBattle(this);
    }

    public void endBattle() {
        boss.leaveBattle(this);
    }
}
