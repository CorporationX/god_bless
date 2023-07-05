package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public void deleteBattle(Boss boss) {
        boss.leaveBattle(this);
    }
}
