package school.faang.bjs249777;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    public final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public void finishBattle(Boss boss) {
        boss.leaveBattle(this);
    }
}
