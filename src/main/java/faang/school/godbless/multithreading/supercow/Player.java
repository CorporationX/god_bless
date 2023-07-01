package faang.school.godbless.multithreading.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public void stopBattle(Boss boss) {
        boss.leaveBattle(this);
    }
}
