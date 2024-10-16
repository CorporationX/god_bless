package school.faang.suprcow_BJS2_36774;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
            boss.joinBattle(this);
    }
    public void endBattle(Boss boss) {
        boss.leaveBattle(this);
    }
}

