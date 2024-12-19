package school.faang.task_49656;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public void endBattle(Boss boss) {
        boss.leaveBattle(this);
    }
}
