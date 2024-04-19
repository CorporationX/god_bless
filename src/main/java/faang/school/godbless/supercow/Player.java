package faang.school.godbless.supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Player {
    private final String name;
    private Boss boss;

    public void startBattle(Boss boss) {
        this.boss = boss;
        boss.joinBattle(this);
    }
}
